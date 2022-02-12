/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.notification.entities;

import com.flowcentraltech.flowcentral.application.entities.BaseApplicationEntityQuery;

/**
 * Query class for notification template records.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class NotificationTemplateQuery extends BaseApplicationEntityQuery<NotificationTemplate> {

    public NotificationTemplateQuery() {
        super(NotificationTemplate.class);
    }

    public NotificationTemplateQuery entity(String entity) {
        return (NotificationTemplateQuery) addEquals("entity", entity);
    }
}
