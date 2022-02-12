/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.policies;

import com.flowcentraltech.flowcentral.application.business.ApplicationModuleService;
import com.flowcentraltech.flowcentral.common.business.EnvironmentService;
import com.flowcentraltech.flowcentral.common.business.policies.ConsolidatedFormStatePolicy;
import com.flowcentraltech.flowcentral.common.data.TargetFormTabStates;
import com.flowcentraltech.flowcentral.common.data.TargetFormWidgetStates;
import com.tcdng.unify.core.AbstractUnifyComponent;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.data.ValueStore;

/**
 * Convenient abstract base class for consolidated form state policies.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractApplicationConsolidatedFormStatePolicy extends AbstractUnifyComponent
        implements ConsolidatedFormStatePolicy {

    @Configurable
    private ApplicationModuleService applicationModuleService;

    @Configurable
    private EnvironmentService environmentService;

    public final void setEnvironmentService(EnvironmentService environmentService) {
        this.environmentService = environmentService;
    }

    public final void setApplicationModuleService(ApplicationModuleService applicationModuleService) {
        this.applicationModuleService = applicationModuleService;
    }

    @Override
    public final TargetFormTabStates evaluateTabStates(ValueStore instValueStore, String trigger)
            throws UnifyException {
        TargetFormTabStates states = new TargetFormTabStates();
        evaluateTabStates(instValueStore, trigger, states);
        return states;
    }

    @Override
    public final TargetFormWidgetStates evaluateWidgetStates(ValueStore instValueStore, String trigger)
            throws UnifyException {
        TargetFormWidgetStates states = new TargetFormWidgetStates();
        evaluateWidgetStates(instValueStore, trigger, states);
        return states;
    }

    protected abstract void evaluateTabStates(ValueStore instValueStore, String trigger,
            TargetFormTabStates states) throws UnifyException;

    protected abstract void evaluateWidgetStates(ValueStore instValueStore, String trigger,
            TargetFormWidgetStates states) throws UnifyException;

    protected EnvironmentService environment() {
        return environmentService;
    }

    protected ApplicationModuleService applicationService() {
        return applicationModuleService;
    }

    @Override
    protected void onInitialize() throws UnifyException {

    }

    @Override
    protected void onTerminate() throws UnifyException {

    }

}
