/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.security.constants;

import com.tcdng.unify.convert.constants.EnumConst;
import com.tcdng.unify.core.annotation.StaticList;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.util.EnumUtils;

/**
 * User workflow status.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table("FC_USERWORKFLOWSTATUS")
@StaticList(name = "userworkflowstatuslist", description = "$m{staticlist.userworkflowstatuslist}")
public enum UserWorkflowStatus implements EnumConst {

    NEW(
            "NEW"),
    AWAITING_APPROVAL(
            "AWA"),
    APPROVED(
            "APR");

    private final String code;

    private UserWorkflowStatus(String code) {
        this.code = code;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String defaultCode() {
        return APPROVED.code;
    }

    public static UserWorkflowStatus fromCode(String code) {
        return EnumUtils.fromCode(UserWorkflowStatus.class, code);
    }

    public static UserWorkflowStatus fromName(String name) {
        return EnumUtils.fromName(UserWorkflowStatus.class, name);
    }

}
