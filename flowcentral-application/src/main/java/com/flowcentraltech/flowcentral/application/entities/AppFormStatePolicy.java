/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

import java.util.List;

import com.flowcentraltech.flowcentral.common.entities.BaseConfigNamedEntity;
import com.flowcentraltech.flowcentral.configuration.constants.FormStatePolicyType;
import com.tcdng.unify.core.annotation.Child;
import com.tcdng.unify.core.annotation.ChildList;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.ListOnly;
import com.tcdng.unify.core.annotation.Table;

/**
 * Application form state policy entity;
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_FORMSTATEPOLICY")
public class AppFormStatePolicy extends BaseConfigNamedEntity {

    @ForeignKey(AppForm.class)
    private Long appFormId;

    @ForeignKey(name = "POLICY_TYPE")
    private FormStatePolicyType type;
    
    @Column(name = "VALUE_GENERATOR", length = 128, nullable = true)
    private String valueGenerator;
    
    @Column(name = "POLICY_TRIGGER", length = 256, nullable = true)
    private String trigger;

    @ListOnly(key = "type", property = "description")
    private String typeDesc;
    
    @Child(category = "formstatepolicy")
    private AppFilter onCondition;

    @Child(category = "formstatepolicy")
    private AppSetValues setValues;

    @ChildList
    private List<AppFormSetState> setStateList;

    public Long getAppFormId() {
        return appFormId;
    }

    public void setAppFormId(Long appFormId) {
        this.appFormId = appFormId;
    }

    public FormStatePolicyType getType() {
        return type;
    }

    public void setType(FormStatePolicyType type) {
        this.type = type;
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

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public AppFilter getOnCondition() {
        return onCondition;
    }

    public void setOnCondition(AppFilter onCondition) {
        this.onCondition = onCondition;
    }

    public AppSetValues getSetValues() {
        return setValues;
    }

    public void setSetValues(AppSetValues setValues) {
        this.setValues = setValues;
    }

    public List<AppFormSetState> getSetStateList() {
        return setStateList;
    }

    public void setSetStateList(List<AppFormSetState> setStateList) {
        this.setStateList = setStateList;
    }

}
