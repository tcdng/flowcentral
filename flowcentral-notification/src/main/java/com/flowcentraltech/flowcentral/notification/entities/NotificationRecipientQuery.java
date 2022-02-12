/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.notification.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseEntityQuery;

/**
 * Notification recipient query class;
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class NotificationRecipientQuery extends BaseEntityQuery<NotificationRecipient> {

    public NotificationRecipientQuery() {
        super(NotificationRecipient.class);
    }

    public NotificationRecipientQuery notificationId(Long notificationId) {
        return (NotificationRecipientQuery) addEquals("notificationId", notificationId);
    }

    public NotificationRecipientQuery recipientNameLike(String recipientName) {
        return (NotificationRecipientQuery) addLike("recipientName", recipientName);
    }
}
