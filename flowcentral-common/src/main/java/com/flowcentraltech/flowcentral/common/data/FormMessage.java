/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.data;

import com.tcdng.unify.web.ui.constant.MessageType;

/**
 * Message type.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class FormMessage {
    
    private MessageType type;
    
    private String message;

    public FormMessage(MessageType type, String message) {
        this.type = type;
        this.message = message;
    }

    public MessageType getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "FormMessage [type=" + type + ", message=" + message + "]";
    }
}
