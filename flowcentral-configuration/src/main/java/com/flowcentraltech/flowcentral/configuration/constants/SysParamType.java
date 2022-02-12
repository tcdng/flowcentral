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
 * System parameter type constants.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table("FC_SYSPARAMTYPE")
@StaticList(name = "sysparamtypelist", description = "$m{staticlist.sysparamtypelist}")
public enum SysParamType implements EnumConst {

    BOOLEAN(
            "B"),
    NUMBER(
            "N"),
    STRING(
            "S"),
    NAME(
            "M"),
    CONTACT(
            "C");

    private final String code;

    private SysParamType(String code) {
        this.code = code;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String defaultCode() {
        return STRING.code;
    }

    public static SysParamType fromCode(String code) {
        return EnumUtils.fromCode(SysParamType.class, code);
    }

    public static SysParamType fromName(String name) {
        return EnumUtils.fromName(SysParamType.class, name);
    }
}
