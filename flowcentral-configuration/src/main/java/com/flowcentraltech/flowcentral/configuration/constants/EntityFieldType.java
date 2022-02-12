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
 * Entity field type.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table("FC_ENTITYFIELDTYPE")
@StaticList(name = "entityfieldtypelist", description = "$m{staticlist.entityfieldtypelist}")
public enum EntityFieldType implements EnumConst {

    BASE(
            "BSE",
            0),
    STATIC(
            "STC",
            1),
    CUSTOM(
            "CST",
            2);

    private final String code;

    private final int index;

    private EntityFieldType(String code, int index) {
        this.code = code;
        this.index = index;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String defaultCode() {
        return BASE.code;
    }

    public int index() {
        return index;
    }

    public boolean isBase() {
        return BASE.equals(this);
    }

    public boolean isStatic() {
        return STATIC.equals(this);
    }

    public boolean isCustom() {
        return CUSTOM.equals(this);
    }

    public static EntityFieldType fromCode(String code) {
        return EnumUtils.fromCode(EntityFieldType.class, code);
    }

    public static EntityFieldType fromName(String name) {
        return EnumUtils.fromName(EntityFieldType.class, name);
    }
}
