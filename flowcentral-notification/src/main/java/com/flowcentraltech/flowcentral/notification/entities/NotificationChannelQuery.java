/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.notification.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseStatusEntityQuery;
import com.flowcentraltech.flowcentral.configuration.constants.NotificationType;

/**
 * Notification channel query class;
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class NotificationChannelQuery extends BaseStatusEntityQuery<NotificationChannel> {

    public NotificationChannelQuery() {
        super(NotificationChannel.class);
    }

    public NotificationChannelQuery notificationType(NotificationType notificationType) {
        return (NotificationChannelQuery) addEquals("notificationType", notificationType);
    }

    public NotificationChannelQuery name(String name) {
        return (NotificationChannelQuery) addEquals("name", name);
    }

    public NotificationChannelQuery nameLike(String name) {
        return (NotificationChannelQuery) addLike("name", name);
    }

    public NotificationChannelQuery descriptionLike(String description) {
        return (NotificationChannelQuery) addLike("description", description);
    }

}
