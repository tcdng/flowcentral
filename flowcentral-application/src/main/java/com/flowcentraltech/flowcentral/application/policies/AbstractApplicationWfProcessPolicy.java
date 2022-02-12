/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.policies;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

import com.flowcentraltech.flowcentral.application.business.ApplicationModuleService;
import com.flowcentraltech.flowcentral.common.business.EnvironmentService;
import com.flowcentraltech.flowcentral.common.business.policies.AbstractWfProcessPolicy;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.data.Listable;

/**
 * Convenient abstract base class for application workflow process policies.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractApplicationWfProcessPolicy extends AbstractWfProcessPolicy {

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

    protected ApplicationModuleService applicationService() {
        return applicationModuleService;
    }
    
    protected EnvironmentService environment() {
        return environmentService;
    }

    @Override
    public List<? extends Listable> getRuleList(Locale locale) throws UnifyException {
        return Collections.emptyList();
    }

}
