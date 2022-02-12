/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

import java.util.List;

import com.tcdng.unify.core.annotation.ChildList;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.Table;

/**
 * Application property rule entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_PROPRULE")
public class AppPropertyRule extends BaseApplicationEntity {

    @Column(length = 128)
    private String entity;

    @Column(length = 64)
    private String choiceField;

    @Column(length = 64)
    private String listField;

    @Column(length = 64)
    private String propNameField;

    @Column(length = 64)
    private String propValField;

    @Column(length = 96, nullable = true)
    private String defaultList;

    @Column
    private boolean ignoreCase;

    @ChildList
    private List<AppPropertyRuleChoice> choiceList;

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getChoiceField() {
        return choiceField;
    }

    public void setChoiceField(String choiceField) {
        this.choiceField = choiceField;
    }

    public String getListField() {
        return listField;
    }

    public void setListField(String listField) {
        this.listField = listField;
    }

    public String getPropNameField() {
        return propNameField;
    }

    public void setPropNameField(String propNameField) {
        this.propNameField = propNameField;
    }

    public String getPropValField() {
        return propValField;
    }

    public void setPropValField(String propValField) {
        this.propValField = propValField;
    }

    public String getDefaultList() {
        return defaultList;
    }

    public void setDefaultList(String defaultList) {
        this.defaultList = defaultList;
    }

    public boolean isIgnoreCase() {
        return ignoreCase;
    }

    public void setIgnoreCase(boolean ignoreCase) {
        this.ignoreCase = ignoreCase;
    }

    public List<AppPropertyRuleChoice> getChoiceList() {
        return choiceList;
    }

    public void setChoiceList(List<AppPropertyRuleChoice> choiceList) {
        this.choiceList = choiceList;
    }

}
