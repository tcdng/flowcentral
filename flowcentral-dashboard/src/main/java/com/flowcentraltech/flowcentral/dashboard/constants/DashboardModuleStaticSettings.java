/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.dashboard.constants;

import com.flowcentraltech.flowcentral.configuration.constants.AbstractFlowCentralStaticSettings;
import com.flowcentraltech.flowcentral.configuration.constants.ModuleInstallLevelConstants;
import com.tcdng.unify.core.annotation.AutoDetect;

/**
 * Dashboard module static settings.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@AutoDetect
public class DashboardModuleStaticSettings extends AbstractFlowCentralStaticSettings {

    public DashboardModuleStaticSettings() {
        super(DashboardModuleNameConstants.DASHBOARD_MODULE_SERVICE, "config/dashboard-module.xml",
                "com.flowcentraltech.flowcentral.resources.dashboard-messages",
                ModuleInstallLevelConstants.DASHBOARD_MODULE_LEVEL);
    }

}
