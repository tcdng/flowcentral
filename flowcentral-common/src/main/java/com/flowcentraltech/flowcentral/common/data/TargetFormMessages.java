/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.data;

import java.util.ArrayList;
import java.util.List;

import com.tcdng.unify.core.util.DataUtils;
import com.tcdng.unify.web.ui.constant.MessageType;

/**
 * Target form messages.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class TargetFormMessages {

    private List<TargetFormMessage> messageList;

    public TargetFormMessages() {
        this.messageList = new ArrayList<TargetFormMessage>();
    }

    public void addMessage(String message, String... targets) {
        messageList.add(new TargetFormMessage(new FormMessage(MessageType.INFO, message), targets));
    }

    public void addInfo(String message, String... targets) {
        messageList.add(new TargetFormMessage(new FormMessage(MessageType.INFO, message), targets));
    }

    public void addWarning(String message, String... targets) {
        messageList.add(new TargetFormMessage(new FormMessage(MessageType.WARNING, message), targets));
    }

    public void addError(String message, String... targets) {
        messageList.add(new TargetFormMessage(new FormMessage(MessageType.ERROR, message), targets));
    }

    public List<TargetFormMessage> getMessages() {
        return DataUtils.unmodifiableList(messageList);
    }
}
