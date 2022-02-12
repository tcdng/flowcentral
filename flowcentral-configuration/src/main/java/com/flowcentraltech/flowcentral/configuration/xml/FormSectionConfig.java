/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.flowcentraltech.flowcentral.configuration.constants.FormColumnsType;
import com.flowcentraltech.flowcentral.configuration.xml.adapter.FormColumnsTypeXmlAdapter;

/**
 * Form section configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class FormSectionConfig {

    private String name;

    private String label;

    private FormColumnsType columns;

    private boolean visible;

    private boolean editable;

    private boolean disabled;

    private List<FormFieldConfig> fieldList;

    public FormSectionConfig() {
        this.visible = true;
        this.editable = true;
        this.disabled = false;
    }

    public String getName() {
        return name;
    }

    @XmlAttribute(required = true)
    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    @XmlAttribute
    public void setLabel(String label) {
        this.label = label;
    }

    public FormColumnsType getColumns() {
        return columns;
    }

    @XmlJavaTypeAdapter(FormColumnsTypeXmlAdapter.class)
    @XmlAttribute(required = true)
    public void setColumns(FormColumnsType columns) {
        this.columns = columns;
    }

    public boolean isVisible() {
        return visible;
    }

    @XmlAttribute
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isEditable() {
        return editable;
    }

    @XmlAttribute
    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public boolean isDisabled() {
        return disabled;
    }

    @XmlAttribute
    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public List<FormFieldConfig> getFieldList() {
        return fieldList;
    }

    @XmlElement(name = "field", required = true)
    public void setFieldList(List<FormFieldConfig> fieldList) {
        this.fieldList = fieldList;
    }

}
