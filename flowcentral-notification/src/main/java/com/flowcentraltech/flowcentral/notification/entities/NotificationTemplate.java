/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.notification.entities;

import com.flowcentraltech.flowcentral.application.entities.BaseApplicationEntity;
import com.flowcentraltech.flowcentral.configuration.constants.NotificationMessageFormat;
import com.flowcentraltech.flowcentral.configuration.constants.NotificationType;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ColumnType;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.ListOnly;
import com.tcdng.unify.core.annotation.Table;

/**
 * Entity for storing notification template information.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_NOTIFTEMPLATE")
public class NotificationTemplate extends BaseApplicationEntity {

    @ForeignKey
    private NotificationType notificationType;

    @ForeignKey
    private NotificationMessageFormat messageFormat;

    @Column(length = 128)
    private String entity;

    @Column(length = 128)
    private String subject;

    @Column(type = ColumnType.CLOB)
    private String template;

    @Column(length = 64, nullable = true)
    private String attachmentGenerator;

    @ListOnly(key = "notificationType", property = "description")
    private String notificationTypeDesc;

    @ListOnly(key = "messageFormat", property = "description")
    private String messageFormatDesc;

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public String getNotificationTypeDesc() {
        return notificationTypeDesc;
    }

    public void setNotificationTypeDesc(String notificationDesc) {
        this.notificationTypeDesc = notificationDesc;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getAttachmentGenerator() {
        return attachmentGenerator;
    }

    public void setAttachmentGenerator(String attachmentGenerator) {
        this.attachmentGenerator = attachmentGenerator;
    }

    public NotificationMessageFormat getMessageFormat() {
        return messageFormat;
    }

    public void setMessageFormat(NotificationMessageFormat messageFormat) {
        this.messageFormat = messageFormat;
    }

    public String getMessageFormatDesc() {
        return messageFormatDesc;
    }

    public void setMessageFormatDesc(String messageFormatDesc) {
        this.messageFormatDesc = messageFormatDesc;
    }

}
