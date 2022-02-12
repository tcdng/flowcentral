/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.common.constants;

import com.tcdng.unify.convert.constants.EnumConst;
import com.tcdng.unify.core.annotation.StaticList;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.util.EnumUtils;

/**
 * Configuration type enumeration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table("FC_CONFIGTYPE")
@StaticList(name = "configtypelist", description = "$m{staticlist.configtypelist}")
public enum ConfigType implements EnumConst {

    STATIC(
            "S"),
    STATIC_INSTALL(
            "SI"),
    MUTABLE(
            "M"),
    MUTABLE_INSTALL(
            "MI"),
    CUSTOMIZED(
            "Z"),
    CUSTOM(
            "C");

    private final String code;

    private ConfigType(String code) {
        this.code = code;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String defaultCode() {
        return CUSTOM.code;
    }

    public boolean isStatic() {
        return STATIC.equals(this);
    }

    public boolean isCustom() {
        return CUSTOM.equals(this) || CUSTOMIZED.equals(this);
    }

    public boolean isInitial() {
        return STATIC.equals(this) || MUTABLE.equals(this);
    }

    public boolean isInstall() {
        return STATIC_INSTALL.equals(this) || MUTABLE_INSTALL.equals(this);
    }

    public static ConfigType fromCode(String code) {
        return EnumUtils.fromCode(ConfigType.class, code);
    }

    public static ConfigType fromName(String name) {
        return EnumUtils.fromName(ConfigType.class, name);
    }

}
