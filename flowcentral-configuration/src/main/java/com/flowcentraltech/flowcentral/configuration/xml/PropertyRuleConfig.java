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

/**
 * Property rule configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class PropertyRuleConfig extends BaseNameConfig {

    private String entity;

    private String choiceField;

    private String listField;

    private String propNameField;

    private String propValField;

    private String defaultList;

    private boolean ignoreCase;

    private List<ChoiceConfig> choiceList;

    public String getEntity() {
        return entity;
    }

    @XmlAttribute(required = true)
    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getChoiceField() {
        return choiceField;
    }

    @XmlAttribute(required = true)
    public void setChoiceField(String choiceField) {
        this.choiceField = choiceField;
    }

    public String getListField() {
        return listField;
    }

    @XmlAttribute(required = true)
    public void setListField(String listField) {
        this.listField = listField;
    }

    public String getPropNameField() {
        return propNameField;
    }

    @XmlAttribute(required = true)
    public void setPropNameField(String propNameField) {
        this.propNameField = propNameField;
    }

    public String getPropValField() {
        return propValField;
    }

    @XmlAttribute(required = true)
    public void setPropValField(String propValField) {
        this.propValField = propValField;
    }

    public String getDefaultList() {
        return defaultList;
    }

    @XmlAttribute
    public void setDefaultList(String defaultList) {
        this.defaultList = defaultList;
    }

    @XmlAttribute
    public boolean isIgnoreCase() {
        return ignoreCase;
    }

    public void setIgnoreCase(boolean ignoreCase) {
        this.ignoreCase = ignoreCase;
    }

    public List<ChoiceConfig> getChoiceList() {
        return choiceList;
    }

    @XmlElement(name = "choice")
    public void setChoiceList(List<ChoiceConfig> choiceList) {
        this.choiceList = choiceList;
    }

}
