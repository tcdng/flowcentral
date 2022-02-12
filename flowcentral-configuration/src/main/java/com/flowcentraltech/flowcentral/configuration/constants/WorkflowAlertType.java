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
 * Workflow alert type constants.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table("FC_WFALERTTYPE")
@StaticList(name = "wfalerttypelist", description = "$m{staticlist.wfalerttypelist}")
public enum WorkflowAlertType implements EnumConst {

    PASS_THROUGH(
            "P"),
    USER_INTERACT(
            "U"),
    CRITICAL_NOTIFICATION(
            "C"),
    EXPIRATION_NOTIFICATION(
            "E");

    private final String code;

    private WorkflowAlertType(String code) {
        this.code = code;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String defaultCode() {
        return USER_INTERACT.code;
    }

    public boolean isPassThrough() {
        return PASS_THROUGH.equals(this);
    }

    public boolean isUserInteract() {
        return USER_INTERACT.equals(this);
    }

    public boolean isCriticalNotification() {
        return CRITICAL_NOTIFICATION.equals(this);
    }

    public boolean isExpirationNotification() {
        return EXPIRATION_NOTIFICATION.equals(this);
    }

    public static WorkflowAlertType fromCode(String code) {
        return EnumUtils.fromCode(WorkflowAlertType.class, code);
    }

    public static WorkflowAlertType fromName(String name) {
        return EnumUtils.fromName(WorkflowAlertType.class, name);
    }
}
