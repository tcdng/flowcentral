/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.configuration.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.flowcentraltech.flowcentral.configuration.constants.NotificationMessageFormat;
import com.flowcentraltech.flowcentral.configuration.constants.NotificationType;
import com.flowcentraltech.flowcentral.configuration.xml.adapter.NotificationMessageFormatXmlAdapter;
import com.flowcentraltech.flowcentral.configuration.xml.adapter.NotificationTypeXmlAdapter;
import com.tcdng.unify.core.util.xml.adapter.CDataXmlAdapter;

/**
 * Notification template configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@XmlRootElement(name = "notifTemplate")
public class NotifTemplateConfig extends BaseNameConfig {

    private NotificationType notificationType;

    private NotificationMessageFormat messageFormat;

    private String entity;

    private String subject;

    private String body;

    private String attachmentGenerator;

    public NotifTemplateConfig() {
        messageFormat = NotificationMessageFormat.PLAIN_TEXT;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    @XmlJavaTypeAdapter(NotificationTypeXmlAdapter.class)
    @XmlAttribute(name = "type", required = true)
    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public NotificationMessageFormat getMessageFormat() {
        return messageFormat;
    }

    @XmlJavaTypeAdapter(NotificationMessageFormatXmlAdapter.class)
    @XmlAttribute(name = "format")
    public void setMessageFormat(NotificationMessageFormat messageFormat) {
        this.messageFormat = messageFormat;
    }

    public String getEntity() {
        return entity;
    }

    @XmlAttribute(required = true)
    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getSubject() {
        return subject;
    }

    @XmlJavaTypeAdapter(CDataXmlAdapter.class)
    @XmlElement(required = true)
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    @XmlJavaTypeAdapter(CDataXmlAdapter.class)
    @XmlElement(required = true)
    public void setBody(String body) {
        this.body = body;
    }

    public String getAttachmentGenerator() {
        return attachmentGenerator;
    }

    @XmlAttribute
    public void setAttachmentGenerator(String attachmentGenerator) {
        this.attachmentGenerator = attachmentGenerator;
    }

}
