/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseConfigNamedEntity;
import com.tcdng.unify.core.annotation.Child;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.ListOnly;
import com.tcdng.unify.core.annotation.Table;

/**
 * Application form validation policy entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_FORMVALIDPOLICY")
public class AppFormValidationPolicy extends BaseConfigNamedEntity {

    @ForeignKey(AppForm.class)
    private Long appFormId;

    @Column(length = 512)
    private String message;

    @Column(length = 64, nullable = true)
    private String errorMatcher;
    
    @Column(name = "POLICY_TARGET", length = 256, nullable = true)
    private String target;

    @Child(category = "formvalidationpolicy")
    private AppFilter errorCondition;

    @ListOnly(name = "form_entity", key = "appFormId", property = "entity")
    private String entityName;

    public Long getAppFormId() {
        return appFormId;
    }

    public void setAppFormId(Long appFormId) {
        this.appFormId = appFormId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorMatcher() {
        return errorMatcher;
    }

    public void setErrorMatcher(String errorMatcher) {
        this.errorMatcher = errorMatcher;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public AppFilter getErrorCondition() {
        return errorCondition;
    }

    public void setErrorCondition(AppFilter errorCondition) {
        this.errorCondition = errorCondition;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }
}
