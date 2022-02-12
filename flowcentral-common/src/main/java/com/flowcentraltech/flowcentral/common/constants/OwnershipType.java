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
 * Ownership type enumeration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table("FC_OWNERSHIPTYPE")
@StaticList(name = "ownershiptypelist", description = "$m{staticlist.ownershiptypelist}")
public enum OwnershipType implements EnumConst {

    GLOBAL(
            "G"),
    USER(
            "U");

    private final String code;

    private OwnershipType(String code) {
        this.code = code;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String defaultCode() {
        return GLOBAL.code;
    }

    public static OwnershipType fromCode(String code) {
        return EnumUtils.fromCode(OwnershipType.class, code);
    }

    public static OwnershipType fromName(String name) {
        return EnumUtils.fromName(OwnershipType.class, name);
    }

}
