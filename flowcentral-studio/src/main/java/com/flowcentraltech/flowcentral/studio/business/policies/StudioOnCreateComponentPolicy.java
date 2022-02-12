/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.business.policies;

import com.flowcentraltech.flowcentral.application.entities.BaseApplicationEntity;
import com.flowcentraltech.flowcentral.application.util.ApplicationPageUtils;
import com.flowcentraltech.flowcentral.common.business.policies.EntityActionContext;
import com.flowcentraltech.flowcentral.common.business.policies.EntityActionResult;
import com.flowcentraltech.flowcentral.studio.constants.StudioAppComponentType;
import com.flowcentraltech.flowcentral.studio.constants.StudioSessionAttributeConstants;
import com.flowcentraltech.flowcentral.studio.util.StudioNameUtils;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.database.Entity;

/**
 * Studio on create component policy.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("studiooncreatecomponent-policy")
public class StudioOnCreateComponentPolicy extends AbstractStudioEntityActionPolicy {

    @Override
    public boolean checkAppliesTo(Entity inst) throws UnifyException {
        return true;
    }

    @Override
    protected void doExecutePreAction(EntityActionContext ctx) throws UnifyException {

    }

    @SuppressWarnings("unchecked")
    @Override
    protected EntityActionResult doExecutePostAction(EntityActionContext ctx) throws UnifyException {
        String applicationName = (String) getSessionAttribute(StudioSessionAttributeConstants.CURRENT_APPLICATION_NAME);
        Long applicationId = (Long) getSessionAttribute(StudioSessionAttributeConstants.CURRENT_APPLICATION_ID);
        StudioAppComponentType type = StudioAppComponentType
                .fromEntityClass((Class<? extends BaseApplicationEntity>) ctx.getInst().getClass());
        // Register instance as privilege based on type
        registerPrivilege(applicationName, applicationId, type, (BaseApplicationEntity) ctx.getInst());

        // Set result path
        String appletName = StudioNameUtils.getStudioAppletName(applicationName, type, (Long) ctx.getInst().getId());
        String path = ApplicationPageUtils.constructAppletReplacePagePath(type.appletPath(), appletName);
        EntityActionResult result = new EntityActionResult(ctx, path);
        result.setRefreshMenu(true);
        return result;
    }
}
