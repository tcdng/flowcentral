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
 * Chart category data type constants.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table("FC_CHARTCATDATATYPE")
@StaticList(name = "chartcategorydatatypelist", description = "$m{staticlist.chartcategorydatatypelist}")
public enum ChartCategoryDataType implements EnumConst {

    INTEGER(
            "INT",
            "numeric"),
    LONG(
            "LGN",
            "numeric"),
    DATE(
            "DTE",
            "datetime"),
    STRING(
            "STR",
            "category");

    private final String code;

    private final String optionsType;

    private ChartCategoryDataType(String code, String optionsType) {
        this.code = code;
        this.optionsType = optionsType;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String defaultCode() {
        return INTEGER.code;
    }

    public String optionsType() {
        return optionsType;
    }

    public static ChartCategoryDataType fromCode(String code) {
        return EnumUtils.fromCode(ChartCategoryDataType.class, code);
    }

    public static ChartCategoryDataType fromName(String name) {
        return EnumUtils.fromName(ChartCategoryDataType.class, name);
    }
}
