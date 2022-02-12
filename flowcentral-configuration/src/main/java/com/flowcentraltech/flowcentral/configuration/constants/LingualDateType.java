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
 * Lingual date type constants.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table("FC_LINGUALDATETYPE")
@StaticList(name = "lingualdatetypelist", description = "$m{staticlist.lingualdatetypelist}")
public enum LingualDateType implements EnumConst {

    TODAY(
            "TDY"),
    YESTERDAY(
            "YST"),
    TOMORROW(
            "TMR"),
    THIS_WEEK(
            "TWK"),
    LAST_WEEK(
            "LWK"),
    NEXT_WEEK(
            "NWK"),
    THIS_MONTH(
            "TMN"),
    LAST_MONTH(
            "LMN"),
    NEXT_MONTH(
            "NMN"),
    LAST_3MONTHS(
            "L3M"),
    NEXT_3MONTHS(
            "N3M"),
    LAST_6MONTHS(
            "L6M"),
    NEXT_6MONTHS(
            "N6M"),
    LAST_9MONTHS(
            "L9M"),
    NEXT_9MONTHS(
            "N9M"),
    LAST_12MONTHS(
            "L1M"),
    NEXT_12MONTHS(
            "N1M"),
    THIS_YEAR(
            "TYR"),
    LAST_YEAR(
            "LYR"),
    NEXT_YEAR(
            "NYR");

    private final String code;

    private LingualDateType(String code) {
        this.code = code;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String defaultCode() {
        return TODAY.code;
    }

    public static LingualDateType fromCode(String code) {
        return EnumUtils.fromCode(LingualDateType.class, code);
    }

    public static LingualDateType fromName(String name) {
        return EnumUtils.fromName(LingualDateType.class, name);
    }
}
