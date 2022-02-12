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
 * Form element type constants.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table("FC_FORMELEMENTTYPE")
@StaticList(name = "formelementtypelist", description = "$m{staticlist.formelementtypelist}")
public enum FormElementType implements EnumConst {

    ANNOTATION(
            "ANO"),
    TAB(
            "TAB"),
    SECTION(
            "SEC"),
    FIELD(
            "FLD");

    private final String code;

    private FormElementType(String code) {
        this.code = code;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String defaultCode() {
        return FIELD.code;
    }

    public boolean isAnnotationType() {
        return ANNOTATION.equals(this);
    }

    public boolean isTabType() {
        return TAB.equals(this);
    }

    public boolean isSectionType() {
        return SECTION.equals(this);
    }

    public boolean isFieldType() {
        return FIELD.equals(this);
    }

    public static FormElementType fromCode(String code) {
        return EnumUtils.fromCode(FormElementType.class, code);
    }

    public static FormElementType fromName(String name) {
        return EnumUtils.fromName(FormElementType.class, name);
    }
}
