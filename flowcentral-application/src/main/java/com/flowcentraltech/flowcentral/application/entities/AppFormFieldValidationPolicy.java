/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseConfigNamedEntity;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.Table;

/**
 * Application form field validation policy entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_FORMFLDVALIDPOLICY")
public class AppFormFieldValidationPolicy extends BaseConfigNamedEntity {

    @ForeignKey(AppForm.class)
    private Long appFormId;

    @Column(length = 64)
    private String fieldName;

    @Column(length = 64)
    private String validation;

    @Column(length = 64, nullable = true)
    private String rule;

    public Long getAppFormId() {
        return appFormId;
    }

    public void setAppFormId(Long appFormId) {
        this.appFormId = appFormId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getValidation() {
        return validation;
    }

    public void setValidation(String validation) {
        this.validation = validation;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

}
