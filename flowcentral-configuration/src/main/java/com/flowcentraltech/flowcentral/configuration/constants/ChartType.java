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
 * Chart type constants.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table("FC_CHARTTYPE")
@StaticList(name = "charttypelist", description = "$m{staticlist.charttypelist}")
public enum ChartType implements EnumConst {

    LINE(
            "LNE",
            "line"),
    AREA(
            "ARE",
            "area"),
    COLUMN(
            "COL",
            "bar"),
    BAR(
            "BAR",
            "bar"),
    RADAR(
            "RAD",
            "radar"),
    PIE(
            "PIE",
            "pie"),
    DONUT(
            "DNT",
            "donut"),
    POLAR_AREA(
            "POL",
            "polarArea");

    private final String code;

    private final String optionsType;

    private ChartType(String code, String optionsType) {
        this.code = code;
        this.optionsType = optionsType;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String defaultCode() {
        return LINE.code;
    }

    public String optionsType() {
        return optionsType;
    }

    public boolean plotOptions() {
        return COLUMN.equals(this) || BAR.equals(this) || PIE.equals(this) || DONUT.equals(this);
    }

    public boolean axisChart() {
        return !PIE.equals(this) && !DONUT.equals(this) && !POLAR_AREA.equals(this);
    }

    public static ChartType fromCode(String code) {
        return EnumUtils.fromCode(ChartType.class, code);
    }

    public static ChartType fromName(String name) {
        return EnumUtils.fromName(ChartType.class, name);
    }
}
