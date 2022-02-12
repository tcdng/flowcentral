/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.data;

/**
 * Form field validator policy definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class FieldValidationPolicyDef {

    private String name;

    private String description;

    private String fieldName;

    private String validator;

    private String rule;

    public FieldValidationPolicyDef(String name, String description, String fieldName, String validator, String rule) {
        this.name = name;
        this.description = description;
        this.fieldName = fieldName;
        this.validator = validator;
        this.rule = rule;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getValidator() {
        return validator;
    }

    public String getRule() {
        return rule;
    }

}
