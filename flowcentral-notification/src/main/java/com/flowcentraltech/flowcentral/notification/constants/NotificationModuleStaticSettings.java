/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.notification.constants;

import com.flowcentraltech.flowcentral.configuration.constants.AbstractFlowCentralStaticSettings;
import com.flowcentraltech.flowcentral.configuration.constants.ModuleInstallLevelConstants;
import com.tcdng.unify.core.annotation.AutoDetect;

/**
 * Notification module static settings.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@AutoDetect
public class NotificationModuleStaticSettings extends AbstractFlowCentralStaticSettings {

    public NotificationModuleStaticSettings() {
        super(NotificationModuleNameConstants.NOTIFICATION_MODULE_SERVICE, "config/notification-module.xml",
                "com.flowcentraltech.flowcentral.resources.notification-messages",
                ModuleInstallLevelConstants.NOTIFICATION_MODULE_LEVEL);
    }

}
