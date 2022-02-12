/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.policies;

import java.util.List;

import com.flowcentraltech.flowcentral.application.business.ApplicationModuleService;
import com.flowcentraltech.flowcentral.common.business.EnvironmentService;
import com.flowcentraltech.flowcentral.common.business.policies.ConsolidatedFormValidationPolicy;
import com.flowcentraltech.flowcentral.common.data.TargetFormMessage;
import com.flowcentraltech.flowcentral.common.data.TargetFormMessages;
import com.tcdng.unify.core.AbstractUnifyComponent;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.data.ValueStore;

/**
 * Convenient abstract base class for consolidated for validation policies.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractApplicationConsolidatedFormValidationPolicy extends AbstractUnifyComponent
        implements ConsolidatedFormValidationPolicy {

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
    public final List<TargetFormMessage> validate(ValueStore instValueStore) throws UnifyException {
        TargetFormMessages messages = new TargetFormMessages();
        validate(instValueStore, messages);
        return messages.getMessages();
    }

    protected abstract void validate(ValueStore instValueStore, TargetFormMessages messages) throws UnifyException;

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
