/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Property list property configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class PropertyListPropConfig {

    private String name;

    private String description;

    private String references;

    private String inputWidget;

    private String defaultVal;

    private boolean required;

    private boolean mask;

    private boolean encrypt;

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

    @XmlAttribute(required = true)
    public void setDescription(String description) {
        this.description = description;
    }

    public String getReferences() {
        return references;
    }

    @XmlAttribute
    public void setReferences(String references) {
        this.references = references;
    }

    public String getInputWidget() {
        return inputWidget;
    }

    @XmlAttribute(required = true)
    public void setInputWidget(String inputWidget) {
        this.inputWidget = inputWidget;
    }

    public String getDefaultVal() {
        return defaultVal;
    }

    @XmlAttribute
    public void setDefaultVal(String defaultVal) {
        this.defaultVal = defaultVal;
    }

    public boolean isRequired() {
        return required;
    }

    @XmlAttribute
    public void setRequired(boolean required) {
        this.required = required;
    }

    public boolean isMask() {
        return mask;
    }

    @XmlAttribute
    public void setMask(boolean mask) {
        this.mask = mask;
    }

    public boolean isEncrypt() {
        return encrypt;
    }

    @XmlAttribute
    public void setEncrypt(boolean encrypt) {
        this.encrypt = encrypt;
    }

}
