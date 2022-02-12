/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.notification.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseEntityQuery;

/**
 * Notification attachment query class;
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class NotificationOutboxMessageQuery extends BaseEntityQuery<NotificationOutboxMessage> {

    public NotificationOutboxMessageQuery() {
        super(NotificationOutboxMessage.class);
    }

    public NotificationOutboxMessageQuery notificationId(Long notificationId) {
        return (NotificationOutboxMessageQuery) addEquals("notificationId", notificationId);
    }

}
