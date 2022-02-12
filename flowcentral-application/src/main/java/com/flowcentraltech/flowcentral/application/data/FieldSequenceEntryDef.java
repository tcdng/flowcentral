/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.data;

/**
 * Application field sequence entry definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class FieldSequenceEntryDef {

    private String fieldName;

    private String formatter;

    public FieldSequenceEntryDef(String fieldName, String formatter) {
        this.fieldName = fieldName;
        this.formatter = formatter;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getFormatter() {
        return formatter;
    }

    public boolean isWithFormatter() {
        return formatter != null;
    }
}
