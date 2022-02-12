/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.data;

import com.flowcentraltech.flowcentral.configuration.xml.NotifTemplateConfig;

/**
 * Notification template installation configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class NotifTemplateInstall {

    private NotifTemplateConfig notifTemplateConfig;

    public NotifTemplateInstall(NotifTemplateConfig notifTemplateConfig) {
        this.notifTemplateConfig = notifTemplateConfig;
    }

    public NotifTemplateConfig getNotifTemplateConfig() {
        return notifTemplateConfig;
    }

}
