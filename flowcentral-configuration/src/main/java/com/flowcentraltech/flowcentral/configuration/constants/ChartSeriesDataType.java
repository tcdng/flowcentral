/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.constants;

import com.tcdng.unify.convert.constants.EnumConst;
import com.tcdng.unify.core.annotation.StaticList;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.util.EnumUtils;

/**
 * Chart series data type constants.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table("FC_CHARTSERDATATYPE")
@StaticList(name = "chartseriesdatatypelist", description = "$m{staticlist.chartseriesdatatypelist}")
public enum ChartSeriesDataType implements EnumConst {

    INTEGER(
            "INT"),
    LONG(
            "LGN"),
    DOUBLE(
            "DBL");

    private final String code;

    private ChartSeriesDataType(String code) {
        this.code = code;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String defaultCode() {
        return INTEGER.code;
    }

    public static ChartSeriesDataType fromCode(String code) {
        return EnumUtils.fromCode(ChartSeriesDataType.class, code);
    }

    public static ChartSeriesDataType fromName(String name) {
        return EnumUtils.fromName(ChartSeriesDataType.class, name);
    }
}
