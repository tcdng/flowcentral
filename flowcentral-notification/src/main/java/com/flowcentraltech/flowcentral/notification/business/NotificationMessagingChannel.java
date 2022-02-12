/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.notification.business;

import com.flowcentraltech.flowcentral.notification.data.NotificationChannelDef;
import com.flowcentraltech.flowcentral.notification.data.NotificationChannelMessage;
import com.tcdng.unify.core.UnifyComponent;

/**
 * Notification messaging channel.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface NotificationMessagingChannel extends UnifyComponent {

    /**
     * Sends a message through a notification channel.
     * 
     * @param notifChannelDef
     *                            the channel definition
     * @param notifChannelMessage
     *                            the message to send
     * @return true if message was successfully sent otherwise false
     */
    boolean sendMessage(NotificationChannelDef notifChannelDef, NotificationChannelMessage notifChannelMessage);

    /**
     * Sends multiple messages through a notification channel.
     * 
     * @param notifChannelDef
     *                             the channel definition
     * @param notifChannelMessages
     *                             the messages to send
     */
    void sendMessages(NotificationChannelDef notifChannelDef, NotificationChannelMessage... notifChannelMessages);
}
