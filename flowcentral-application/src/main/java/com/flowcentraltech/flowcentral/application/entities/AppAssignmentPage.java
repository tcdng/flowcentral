/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.Table;

/**
 * Application assignment page entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_ASSIGNPAGE")
public class AppAssignmentPage extends BaseApplicationEntity {

    @Column(name = "ASSIGNPAGE_LABEL", length = 96)
    private String label;

    @Column(length = 128)
    private String entity;

    @Column(length = 64, nullable = true)
    private String commitPolicy;

    @Column(length = 64)
    private String baseField;

    @Column(length = 64)
    private String assignField;

    @Column(length = 96, nullable = true)
    private String filterCaption1;

    @Column(length = 96, nullable = true)
    private String filterCaption2;

    @Column(length = 96, nullable = true)
    private String filterList1;

    @Column(length = 96, nullable = true)
    private String filterList2;

    @Column(length = 96)
    private String assignCaption;

    @Column(length = 96)
    private String unassignCaption;

    @Column(length = 96)
    private String assignList;

    @Column(length = 96)
    private String unassignList;

    @Column(length = 64, nullable = true)
    private String ruleDescField;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getCommitPolicy() {
        return commitPolicy;
    }

    public void setCommitPolicy(String commitPolicy) {
        this.commitPolicy = commitPolicy;
    }

    public String getBaseField() {
        return baseField;
    }

    public void setBaseField(String baseField) {
        this.baseField = baseField;
    }

    public String getAssignField() {
        return assignField;
    }

    public void setAssignField(String assignField) {
        this.assignField = assignField;
    }

    public String getFilterCaption1() {
        return filterCaption1;
    }

    public void setFilterCaption1(String filterCaption1) {
        this.filterCaption1 = filterCaption1;
    }

    public String getFilterCaption2() {
        return filterCaption2;
    }

    public void setFilterCaption2(String filterCaption2) {
        this.filterCaption2 = filterCaption2;
    }

    public String getFilterList1() {
        return filterList1;
    }

    public void setFilterList1(String filterList1) {
        this.filterList1 = filterList1;
    }

    public String getFilterList2() {
        return filterList2;
    }

    public void setFilterList2(String filterList2) {
        this.filterList2 = filterList2;
    }

    public String getAssignCaption() {
        return assignCaption;
    }

    public void setAssignCaption(String assignCaption) {
        this.assignCaption = assignCaption;
    }

    public String getUnassignCaption() {
        return unassignCaption;
    }

    public void setUnassignCaption(String unassignCaption) {
        this.unassignCaption = unassignCaption;
    }

    public String getAssignList() {
        return assignList;
    }

    public void setAssignList(String assignList) {
        this.assignList = assignList;
    }

    public String getUnassignList() {
        return unassignList;
    }

    public void setUnassignList(String unassignList) {
        this.unassignList = unassignList;
    }

    public String getRuleDescField() {
        return ruleDescField;
    }

    public void setRuleDescField(String ruleDescField) {
        this.ruleDescField = ruleDescField;
    }

}
