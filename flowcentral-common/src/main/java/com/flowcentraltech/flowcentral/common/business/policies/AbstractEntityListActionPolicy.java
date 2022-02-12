/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.business.policies;

import com.tcdng.unify.core.AbstractUnifyComponent;
import com.tcdng.unify.core.UnifyException;

/**
 * Convenient abstract base class for entity list action policies.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractEntityListActionPolicy extends AbstractUnifyComponent implements EntityListActionPolicy {

    @Override
    protected void onInitialize() throws UnifyException {

    }

    @Override
    protected void onTerminate() throws UnifyException {

    }

}
