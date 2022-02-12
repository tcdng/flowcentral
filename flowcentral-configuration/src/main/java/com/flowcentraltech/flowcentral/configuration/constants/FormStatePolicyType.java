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
 * Form state policy type.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table("FC_FORMSTATEPOLICYTYPE")
@StaticList(name = "formstatepolicytypelist", description = "$m{staticlist.formstatepolicytypelist}")
public enum FormStatePolicyType implements EnumConst {

    /* Executes on creation of form*/
    ON_CREATE(
            "CRT"),
    /* Executes on switch of a field*/
    ON_SWITCH(
            "SWH"),
    /* Executes on construction of form. Only value generators are fired*/
    ON_FORM_CONSTRUCT_SET_VALUES(
            "FCV"),
    /* Executes on actual 'save' or 'update'. Only value generators are fired*/
    ON_DELAYED_SET_VALUES(
            "DSV");

    private final String code;

    private FormStatePolicyType(String code) {
        this.code = code;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String defaultCode() {
        return ON_CREATE.code;
    }

    public static FormStatePolicyType fromCode(String code) {
        return EnumUtils.fromCode(FormStatePolicyType.class, code);
    }

    public static FormStatePolicyType fromName(String name) {
        return EnumUtils.fromName(FormStatePolicyType.class, name);
    }
}
