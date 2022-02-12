/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.flowcentraltech.flowcentral.configuration.constants.FormStatePolicyType;
import com.flowcentraltech.flowcentral.configuration.xml.adapter.FormStatePolicyTypeXmlAdapter;

/**
 * Form state policy configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class FormStatePolicyConfig extends BaseNameConfig {

    private FormStatePolicyType type;
    
    private FilterConfig onCondition;

    private SetStatesConfig setStates;

    private SetValuesConfig setValues;

    private String valueGenerator;

    private String trigger;

    public FormStatePolicyType getType() {
        return type;
    }

    @XmlJavaTypeAdapter(FormStatePolicyTypeXmlAdapter.class)
    @XmlAttribute(required = true)
    public void setType(FormStatePolicyType type) {
        this.type = type;
    }

    public FilterConfig getOnCondition() {
        return onCondition;
    }

    @XmlElement(required = true)
    public void setOnCondition(FilterConfig onCondition) {
        this.onCondition = onCondition;
    }

    public SetStatesConfig getSetStates() {
        return setStates;
    }

    @XmlElement(name = "setStates")
    public void setSetStates(SetStatesConfig setStates) {
        this.setStates = setStates;
    }

    public SetValuesConfig getSetValues() {
        return setValues;
    }

    @XmlElement(name = "setValues")
    public void setSetValues(SetValuesConfig setValues) {
        this.setValues = setValues;
    }

    public String getValueGenerator() {
        return valueGenerator;
    }

    public void setValueGenerator(String valueGenerator) {
        this.valueGenerator = valueGenerator;
    }

    public String getTrigger() {
        return trigger;
    }

    @XmlAttribute
    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }

}
