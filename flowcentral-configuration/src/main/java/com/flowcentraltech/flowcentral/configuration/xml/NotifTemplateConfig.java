/*
 * Copyright 2021-2022 FlowCentral Technologies Limited.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
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
 * @author FlowCentral Technologies Limited
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
