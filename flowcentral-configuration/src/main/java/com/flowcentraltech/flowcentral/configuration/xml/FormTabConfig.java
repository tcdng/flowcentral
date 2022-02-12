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

import com.flowcentraltech.flowcentral.configuration.constants.TabContentType;
import com.flowcentraltech.flowcentral.configuration.xml.adapter.TabContentTypeXmlAdapter;

/**
 * Form tab configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class FormTabConfig {

    private TabContentType contentType;

    private String name;

    private String label;

    private String applet;

    private String reference;

    private String editAction;

    private boolean visible;

    private boolean editable;

    private boolean disabled;

    private List<FormSectionConfig> sectionList;

    public FormTabConfig() {
        this.visible = true;
        this.editable = true;
        this.disabled = false;
    }

    public TabContentType getContentType() {
        return contentType;
    }

    @XmlJavaTypeAdapter(TabContentTypeXmlAdapter.class)
    @XmlAttribute(required = true)
    public void setContentType(TabContentType contentType) {
        this.contentType = contentType;
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

    @XmlAttribute(required = true)
    public void setLabel(String label) {
        this.label = label;
    }

    public String getApplet() {
        return applet;
    }

    @XmlAttribute
    public void setApplet(String applet) {
        this.applet = applet;
    }

    public String getReference() {
        return reference;
    }

    @XmlAttribute
    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getEditAction() {
        return editAction;
    }

    @XmlAttribute
    public void setEditAction(String editAction) {
        this.editAction = editAction;
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

    public List<FormSectionConfig> getSectionList() {
        return sectionList;
    }

    @XmlElement(name = "section", required = true)
    public void setSectionList(List<FormSectionConfig> sectionList) {
        this.sectionList = sectionList;
    }

}
