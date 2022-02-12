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
 * Message format constants.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table("FC_NOTIFMESSAGEFORMAT")
@StaticList(name = "notifmessageformatlist", description = "$m{staticlist.notifmessageformatlist}")
public enum NotificationMessageFormat implements EnumConst {

    PLAIN_TEXT(
            "PLT"),
    HTML(
            "HTM");

    private final String code;

    private NotificationMessageFormat(String code) {
        this.code = code;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String defaultCode() {
        return PLAIN_TEXT.code;
    }

    public static NotificationMessageFormat fromCode(String code) {
        return EnumUtils.fromCode(NotificationMessageFormat.class, code);
    }

    public static NotificationMessageFormat fromName(String name) {
        return EnumUtils.fromName(NotificationMessageFormat.class, name);
    }
}
