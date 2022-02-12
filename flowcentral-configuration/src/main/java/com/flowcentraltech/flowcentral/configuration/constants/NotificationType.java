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
 * Notification type constants.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table("FC_NOTIFICATIONTYPE")
@StaticList(name = "notificationtypelist", description = "$m{staticlist.notificationtypelist}")
public enum NotificationType implements EnumConst {

    SYSTEM(
            "SYS"),
    EMAIL(
            "EML"),
    SMS(
            "SMS");

    private final String code;

    private NotificationType(String code) {
        this.code = code;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String defaultCode() {
        return SYSTEM.code;
    }

    public static NotificationType fromCode(String code) {
        return EnumUtils.fromCode(NotificationType.class, code);
    }

    public static NotificationType fromName(String name) {
        return EnumUtils.fromName(NotificationType.class, name);
    }
}
