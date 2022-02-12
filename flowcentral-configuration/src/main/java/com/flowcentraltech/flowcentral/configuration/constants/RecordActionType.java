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
 * Record action type constants.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table("FC_RECORDACTIONTYPE")
@StaticList(name = "recordactiontypelist", description = "$m{staticlist.recordactiontypelist}")
public enum RecordActionType implements EnumConst {

    CREATE(
            "C"),
    UPDATE(
            "U"),
    DELETE(
            "D");

    private final String code;

    private RecordActionType(String code) {
        this.code = code;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String defaultCode() {
        return UPDATE.code;
    }

    public boolean isUpdate() {
        return CREATE.equals(this) || UPDATE.equals(this);
    }

    public static RecordActionType fromCode(String code) {
        return EnumUtils.fromCode(RecordActionType.class, code);
    }

    public static RecordActionType fromName(String name) {
        return EnumUtils.fromName(RecordActionType.class, name);
    }
}
