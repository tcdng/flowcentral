/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.common.business;

import java.util.List;

import com.flowcentraltech.flowcentral.common.business.policies.EntityActionContext;
import com.flowcentraltech.flowcentral.common.business.policies.EntityActionPolicy;
import com.flowcentraltech.flowcentral.common.business.policies.EntityActionResult;
import com.flowcentraltech.flowcentral.configuration.data.ModuleInstall;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.business.AbstractBusinessService;

/**
 * Base class for flowCentral service.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractFlowCentralService extends AbstractBusinessService implements FlowCentralService {

    @Configurable
    private EnvironmentService environmentService;

    public void setEnvironmentService(EnvironmentService environmentService) {
        this.environmentService = environmentService;
    }

    @Override
    public final void installFeatures(List<ModuleInstall> moduleInstallList) throws UnifyException {
        for (ModuleInstall moduleInstall : moduleInstallList) {
            doInstallModuleFeatures(moduleInstall);
        }
    }

    protected final EnvironmentService environment() {
        return environmentService;
    }

    protected void executeEntityPreActionPolicy(EntityActionContext ctx) throws UnifyException {
        if (ctx.isWithActionPolicy()) {
            ((EntityActionPolicy) getComponent(ctx.getActionPolicyName())).executePreAction(ctx);
        }
    }

    protected EntityActionResult executeEntityPostActionPolicy(EntityActionContext ctx) throws UnifyException {
        if (ctx.isWithSweepingCommitPolicy()) {
            ctx.getSweepingCommitPolicy().bumpAllParentVersions(db(), ctx.getActionType());
        }

        if (ctx.isWithActionPolicy()) {
            return ((EntityActionPolicy) getComponent(ctx.getActionPolicyName())).executePostAction(ctx);
        }

        return new EntityActionResult(ctx);
    }

    protected abstract void doInstallModuleFeatures(ModuleInstall moduleInstall) throws UnifyException;

}
