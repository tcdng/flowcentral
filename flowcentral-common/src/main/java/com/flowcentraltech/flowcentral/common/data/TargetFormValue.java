/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.data;

/**
 * Target form value.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class TargetFormValue {

    private String fieldName;

    private Object value;

    public TargetFormValue(String fieldName, Object value) {
        this.fieldName = fieldName;
        this.value = value;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getValue() {
        return value;
    }

}
