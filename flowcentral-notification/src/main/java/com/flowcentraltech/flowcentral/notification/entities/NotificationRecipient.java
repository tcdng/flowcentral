/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.notification.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseEntity;
import com.flowcentraltech.flowcentral.configuration.constants.NotificationRecipientType;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.ListOnly;
import com.tcdng.unify.core.annotation.Table;

/**
 * Notification recipient entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_NOTIFRECIPIENT")
public class NotificationRecipient extends BaseEntity {

    @ForeignKey(NotificationOutbox.class)
    private Long notificationId;

    @ForeignKey
    private NotificationRecipientType type;

    @Column(length = 64)
    private String recipientName;

    @Column(length = 96)
    private String recipientContact;

    @ListOnly(key = "type", property = "description")
    private String typeDesc;

    @Override
    public String getDescription() {
        return recipientName;
    }

    public Long getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Long notificationId) {
        this.notificationId = notificationId;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getRecipientContact() {
        return recipientContact;
    }

    public void setRecipientContact(String recipientContact) {
        this.recipientContact = recipientContact;
    }

    public NotificationRecipientType getType() {
        return type;
    }

    public void setType(NotificationRecipientType type) {
        this.type = type;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }
}
