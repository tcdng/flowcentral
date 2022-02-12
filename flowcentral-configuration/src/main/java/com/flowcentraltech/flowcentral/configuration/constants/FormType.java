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
 * Form type.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table("FC_FORMTYPE")
@StaticList(name = "formtypelist", description = "$m{staticlist.formtypelist}")
public enum FormType implements EnumConst {

    INPUT(
            "INP"),
    LISTING(
            "LST");

    private final String code;

    private FormType(String code) {
        this.code = code;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String defaultCode() {
        return INPUT.code;
    }

    public boolean isInputForm() {
        return INPUT.equals(this);
    }

    public boolean isListingForm() {
        return LISTING.equals(this);
    }

    public static FormType fromCode(String code) {
        return EnumUtils.fromCode(FormType.class, code);
    }

    public static FormType fromName(String name) {
        return EnumUtils.fromName(FormType.class, name);
    }
}
