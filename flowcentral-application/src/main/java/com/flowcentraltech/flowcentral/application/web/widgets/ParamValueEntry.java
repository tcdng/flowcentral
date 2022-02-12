/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.widgets;

import com.flowcentraltech.flowcentral.common.input.AbstractInput;
import com.flowcentraltech.flowcentral.common.util.CommonInputUtils;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.data.ParamConfig;

/**
 * Parameter value entry.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ParamValueEntry {

    private ParamConfig paramConfig;

    private AbstractInput<?> paramInput;

    public ParamValueEntry(ParamConfig paramConfig) {
        this.paramConfig = paramConfig;
    }

    public ParamConfig getParamConfig() {
        return paramConfig;
    }

    public AbstractInput<?> getParamInput() {
        return paramInput;
    }

    public boolean isWithParamInput() {
        return paramInput != null;
    }

    public void normalize() throws UnifyException {
        paramInput = paramInput != null ? paramInput : CommonInputUtils.newInput(paramConfig);
    }

    @Override
    public String toString() {
        return "ParamValueEntry [paramConfig=" + paramConfig + ", paramInput=" + paramInput + "]";
    }

}
