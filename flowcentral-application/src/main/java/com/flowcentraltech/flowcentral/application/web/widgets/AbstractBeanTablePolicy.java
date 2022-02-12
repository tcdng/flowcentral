/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.web.widgets;

import com.flowcentraltech.flowcentral.application.business.ApplicationModuleService;
import com.flowcentraltech.flowcentral.common.business.EnvironmentService;
import com.tcdng.unify.core.AbstractUnifyComponent;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Configurable;

/**
 * Convenient abstract base class for bean table policies.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractBeanTablePolicy extends AbstractUnifyComponent implements BeanTablePolicy {

    @Configurable
    private ApplicationModuleService applicationModuleervice;

    @Configurable
    private EnvironmentService environmentService;

    public final void setApplicationModuleervice(ApplicationModuleService applicationModuleervice) {
        this.applicationModuleervice = applicationModuleervice;
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
        return applicationModuleervice;
    }

    protected EnvironmentService environment() {
        return environmentService;
    }

}
