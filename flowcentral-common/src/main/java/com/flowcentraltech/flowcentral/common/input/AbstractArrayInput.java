/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.common.input;

import com.flowcentraltech.flowcentral.common.util.CommonInputUtils;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.util.DataUtils;

/**
 * Abstract array input.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractArrayInput<T> extends AbstractInput<T> {

    public AbstractArrayInput(Class<T> type, String editor) {
        super(type, editor);
    }

    public String getStringValue() throws UnifyException {
        return CommonInputUtils.buildCollectionString(DataUtils.convert(String[].class, value));
    }

    public void setStringValue(String value) throws UnifyException {
        this.value = DataUtils.convert(getType(), CommonInputUtils.breakdownCollectionString(value));
    }

    public boolean compatible(AbstractInput<?> in) {
        return getType().equals(in.getType()) && getEditor().equals(in.getEditor());
    }
}
