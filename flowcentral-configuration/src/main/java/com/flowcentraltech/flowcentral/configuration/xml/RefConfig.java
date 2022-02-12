/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Reference configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class RefConfig extends BaseNameConfig {

    private String entity;

    private String searchField;

    private String searchTable;

    private String listFormat;

    private String filterGenerator;

    private String filterGeneratorRule;

    private FilterConfig filter;

    public String getEntity() {
        return entity;
    }

    @XmlAttribute(required = true)
    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getSearchField() {
        return searchField;
    }

    @XmlAttribute(required = true)
    public void setSearchField(String searchField) {
        this.searchField = searchField;
    }

    public String getSearchTable() {
        return searchTable;
    }

    @XmlAttribute
    public void setSearchTable(String searchTable) {
        this.searchTable = searchTable;
    }

    public String getListFormat() {
        return listFormat;
    }

    @XmlAttribute
    public void setListFormat(String listFormat) {
        this.listFormat = listFormat;
    }

    public String getFilterGenerator() {
        return filterGenerator;
    }

    @XmlAttribute
    public void setFilterGenerator(String filterGenerator) {
        this.filterGenerator = filterGenerator;
    }

    public String getFilterGeneratorRule() {
        return filterGeneratorRule;
    }

    @XmlAttribute
    public void setFilterGeneratorRule(String filterGeneratorRule) {
        this.filterGeneratorRule = filterGeneratorRule;
    }

    public FilterConfig getFilter() {
        return filter;
    }

    @XmlElement
    public void setFilter(FilterConfig filter) {
        this.filter = filter;
    }
}
