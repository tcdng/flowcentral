/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.flowcentraltech.flowcentral.configuration.constants.SysParamType;
import com.flowcentraltech.flowcentral.configuration.xml.adapter.SysParamTypeXmlAdapter;

/**
 * System parameter configuration
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class SysParamConfig extends BaseCodeConfig {

    private SysParamType type;

    private String editor;

    private String defaultVal;

    private boolean control;

    private boolean editable;

    public SysParamConfig() {
        type = SysParamType.STRING;
    }

    public SysParamType getType() {
        return type;
    }

    @XmlJavaTypeAdapter(SysParamTypeXmlAdapter.class)
    @XmlAttribute(required = true)
    public void setType(SysParamType type) {
        this.type = type;
    }

    public String getEditor() {
        return editor;
    }

    @XmlAttribute
    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getDefaultVal() {
        return defaultVal;
    }

    @XmlAttribute
    public void setDefaultVal(String defaultVal) {
        this.defaultVal = defaultVal;
    }

    public boolean isControl() {
        return control;
    }

    @XmlAttribute
    public void setControl(boolean control) {
        this.control = control;
    }

    public boolean isEditable() {
        return editable;
    }

    @XmlAttribute
    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    @Override
    public String toString() {
        return "SysParamConfig [type=" + type + ", editor=" + editor + ", defaultVal=" + defaultVal + ", control="
                + control + ", editable=" + editable + "]";
    }

}
