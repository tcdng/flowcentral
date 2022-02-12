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
import com.tcdng.unify.core.notification.EmailRecipient;
import com.tcdng.unify.core.util.EnumUtils;

/**
 * Notification recipient type.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table("FC_NOTIFRECIPIENTTYPE")
@StaticList(name = "notificationrecipienttypelist", description = "$m{staticlist.notificationrecipienttypelist}")
public enum NotificationRecipientType implements EnumConst {

    TO(
            "TO",
            EmailRecipient.TYPE.TO),
    CC(
            "CC",
            EmailRecipient.TYPE.CC),
    BCC(
            "BC",
            EmailRecipient.TYPE.BCC);

    private final String code;

    private final EmailRecipient.TYPE emailRecipientType;

    private NotificationRecipientType(String code, EmailRecipient.TYPE emailRecipientType) {
        this.code = code;
        this.emailRecipientType = emailRecipientType;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String defaultCode() {
        return TO.code;
    }

    public EmailRecipient.TYPE emailRecipientType() {
        return emailRecipientType;
    }

    public static NotificationRecipientType fromCode(String code) {
        return EnumUtils.fromCode(NotificationRecipientType.class, code);
    }

    public static NotificationRecipientType fromName(String name) {
        return EnumUtils.fromName(NotificationRecipientType.class, name);
    }
}
