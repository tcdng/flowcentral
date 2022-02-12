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
import com.flowcentraltech.flowcentral.common.business.policies.AbstractCollaborationEntityActionPolicy;
import com.flowcentraltech.flowcentral.common.business.policies.EntityActionContext;
import com.flowcentraltech.flowcentral.common.business.policies.EntityActionResult;
import com.flowcentraltech.flowcentral.common.constants.CollaborationType;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.database.Entity;

/**
 * Studio unlock resource action policy.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component(name = "unlockresource-actionpolicy", description = "$m{studio.entityactionpolicy.unlockresource}")
public class StudioUnlockResourceActionPolicy extends AbstractCollaborationEntityActionPolicy {

    @Override
    public boolean checkAppliesTo(Entity inst) throws UnifyException {
        final BaseApplicationEntity _appInst = (BaseApplicationEntity) inst;
        if (isLicensedForCollaboration()) {
            final CollaborationType type = ApplicationCollaborationUtils.getCollaborationType(_appInst.getClass());
            if (type != null) {
                final String resourceName = ApplicationNameUtils
                        .getApplicationEntityLongName(_appInst.getApplicationName(), _appInst.getName());
                return getCollaborationProvider().isLockedBy(type, resourceName, getUserToken().getUserLoginId());
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
        final String resourceName = ApplicationNameUtils
                .getApplicationEntityLongName(_appInst.getApplicationName(), _appInst.getName());
        getCollaborationProvider().unlock(type, resourceName, getUserToken().getUserLoginId());
        return null;
    }

}
