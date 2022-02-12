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
 * Set value type constants.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table("FC_SETVALUETYPE")
@StaticList(name = "setvaluetypelist", description = "$m{staticlist.setvaluetypelist}")
public enum SetValueType implements EnumConst {

    NULL(
            "NUL",
            "$m{setvaluetype.issettonull}", true),
    IMMEDIATE(
            "IMM",
            "$m{setvaluetype.issetto}", false),
    IMMEDIATE_LINGUAL(
            "IML",
            "$m{setvaluetype.issettolingual}", false),
    IMMEDIATE_FIELD(
            "IMF",
            "$m{setvaluetype.issettofield}", true),
    GENERATOR(
            "GEN",
            "$m{setvaluetype.isgeneratedfrom}", true);

    private final String code;

    private final String label;
    
    private final boolean supportsRef;

    private SetValueType(String code, String label, boolean supportsRef) {
        this.code = code;
        this.label = label;
        this.supportsRef = supportsRef;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String defaultCode() {
        return IMMEDIATE.code;
    }

    public boolean isSupportsRef() {
        return supportsRef;
    }

    public boolean isNoParam() {
        return NULL.equals(this);
    }

    public boolean isLingual() {
        return IMMEDIATE_LINGUAL.equals(this);
    }

    public String label() {
        return this.label;
    }

    public static SetValueType fromCode(String code) {
        return EnumUtils.fromCode(SetValueType.class, code);
    }

    public static SetValueType fromName(String name) {
        return EnumUtils.fromName(SetValueType.class, name);
    }
}
