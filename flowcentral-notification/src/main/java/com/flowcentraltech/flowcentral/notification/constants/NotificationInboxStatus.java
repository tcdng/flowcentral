/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.notification.constants;

import com.tcdng.unify.convert.constants.EnumConst;
import com.tcdng.unify.core.annotation.StaticList;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.util.EnumUtils;

/**
 * Notification inbox status constants.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table("FC_NOTIFINBOXSTATUS")
@StaticList(name = "notificationinboxstatuslist", description = "$m{staticlist.notificationinboxstatuslist}")
public enum NotificationInboxStatus implements EnumConst {

    NOT_READ(
            "N"),
    READ(
            "R");

    private final String code;

    private NotificationInboxStatus(String code) {
        this.code = code;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String defaultCode() {
        return NOT_READ.code;
    }

    public static NotificationOutboxStatus fromCode(String code) {
        return EnumUtils.fromCode(NotificationOutboxStatus.class, code);
    }

    public static NotificationOutboxStatus fromName(String name) {
        return EnumUtils.fromName(NotificationOutboxStatus.class, name);
    }
}
