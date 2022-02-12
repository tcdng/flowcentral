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
 * Form columns type constants.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table("FC_FORMCOLUMNSTYPE")
@StaticList(name = "formcolumnstypelist", description = "$m{staticlist.formcolumnstypelist}")
public enum FormColumnsType implements EnumConst {

    TYPE_1(
            "1", 1),
    TYPE_2(
            "2", 2),
    TYPE_1_2(
            "1-2", 3),
    TYPE_2_1(
            "2-1", 3),
    TYPE_3(
            "3", 3),
    TYPE_4(
            "4", 4);

    private final String code;

    private final int columns;

    private FormColumnsType(String code, int columns) {
        this.code = code;
        this.columns = columns;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String defaultCode() {
        return TYPE_1.code;
    }

    public int columns() {
        return columns;
    }

    public static FormColumnsType fromCode(String code) {
        return EnumUtils.fromCode(FormColumnsType.class, code);
    }

    public static FormColumnsType fromName(String name) {
        return EnumUtils.fromName(FormColumnsType.class, name);
    }
}
