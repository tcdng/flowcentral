/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.business;

import com.flowcentraltech.flowcentral.common.business.EnvironmentService;
import com.tcdng.unify.core.AbstractUnifyComponent;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Configurable;

/**
 * Convenient abstract base class for entity matchers.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractEntityMatcher extends AbstractUnifyComponent implements EntityMatcher {

    @Configurable
    private ApplicationModuleService applicationModuleService;

    @Configurable
    private EnvironmentService environmentService;

    public final void setApplicationModuleService(ApplicationModuleService applicationModuleService) {
        this.applicationModuleService = applicationModuleService;
    }

    public final void setEnvironmentService(EnvironmentService environmentService) {
        this.environmentService = environmentService;
    }

    @Override
    protected void onInitialize() throws UnifyException {

    }

    @Override
    protected void onTerminate() throws UnifyException {

    }

    protected ApplicationModuleService applicationService() {
        return applicationModuleService;
    }

    protected EnvironmentService environment() {
        return environmentService;
    }

}
