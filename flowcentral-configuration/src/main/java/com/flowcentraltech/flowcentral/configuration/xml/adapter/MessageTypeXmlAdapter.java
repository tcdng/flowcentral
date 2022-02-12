/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml.adapter;

import com.tcdng.unify.core.util.xml.AbstractEnumConstXmlAdapter;
import com.tcdng.unify.web.ui.constant.MessageType;

/**
 * Message type type XML adapter.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class MessageTypeXmlAdapter extends AbstractEnumConstXmlAdapter<MessageType> {

    public MessageTypeXmlAdapter() {
        super(MessageType.class);
    }
}
