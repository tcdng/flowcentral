/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.business.policies;

import com.flowcentraltech.flowcentral.application.entities.BaseApplicationEntity;
import com.flowcentraltech.flowcentral.application.util.ApplicationCollaborationUtils;
import com.flowcentraltech.flowcentral.application.util.ApplicationNameUtils;
import com.flowcentraltech.flowcentral.common.business.RequestUserPhotoGenerator;
import com.flowcentraltech.flowcentral.common.business.policies.AbstractCollaborationEntityActionPolicy;
import com.flowcentraltech.flowcentral.common.business.policies.EntityActionContext;
import com.flowcentraltech.flowcentral.common.business.policies.EntityActionResult;
import com.flowcentraltech.flowcentral.common.constants.CollaborationType;
import com.flowcentraltech.flowcentral.common.constants.FlowCentralSessionAttributeConstants;
import com.flowcentraltech.flowcentral.common.data.CollaborationLockInfo;
import com.flowcentraltech.flowcentral.common.data.CollaborationLockedResourceInfo;
import com.flowcentraltech.flowcentral.security.business.SecurityModuleService;
import com.flowcentraltech.flowcentral.security.entities.User;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.database.Entity;

/**
 * Studio lock resource action policy.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component(name = "lockresource-actionpolicy", description = "$m{studio.entityactionpolicy.lockresource}")
public class StudioLockResourceActionPolicy extends AbstractCollaborationEntityActionPolicy {

    @Configurable
    private SecurityModuleService securityModuleService;

    @Configurable
    private RequestUserPhotoGenerator requestUserPhotoGenerator;

    public void setSecurityModuleService(SecurityModuleService securityModuleService) {
        this.securityModuleService = securityModuleService;
    }

    public void setRequestUserPhotoGenerator(RequestUserPhotoGenerator requestUserPhotoGenerator) {
        this.requestUserPhotoGenerator = requestUserPhotoGenerator;
    }

    @Override
    public boolean checkAppliesTo(Entity inst) throws UnifyException {
        final BaseApplicationEntity _appInst = (BaseApplicationEntity) inst;
        if (isLicensedForCollaboration()) {
            final CollaborationType type = ApplicationCollaborationUtils.getCollaborationType(_appInst.getClass());
            if (type != null) {
                final String resourceName = ApplicationNameUtils
                        .getApplicationEntityLongName(_appInst.getApplicationName(), _appInst.getName());
                return !getCollaborationProvider().isLockedBy(type, resourceName, getUserToken().getUserLoginId());
            }
        }

        return false;
    }

    @Override
    protected void doExecutePreAction(EntityActionContext ctx) throws UnifyException {

    }

    @Override
    protected EntityActionResult doExecutePostAction(EntityActionContext ctx) throws UnifyException {
        final BaseApplicationEntity _appInst = (BaseApplicationEntity) ctx.getInst();
        final CollaborationType type = ApplicationCollaborationUtils.getCollaborationType(_appInst.getClass());
        final String resourceName = ApplicationNameUtils.getApplicationEntityLongName(_appInst.getApplicationName(),
                _appInst.getName());
        if (!getCollaborationProvider().lock(type, resourceName, getUserToken().getUserLoginId())) {
            CollaborationLockInfo collaborationLockInfo = getCollaborationProvider().getLockInfo(type, resourceName);
            if (collaborationLockInfo != null) {
                User user = securityModuleService.findUser(collaborationLockInfo.getLockedBy());
                String branchDesc = user.getBranchDesc() == null ? getSessionMessage("application.no.branch")
                        : user.getBranchDesc();
                CollaborationLockedResourceInfo collaborationLockedResourceInfo = new CollaborationLockedResourceInfo(
                        requestUserPhotoGenerator, type, resourceName, collaborationLockInfo.getLockedBy(),
                        user.getFullName(), branchDesc, collaborationLockInfo.getLockDate());
                setSessionAttribute(FlowCentralSessionAttributeConstants.LOCKED_RESOURCEOPTIONS,
                        collaborationLockedResourceInfo);
                return new EntityActionResult(ctx, "/application/commonutilities/showLockedResource");
            }
        }

        return null;
    }

}
