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
 * Widget color constants.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table("FC_WIDGETCOLOR")
@StaticList(name = "widgetcolorlist", description = "$m{staticlist.widgetcolorlist}")
public enum WidgetColor implements EnumConst {

    RED(
            "RED",
            "#eacbc8"),
    ORANGE(
            "ORN",
            "#ead5c3"),
    YELLOW(
            "YLW",
            "#efefc1"),
    GREEN(
            "GRN",
            "#c5e5d3"),
    CYAN(
            "CYN",
            "#c0dcd7"),
    BLUE(
            "BLU",
            "#c6dae8"),
    PURPLE(
            "PPL",
            "#dbcee0"),
    NAVY_GRAY(
            "NGR",
            "#d6dbdf");

    private final String code;

    private final String hex;

    private WidgetColor(String code, String hex) {
        this.code = code;
        this.hex = hex;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String defaultCode() {
        return BLUE.code;
    }

    public String hex() {
        return hex;
    }

    public static WidgetColor fromCode(String code) {
        return EnumUtils.fromCode(WidgetColor.class, code);
    }

    public static WidgetColor fromName(String name) {
        return EnumUtils.fromName(WidgetColor.class, name);
    }
}
