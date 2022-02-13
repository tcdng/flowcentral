/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.notification.entities;

import java.util.List;

import com.flowcentraltech.flowcentral.common.entities.BaseStatusEntity;
import com.flowcentraltech.flowcentral.configuration.constants.NotificationType;
import com.tcdng.unify.core.annotation.ChildList;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.ListOnly;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.annotation.UniqueConstraint;

/**
 * Notification channel entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_NOTIFCHANNEL", uniqueConstraints = { @UniqueConstraint({ "notificationType" }),
        @UniqueConstraint({ "name" }), @UniqueConstraint({ "description" }) })
public class NotificationChannel extends BaseStatusEntity {

    @ForeignKey
    private NotificationType notificationType;

    @Column(name = "CHANNEL_NM", length = 48)
    private String name;

    @Column(name = "CHANNEL_DESC", length = 64)
    private String description;

    @Column(name = "SENDER_NM", length = 64)
    private String senderName;

    @Column(length = 96)
    private String senderContact;

    @ListOnly(key = "notificationType", property = "description")
    private String notificationTypeDesc;

    @ChildList
    private List<NotificationChannelProp> notificationChannelPropList;

    @Override
    public String getDescription() {
        return description;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderContact() {
        return senderContact;
    }

    public void setSenderContact(String senderContact) {
        this.senderContact = senderContact;
    }

    public String getNotificationTypeDesc() {
        return notificationTypeDesc;
    }

    public void setNotificationTypeDesc(String notificationTypeDesc) {
        this.notificationTypeDesc = notificationTypeDesc;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<NotificationChannelProp> getNotificationChannelPropList() {
        return notificationChannelPropList;
    }

    public void setNotificationChannelPropList(List<NotificationChannelProp> notificationChannelPropList) {
        this.notificationChannelPropList = notificationChannelPropList;
    }

}