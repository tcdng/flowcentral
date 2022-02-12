/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.tcdng.unify.core.constant.DataType;
import com.tcdng.unify.core.util.xml.adapter.DataTypeXmlAdapter;

/**
 * Parameter configuration.
 * 
 * @author Lateef Ojulari
 * @version 1.0
 */
public class ParameterConfig {

    private String name;

    private String description;

    private String label;

    private String editor;

    private String defaultVal;

    private DataType type;

    private boolean mandatory;

    public ParameterConfig() {
        type = DataType.STRING;
    }

    public String getName() {
        return name;
    }

    @XmlAttribute(required = true)
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    @XmlAttribute
    public void setDescription(String description) {
        this.description = description;
    }

    public String getEditor() {
        return editor;
    }

    @XmlAttribute(required = true)
    public void setEditor(String editor) {
        this.editor = editor;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    @XmlAttribute
    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }

    public String getLabel() {
        return label;
    }

    @XmlAttribute(required = true)
    public void setLabel(String label) {
        this.label = label;
    }

    public String getDefaultVal() {
        return defaultVal;
    }

    @XmlAttribute
    public void setDefaultVal(String defaultVal) {
        this.defaultVal = defaultVal;
    }

    public DataType getType() {
        return type;
    }

    @XmlJavaTypeAdapter(DataTypeXmlAdapter.class)
    @XmlAttribute(required = true)
    public void setType(DataType type) {
        this.type = type;
    }
}
