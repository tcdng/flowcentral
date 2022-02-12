/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.flowcentraltech.flowcentral.configuration.constants.SetValueType;
import com.flowcentraltech.flowcentral.configuration.xml.adapter.SetValueTypeXmlAdapter;

/**
 * Set value configuration configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class SetValueConfig {

    private SetValueType type;

    private String fieldName;

    private String value;

    public SetValueConfig() {
        this.type = SetValueType.IMMEDIATE;
    }

    public SetValueType getType() {
        return type;
    }

    @XmlJavaTypeAdapter(SetValueTypeXmlAdapter.class)
    @XmlAttribute(name = "type")
    public void setType(SetValueType type) {
        this.type = type;
    }

    public String getFieldName() {
        return fieldName;
    }

    @XmlAttribute(name = "field", required = true)
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getValue() {
        return value;
    }

    @XmlAttribute
    public void setValue(String value) {
        this.value = value;
    }

}
