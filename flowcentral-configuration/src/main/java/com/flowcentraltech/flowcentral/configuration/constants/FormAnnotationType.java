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
 * Form annotation type.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table("FC_FORMANNOTATIONTYPE")
@StaticList(name = "formannotationtypelist", description = "$m{staticlist.formannotationtypelist}")
public enum FormAnnotationType implements EnumConst {

    INFO(
            "I",
            "info"),
    WARNING(
            "W",
            "warning"),
    ERROR(
            "E",
            "error");

    private final String code;

    private final String styleClass;

    private FormAnnotationType(String code, String styleClass) {
        this.code = code;
        this.styleClass = styleClass;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String defaultCode() {
        return INFO.code;
    }

    public String styleClass() {
        return styleClass;
    }

    public static FormAnnotationType fromCode(String code) {
        return EnumUtils.fromCode(FormAnnotationType.class, code);
    }

    public static FormAnnotationType fromName(String name) {
        return EnumUtils.fromName(FormAnnotationType.class, name);
    }
}
