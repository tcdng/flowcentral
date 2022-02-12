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
 * Form review type constants.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table("FC_FORMREVIEWTYPE")
@StaticList(name = "formreviewtypelist", description = "$m{staticlist.formreviewtypelist}")
public enum FormReviewType implements EnumConst {

    ON_SAVE(
            "ONS", false),
    ON_SAVE_NEXT(
            "OSN", true),
    ON_SAVE_CLOSE(
            "OSC", true),
    ON_UPDATE(
            "ONU", false),
    ON_UPDATE_CLOSE(
            "OUC", true),
    ON_SUBMIT(
            "ONB", true),
    ON_SUBMIT_NEXT(
            "OBN", true),
    ON_CLOSE(
            "OCL", true);

    private final String code;

    private final boolean formClosedOrReplaced;
    
    private FormReviewType(String code, boolean formClosedOrReplaced) {
        this.code = code;
        this.formClosedOrReplaced = formClosedOrReplaced;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String defaultCode() {
        return ON_SAVE.code;
    }

    public boolean formClosedOrReplaced() {
        return formClosedOrReplaced;
    }
    
    public static FormReviewType fromCode(String code) {
        return EnumUtils.fromCode(FormReviewType.class, code);
    }

    public static FormReviewType fromName(String name) {
        return EnumUtils.fromName(FormReviewType.class, name);
    }
}
