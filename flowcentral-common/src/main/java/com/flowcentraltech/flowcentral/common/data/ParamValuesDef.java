/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.data.ParamConfig;
import com.tcdng.unify.core.util.DataUtils;

/**
 * Application parameter values definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ParamValuesDef {

    private List<ParamValueDef> paramValueList;

    private Map<String, Object> values;

    private ParamValuesDef(List<ParamValueDef> paramValueList) {
        this.paramValueList = paramValueList;
    }

    public List<ParamValueDef> getParamValueList() {
        return paramValueList;
    }

    public Map<String, Object> getValueMap() throws UnifyException {
        if (values == null) {
            values = new HashMap<String, Object>();
            for (ParamValueDef paramValueDef : paramValueList) {
                values.put(paramValueDef.getParamName(), paramValueDef.getConvertedParamVal());
            }
        }

        return values;
    }

    public boolean isBlank() {
        return paramValueList == null || paramValueList.isEmpty();
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {

        private List<ParamValueDef> paramValueList;

        public Builder() {
            paramValueList = new ArrayList<ParamValueDef>();
        }

        public Builder addParamValueDef(ParamConfig paramConfig, String paramVal) {
            paramValueList.add(new ParamValueDef(paramConfig, paramVal));
            return this;
        }

        public ParamValuesDef build() throws UnifyException {
            return new ParamValuesDef(DataUtils.unmodifiableList(paramValueList));
        }
    }
}
