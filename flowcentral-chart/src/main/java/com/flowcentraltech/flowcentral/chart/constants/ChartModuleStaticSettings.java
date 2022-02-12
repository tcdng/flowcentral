/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.chart.constants;

import com.flowcentraltech.flowcentral.configuration.constants.AbstractFlowCentralStaticSettings;
import com.flowcentraltech.flowcentral.configuration.constants.ModuleInstallLevelConstants;
import com.tcdng.unify.core.annotation.AutoDetect;

/**
 * Chart module static settings.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@AutoDetect
public class ChartModuleStaticSettings extends AbstractFlowCentralStaticSettings {

    public ChartModuleStaticSettings() {
        super(ChartModuleNameConstants.CHART_MODULE_SERVICE, "config/chart-module.xml",
                "com.flowcentraltech.flowcentral.resources.chart-messages", ModuleInstallLevelConstants.CHART_MODULE_LEVEL);
    }

}
