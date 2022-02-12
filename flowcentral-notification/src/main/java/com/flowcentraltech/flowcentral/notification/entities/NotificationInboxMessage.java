/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.notification.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseEntity;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ColumnType;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.Table;

/**
 * Notification inbox message entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_INBOXMESSAGE")
public class NotificationInboxMessage extends BaseEntity {

    @ForeignKey(NotificationInbox.class)
    private Long notificationInboxId;

    @Column(type = ColumnType.CLOB)
    private String message;

    @Override
    public String getDescription() {
        return null;
    }

    public Long getNotificationInboxId() {
        return notificationInboxId;
    }

    public void setNotificationInboxId(Long notificationInboxId) {
        this.notificationInboxId = notificationInboxId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
