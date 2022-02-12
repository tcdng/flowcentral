/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.common.constants;

import com.tcdng.unify.convert.constants.EnumConst;
import com.tcdng.unify.core.util.EnumUtils;

/**
 * Dialog form mode enumeration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public enum DialogFormMode implements EnumConst {

    CREATE(
            "C"),
    CREATE_SUB(
            "S"),
    UPDATE(
            "U"),
    DELETE(
            "D");

    private final String code;

    private DialogFormMode(String code) {
        this.code = code;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String defaultCode() {
        return CREATE.code;
    }

    public boolean isCreate() {
        return CREATE.equals(this);
    }

    public boolean isUpdate() {
        return UPDATE.equals(this);
    }

    public boolean isDelete() {
        return DELETE.equals(this);
    }

    public static DialogFormMode fromCode(String code) {
        return EnumUtils.fromCode(DialogFormMode.class, code);
    }

    public static DialogFormMode fromName(String name) {
        return EnumUtils.fromName(DialogFormMode.class, name);
    }

}
