/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.validation;

import com.tcdng.unify.core.AbstractUnifyComponent;
import com.tcdng.unify.core.UnifyException;

/**
 * Convenient abstract base class for validators.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractValidator extends AbstractUnifyComponent implements Validator {

    private String failureMsg;

    public AbstractValidator(String failureMsg) {
        this.failureMsg = failureMsg;
    }

    @Override
    public boolean validate(Object val) throws UnifyException {
        return validate(null, val);
    }

    @Override
    public String getFailureMessage(String rule, Object... params) throws UnifyException {
        return resolveApplicationMessage(failureMsg, params);
    }

    @Override
    protected void onInitialize() throws UnifyException {

    }

    @Override
    protected void onTerminate() throws UnifyException {

    }

}
