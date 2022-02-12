/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.policies;

import com.flowcentraltech.flowcentral.application.business.ApplicationModuleService;
import com.flowcentraltech.flowcentral.common.business.policies.AbstractEntityActionPolicy;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.database.Entity;

/**
 * Convenient abstract application entity action policy.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractApplicationEntityActionPolicy extends AbstractEntityActionPolicy {

    @Configurable
    private ApplicationModuleService applicationModuleService;

    public final void setApplicationModuleService(ApplicationModuleService applicationModuleService) {
        this.applicationModuleService = applicationModuleService;
    }

    @Override
    public boolean checkAppliesTo(Entity inst) throws UnifyException {
        return true;
    }

    protected void registerPrivilege(String applicationName, String privilegeCategoryCode, String privilegeCode,
            String privilegeDesc) throws UnifyException {
        final Long applicationId = applicationModuleService.getApplicationDef(applicationName).getId();
        registerPrivilege(applicationId, privilegeCategoryCode, privilegeCode, privilegeDesc);
    }

    protected void unregisterPrivilege(String applicationName, String privilegeCategoryCode, String privilegeCode)
            throws UnifyException {
        final Long applicationId = applicationModuleService.getApplicationDef(applicationName).getId();
        unregisterPrivilege(applicationId, privilegeCategoryCode, privilegeCode);
    }

    protected ApplicationModuleService applicationService() {
        return applicationModuleService;
    }

}
