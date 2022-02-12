/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

import com.tcdng.unify.core.annotation.Child;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.Index;
import com.tcdng.unify.core.annotation.Table;

/**
 * Application reference entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_REF", indexes = { @Index("entity") })
public class AppRef extends BaseApplicationEntity {

    @Column(length = 128)
    private String entity;

    @Column(length = 64, nullable = true)
    private String searchField;

    @Column(length = 64, nullable = true)
    private String searchTable;

    @Column(length = 128, nullable = true)
    private String listFormat;
    
    @Column(length = 64, nullable = true)
    private String filterGenerator;

    @Column(length = 64, nullable = true)
    private String filterGeneratorRule;

    @Child(category = "ref")
    private AppFilter filter;

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getSearchField() {
        return searchField;
    }

    public void setSearchField(String searchField) {
        this.searchField = searchField;
    }

    public String getSearchTable() {
        return searchTable;
    }

    public void setSearchTable(String searchTable) {
        this.searchTable = searchTable;
    }

    public String getListFormat() {
        return listFormat;
    }

    public void setListFormat(String listFormat) {
        this.listFormat = listFormat;
    }

    public String getFilterGenerator() {
        return filterGenerator;
    }

    public void setFilterGenerator(String filterGenerator) {
        this.filterGenerator = filterGenerator;
    }

    public String getFilterGeneratorRule() {
        return filterGeneratorRule;
    }

    public void setFilterGeneratorRule(String filterGeneratorRule) {
        this.filterGeneratorRule = filterGeneratorRule;
    }

    public AppFilter getFilter() {
        return filter;
    }

    public void setFilter(AppFilter filter) {
        this.filter = filter;
    }

}
