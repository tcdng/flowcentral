/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.notification.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseEntity;
import com.flowcentraltech.flowcentral.configuration.constants.NotificationMessageFormat;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ColumnType;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.Table;

/**
 * Notification message entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_NOTIFOUTBOXMESSAGE")
public class NotificationOutboxMessage extends BaseEntity {

    @ForeignKey(NotificationOutbox.class)
    private Long notificationId;

    @ForeignKey
    private NotificationMessageFormat format;

    @Column(type = ColumnType.CLOB)
    private String message;

    public NotificationOutboxMessage(NotificationMessageFormat format, String message) {
        this.format = format;
        this.message = message;
    }

    public NotificationOutboxMessage() {

    }

    @Override
    public String getDescription() {
        return null;
    }

    public Long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }

    public NotificationMessageFormat getFormat() {
        return format;
    }

    public void setFormat(NotificationMessageFormat format) {
        this.format = format;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
