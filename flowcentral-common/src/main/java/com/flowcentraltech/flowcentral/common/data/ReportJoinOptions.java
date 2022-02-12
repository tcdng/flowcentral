/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.data;

/**
 * Report join option.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ReportJoinOptions {

    private String tableA;

    private String columnA;

    private String tableB;

    private String columnB;

    public ReportJoinOptions(String tableA, String columnA, String tableB, String columnB) {
        this.tableA = tableA;
        this.columnA = columnA;
        this.tableB = tableB;
        this.columnB = columnB;
    }

    public String getTableA() {
        return tableA;
    }

    public String getColumnA() {
        return columnA;
    }

    public String getTableB() {
        return tableB;
    }

    public String getColumnB() {
        return columnB;
    }

}
