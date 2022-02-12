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
 * Application table entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_TABLE")
public class AppTable extends BaseApplicationEntity {

    @Column(name = "TABLE_LABEL", length = 96)
    private String label;

    @Column(length = 128)
    private String entity;

    @Column
    private int sortHistory;

    @Column
    private int itemsPerPage;

    @Column
    private boolean sortable;

    @Column
    private boolean serialNo;

    @Column
    private boolean headerToUpperCase;

    @Column
    private boolean headerCenterAlign;

    @Column
    private boolean basicSearch;

    @Column
    private boolean limitSelectToColumns;

    @ChildList
    private List<AppTableAction> actionList;

    @ChildList
    private List<AppTableColumn> columnList;

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

    public int getSortHistory() {
        return sortHistory;
    }

    public void setSortHistory(int sortHistory) {
        this.sortHistory = sortHistory;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }

    public void setItemsPerPage(int itemsPerPage) {
        this.itemsPerPage = itemsPerPage;
    }

    public boolean isSortable() {
        return sortable;
    }

    public void setSortable(boolean sortable) {
        this.sortable = sortable;
    }

    public boolean isSerialNo() {
        return serialNo;
    }

    public void setSerialNo(boolean serialNo) {
        this.serialNo = serialNo;
    }

    public boolean isHeaderToUpperCase() {
        return headerToUpperCase;
    }

    public void setHeaderToUpperCase(boolean headerToUpperCase) {
        this.headerToUpperCase = headerToUpperCase;
    }

    public boolean isHeaderCenterAlign() {
        return headerCenterAlign;
    }

    public void setHeaderCenterAlign(boolean headerCenterAlign) {
        this.headerCenterAlign = headerCenterAlign;
    }

    public boolean isBasicSearch() {
        return basicSearch;
    }

    public void setBasicSearch(boolean basicSearch) {
        this.basicSearch = basicSearch;
    }

    public boolean isLimitSelectToColumns() {
        return limitSelectToColumns;
    }

    public void setLimitSelectToColumns(boolean limitSelectToColumns) {
        this.limitSelectToColumns = limitSelectToColumns;
    }

    public List<AppTableAction> getActionList() {
        return actionList;
    }

    public void setActionList(List<AppTableAction> actionList) {
        this.actionList = actionList;
    }

    public List<AppTableColumn> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<AppTableColumn> columnList) {
        this.columnList = columnList;
    }

}
