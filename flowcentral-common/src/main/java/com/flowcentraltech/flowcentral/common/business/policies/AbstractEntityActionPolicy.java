/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.business.policies;

import com.flowcentraltech.flowcentral.common.business.ApplicationPrivilegeManager;
import com.flowcentraltech.flowcentral.common.business.EnvironmentService;
import com.tcdng.unify.core.AbstractUnifyComponent;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Configurable;

/**
 * Convenient abstract base class for entity action policies.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractEntityActionPolicy extends AbstractUnifyComponent implements EntityActionPolicy {

    @Configurable
    private ApplicationPrivilegeManager applicationPrivilegeManager;

    @Configurable
    private EnvironmentService environment;

    public final void setApplicationPrivilegeManager(ApplicationPrivilegeManager applicationPrivilegeManager) {
        this.applicationPrivilegeManager = applicationPrivilegeManager;
    }

    public final void setEnvironment(EnvironmentService environment) {
        this.environment = environment;
    }

    @Override
    public final void executePreAction(EntityActionContext ctx) throws UnifyException {
        if (checkAppliesTo(ctx.getInst())) {
            doExecutePreAction(ctx);
        }
    }

    @Override
    public final EntityActionResult executePostAction(EntityActionContext ctx) throws UnifyException {
        EntityActionResult entityActionResult = null;
        if (checkAppliesTo(ctx.getInst())) {
            entityActionResult = doExecutePostAction(ctx);
        }

        if (entityActionResult == null) {
            return new EntityActionResult(ctx);
        }

        return entityActionResult;
    }

    @Override
    protected void onInitialize() throws UnifyException {

    }

    @Override
    protected void onTerminate() throws UnifyException {

    }

    protected final EnvironmentService environment() {
        return environment;
    }

    protected void registerPrivilege(Long applicationId, String privilegeCategoryCode, String privilegeCode,
            String privilegeDesc) throws UnifyException {
        applicationPrivilegeManager.registerPrivilege(applicationId, privilegeCategoryCode, privilegeCode,
                privilegeDesc);
    }

    protected void unregisterPrivilege(Long applicationId, String privilegeCategoryCode, String privilegeCode)
            throws UnifyException {
        applicationPrivilegeManager.unregisterPrivilege(applicationId, privilegeCategoryCode, privilegeCode);
    }

    protected boolean assignPrivilegeToRole(String roleCode, String privilegeCode)
            throws UnifyException {
        return applicationPrivilegeManager.assignPrivilegeToRole(roleCode, privilegeCode);
    }

    protected abstract void doExecutePreAction(EntityActionContext ctx) throws UnifyException;

    protected abstract EntityActionResult doExecutePostAction(EntityActionContext ctx) throws UnifyException;

}
