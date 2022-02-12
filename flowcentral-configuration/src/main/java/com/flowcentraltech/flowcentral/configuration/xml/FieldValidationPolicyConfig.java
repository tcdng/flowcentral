/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Field validation policy configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class FieldValidationPolicyConfig extends BaseNameConfig {

    private String fieldName;

    private String validator;

    private String rule;

    public String getFieldName() {
        return fieldName;
    }

    @XmlAttribute(required = true)
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getValidator() {
        return validator;
    }

    @XmlAttribute(required = true)
    public void setValidator(String validator) {
        this.validator = validator;
    }

    public String getRule() {
        return rule;
    }

    @XmlAttribute
    public void setRule(String rule) {
        this.rule = rule;
    }

}
