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
 * Lingual string type constants.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table("FC_LINGUALSTRINGTYPE")
@StaticList(name = "lingualstringtypelist", description = "$m{staticlist.lingualstringtypelist}")
public enum LingualStringType implements EnumConst {

    GENERATED(
            "GEN", "<generated>");

    private final String code;

    private final String value;

    private LingualStringType(String code, String value) {
        this.code = code;
        this.value = value;
    }

    @Override
    public String code() {
        return this.code;
    }

    public String value() {
        return this.value;
    }

    @Override
    public String defaultCode() {
        return GENERATED.code;
    }

    public static LingualDateType fromCode(String code) {
        return EnumUtils.fromCode(LingualDateType.class, code);
    }

    public static LingualDateType fromName(String name) {
        return EnumUtils.fromName(LingualDateType.class, name);
    }
}
