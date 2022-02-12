/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.flowcentraltech.flowcentral.configuration.xml.adapter.MessageTypeXmlAdapter;
import com.tcdng.unify.web.ui.constant.MessageType;

/**
 * Form review policy configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class FormReviewPolicyConfig extends FormValidationPolicyConfig {

    private MessageType messageType;

    private String events;

    public MessageType getMessageType() {
        return messageType;
    }

    @XmlJavaTypeAdapter(MessageTypeXmlAdapter.class)
    @XmlAttribute
    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String getEvents() {
        return events;
    }

    @XmlAttribute
    public void setEvents(String events) {
        this.events = events;
    }

}
