/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Field sequence entry configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class FieldSequenceEntryConfig {

    private String fieldName;

    private String formatter;

    public FieldSequenceEntryConfig(String fieldName, String formatter) {
        this.fieldName = fieldName;
        this.formatter = formatter;
    }

    public FieldSequenceEntryConfig() {

    }

    public String getFieldName() {
        return fieldName;
    }

    @XmlAttribute(name = "field", required = true)
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFormatter() {
        return formatter;
    }

    @XmlAttribute
    public void setFormatter(String formatter) {
        this.formatter = formatter;
    }

}
