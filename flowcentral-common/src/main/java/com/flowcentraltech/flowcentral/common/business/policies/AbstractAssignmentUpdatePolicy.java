/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.business.policies;

import com.flowcentraltech.flowcentral.common.business.EnvironmentService;
import com.tcdng.unify.core.AbstractUnifyComponent;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Configurable;

/**
 * Convenient abstract base class for assignment update policies.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractAssignmentUpdatePolicy extends AbstractUnifyComponent implements AssignmentUpdatePolicy {

    @Configurable
    private EnvironmentService environmentService;

    public final void setEnvironmentService(EnvironmentService environmentService) {
        this.environmentService = environmentService;
    }
    
    protected EnvironmentService environment() {
        return environmentService;
    }

    @Override
    protected void onInitialize() throws UnifyException {

    }

    @Override
    protected void onTerminate() throws UnifyException {

    }

}
