/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.tcdng.unify.core.criterion.RestrictionType;

/**
 * Report filter option.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ReportFilterOptions {

    private RestrictionType op;

    private String tableName;

    private String columnName;

    private Object param1;

    private Object param2;

    private List<ReportFilterOptions> subFilterOptionList;

    public ReportFilterOptions(RestrictionType op, String tableName, String columnName, Object param1, Object param2) {
        this.op = op;
        if (op.isCompound()) {
            this.subFilterOptionList = new ArrayList<ReportFilterOptions>();
        } else {
            this.tableName = tableName;
            this.columnName = columnName;
            this.param1 = param1;
            this.param2 = param2;
            this.subFilterOptionList = Collections.emptyList();
        }
    }

    public ReportFilterOptions(RestrictionType op) {
        this(op, null, null, null, null);
    }

    public RestrictionType getOp() {
        return op;
    }

    public boolean isCompound() {
        return op.isCompound();
    }

    public String getTableName() {
        return tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public Object getParam1() {
        return param1;
    }

    public Object getParam2() {
        return param2;
    }

    public List<ReportFilterOptions> getSubFilterOptionList() {
        return subFilterOptionList;
    }
}
