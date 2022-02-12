/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.data;

import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.data.ParamConfig;
import com.tcdng.unify.core.util.DataUtils;

/**
 * Application parameter value definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ParamValueDef {

    private ParamConfig paramConfig;

    private String paramVal;

    public ParamValueDef(ParamConfig paramConfig, String paramVal) {
        this.paramConfig = paramConfig;
        this.paramVal = paramVal;
    }

    public ParamConfig getParamConfig() {
        return paramConfig;
    }

    public String getParamName() {
        return paramConfig.getParamName();
    }

    public String getParamVal() {
        return paramVal;
    }

    public Object getConvertedParamVal() throws UnifyException {
        return DataUtils.convert(paramConfig.getType(), paramVal);
    }

    public <T> T getConvertedParamVal(Class<T> clazz) throws UnifyException {
        return DataUtils.convert(clazz, paramVal);
    }

    @Override
    public String toString() {
        return "ParamValueDef [paramConfig=" + paramConfig + ", paramVal=" + paramVal + "]";
    }
}
