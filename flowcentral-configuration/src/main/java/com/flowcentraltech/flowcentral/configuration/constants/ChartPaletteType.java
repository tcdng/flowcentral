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
 * Chart palette type constants.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table("FC_CHARTPALETTETYPE")
@StaticList(name = "chartpalettetypelist", description = "$m{staticlist.chartpalettetypelist}")
public enum ChartPaletteType implements EnumConst {

    PALETTE1(
            "PL1",
            "palette1"),
    PALETTE2(
            "PL2",
            "palette2"),
    PALETTE3(
            "PL3",
            "palette3"),
    PALETTE4(
            "PL4",
            "palette4"),
    PALETTE5(
            "PL5",
            "palette5"),
    PALETTE6(
            "PL6",
            "palette6"),
    PALETTE7(
            "PL7",
            "palette7"),
    PALETTE8(
            "PL8",
            "palette8"),
    PALETTE9(
            "PL9",
            "palette9"),
    PALETTE10(
            "PL10",
            "palette10");

    private final String code;

    private final String optionsType;

    private ChartPaletteType(String code, String optionsType) {
        this.code = code;
        this.optionsType = optionsType;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String defaultCode() {
        return PALETTE1.code;
    }

    public String optionsType() {
        return optionsType;
    }

    public static ChartPaletteType fromCode(String code) {
        return EnumUtils.fromCode(ChartPaletteType.class, code);
    }

    public static ChartPaletteType fromName(String name) {
        return EnumUtils.fromName(ChartPaletteType.class, name);
    }
}
