/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.notification.entities;

import java.util.Date;

import com.flowcentraltech.flowcentral.common.entities.BaseAuditEntityQuery;
import com.flowcentraltech.flowcentral.configuration.constants.NotificationType;
import com.flowcentraltech.flowcentral.notification.constants.NotificationOutboxStatus;
import com.tcdng.unify.core.util.CalendarUtils;

/**
 * Notification outbox query class.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class NotificationOutboxQuery extends BaseAuditEntityQuery<NotificationOutbox> {

    public NotificationOutboxQuery() {
        super(NotificationOutbox.class);
    }

    public NotificationOutboxQuery notificationChannelId(Long notificationChannelId) {
        return (NotificationOutboxQuery) addEquals("notificationChannelId", notificationChannelId);
    }

    public NotificationOutboxQuery moduleId(Long moduleId) {
        return (NotificationOutboxQuery) addEquals("moduleId", moduleId);
    }

    public NotificationOutboxQuery moduleName(String moduleName) {
        return (NotificationOutboxQuery) addEquals("moduleName", moduleName);
    }

    public NotificationOutboxQuery type(NotificationType type) {
        return (NotificationOutboxQuery) addEquals("type", type);
    }

    public NotificationOutboxQuery sentOn(Date date) {
        return (NotificationOutboxQuery) addBetween("sentDt", CalendarUtils.getMidnightDate(date),
                CalendarUtils.getLastSecondDate(date));
    }

    public NotificationOutboxQuery due(Date now) {
        return (NotificationOutboxQuery) addLessThanEqual("nextAttemptDt", now);
    }

    public NotificationOutboxQuery status(NotificationOutboxStatus status) {
        return (NotificationOutboxQuery) addEquals("status", status);
    }
}
