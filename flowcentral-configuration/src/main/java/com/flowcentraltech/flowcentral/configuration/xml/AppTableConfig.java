/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Table configuration
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppTableConfig extends BaseNameConfig {

    private String entity;

    private int sortHistory;

    private int itemsPerPage;

    private boolean serialNo;

    private boolean sortable;

    private boolean headerToUpperCase;

    private boolean headerCenterAlign;

    private boolean basicSearch;

    private boolean limitSelectToColumns;

    private List<TableActionConfig> actionList;

    private List<TableColumnConfig> columnList;

    private List<FilterConfig> quickFilterList;

    public AppTableConfig() {
        this.sortable = true;
        this.limitSelectToColumns = true;
        this.sortHistory = -1;
    }

    public String getEntity() {
        return entity;
    }

    @XmlAttribute(required = true)
    public void setEntity(String entity) {
        this.entity = entity;
    }

    public int getSortHistory() {
        return sortHistory;
    }

    @XmlAttribute
    public void setSortHistory(int sortHistory) {
        this.sortHistory = sortHistory;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }

    @XmlAttribute
    public void setItemsPerPage(int itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

    public boolean isSortable() {
        return sortable;
    }

    @XmlAttribute
    public void setSortable(boolean sortable) {
        this.sortable = sortable;
    }

    public boolean isSerialNo() {
        return serialNo;
    }

    @XmlAttribute
    public void setSerialNo(boolean serialNo) {
        this.serialNo = serialNo;
    }

    public boolean isHeaderToUpperCase() {
        return headerToUpperCase;
    }

    @XmlAttribute
    public void setHeaderToUpperCase(boolean headerToUpperCase) {
        this.headerToUpperCase = headerToUpperCase;
    }

    public boolean isHeaderCenterAlign() {
        return headerCenterAlign;
    }

    @XmlAttribute
    public void setHeaderCenterAlign(boolean headerCenterAlign) {
        this.headerCenterAlign = headerCenterAlign;
    }

    public boolean isBasicSearch() {
        return basicSearch;
    }

    @XmlAttribute
    public void setBasicSearch(boolean basicSearch) {
        this.basicSearch = basicSearch;
    }

    public boolean isLimitSelectToColumns() {
        return limitSelectToColumns;
    }

    @XmlAttribute
    public void setLimitSelectToColumns(boolean limitSelectToColumns) {
        this.limitSelectToColumns = limitSelectToColumns;
    }

    public List<TableActionConfig> getActionList() {
        return actionList;
    }

    @XmlElement(name = "action", required = true)
    public void setActionList(List<TableActionConfig> actionList) {
        this.actionList = actionList;
    }

    public List<TableColumnConfig> getColumnList() {
        return columnList;
    }

    @XmlElement(name = "column", required = true)
    public void setColumnList(List<TableColumnConfig> columnList) {
        this.columnList = columnList;
    }

    public List<FilterConfig> getQuickFilterList() {
        return quickFilterList;
    }

    @XmlElement(name = "quickFilter")
    public void setQuickFilterList(List<FilterConfig> quickFilterList) {
        this.quickFilterList = quickFilterList;
    }

}
