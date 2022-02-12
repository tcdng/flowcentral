/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.data;

import com.tcdng.unify.core.format.Formatter;

/**
 * Record load information.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class RecLoadInfo {

    private String fieldName;

    private Object val;

    private Formatter<?> formatter;

    public RecLoadInfo(String fieldName, Object val, Formatter<?> formatter) {
        this.fieldName = fieldName;
        this.val = val;
        this.formatter = formatter;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getVal() {
        return val;
    }

    public Formatter<?> getFormatter() {
        return formatter;
    }
}
