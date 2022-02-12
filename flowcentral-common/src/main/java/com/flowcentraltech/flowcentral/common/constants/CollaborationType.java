/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.constants;

import com.tcdng.unify.convert.constants.EnumConst;
import com.tcdng.unify.core.annotation.StaticList;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.util.EnumUtils;

/**
 * Collaboration type.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table("FC_COLLABORATIONTYPE")
@StaticList(name = "collaborationtypelist", description = "$m{staticlist.collaborationtypelist}")
public enum CollaborationType implements EnumConst {

    ENTITY(
            "ENT"),
    REFERENCE(
            "REF"),
    APPLET(
            "APL"),
    CHART(
            "CRT"),
    DASHBOARD(
            "DSH"),
    NOTIFICATION_TEMPLATE(
            "NTP"),
    REPORT_CONFIGURATION(
            "RPC"),
    FORM(
            "FRM"),
    TABLE(
            "TBL"),
    WORKFLOW(
            "WRK");

    private final String code;

    private CollaborationType(String code) {
        this.code = code;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String defaultCode() {
        return ENTITY.code;
    }

    public static CollaborationType fromCode(String code) {
        return EnumUtils.fromCode(CollaborationType.class, code);
    }

    public static CollaborationType fromName(String name) {
        return EnumUtils.fromName(CollaborationType.class, name);
    }
}
