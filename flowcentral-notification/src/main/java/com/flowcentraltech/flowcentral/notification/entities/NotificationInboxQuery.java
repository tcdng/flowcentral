/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.notification.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseAuditEntityQuery;
import com.flowcentraltech.flowcentral.notification.constants.NotificationInboxStatus;

/**
 * Notification inbox query class;
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class NotificationInboxQuery extends BaseAuditEntityQuery<NotificationInbox> {

    public NotificationInboxQuery() {
        super(NotificationInbox.class);
    }

    public NotificationInboxQuery userLoginId(String userLoginId) {
        return (NotificationInboxQuery) addEquals("userLoginId", userLoginId);
    }

    public NotificationInboxQuery status(NotificationInboxStatus status) {
        return (NotificationInboxQuery) addEquals("status", status);
    }
}
