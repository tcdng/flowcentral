/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.common.input;

import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.util.DataUtils;

/**
 * Abstract input.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractInput<T> {

    private Class<T> type;

    protected T value;

    private String editor;

    public AbstractInput(Class<T> type, String editor) {
        this.type = type;
        this.editor = editor;
    }

    public String getStringValue() throws UnifyException {
        return DataUtils.convert(String.class, value);
    }

    public void setStringValue(String value) throws UnifyException {
        this.value = DataUtils.convert(type, value);
    }

    public Class<T> getType() {
        return type;
    }

    public String getEditor() {
        return editor;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public boolean compatible(AbstractInput<?> in) {
        return type.equals(in.type) && editor.equals(in.editor);
    }
}
