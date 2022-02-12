/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.policies;

import com.flowcentraltech.flowcentral.application.business.ApplicationModuleService;
import com.flowcentraltech.flowcentral.common.business.EnvironmentService;
import com.tcdng.unify.core.AbstractUnifyComponent;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.criterion.IsNull;
import com.tcdng.unify.core.criterion.Restriction;

/**
 * Convenient abstract base class for entity based filter generator policies.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractEntityBasedFilterGenerator extends AbstractUnifyComponent
        implements EntityBasedFilterGenerator {

    private static final Restriction ID_NULL_RESTRICTION = new IsNull("id");
    
    @Configurable
    private ApplicationModuleService applicationModuleService;
    
    @Configurable
    private EnvironmentService environmentService;
    
    public void setApplicationModuleService(ApplicationModuleService applicationModuleService) {
        this.applicationModuleService = applicationModuleService;
    }

    public void setEnvironmentService(EnvironmentService environmentService) {
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

    protected Restriction noRestriction() {
        return null;
    }

    protected Restriction noRecordsRestriction() {
        return ID_NULL_RESTRICTION;
    }
}
