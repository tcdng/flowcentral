/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.policies;

import com.flowcentraltech.flowcentral.application.business.ApplicationModuleService;
import com.flowcentraltech.flowcentral.common.business.policies.AbstractAssignmentUpdatePolicy;
import com.tcdng.unify.core.annotation.Configurable;

/**
 * Convenient abstract base class for application assignment update policies.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractApplicationAssignmentUpdatePolicy extends AbstractAssignmentUpdatePolicy {

    @Configurable
    private ApplicationModuleService applicationModuleService;

    public final void setApplicationModuleService(ApplicationModuleService applicationModuleService) {
        this.applicationModuleService = applicationModuleService;
    }

    protected ApplicationModuleService applicationService() {
        return applicationModuleService;
    }

}
