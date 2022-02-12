/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.report.constants;

import com.flowcentraltech.flowcentral.configuration.constants.AbstractFlowCentralStaticSettings;
import com.flowcentraltech.flowcentral.configuration.constants.ModuleInstallLevelConstants;
import com.tcdng.unify.core.annotation.AutoDetect;

/**
 * Report module static settings.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@AutoDetect
public class ReportModuleStaticSettings extends AbstractFlowCentralStaticSettings {

    public ReportModuleStaticSettings() {
        super(ReportModuleNameConstants.REPORT_MODULE_SERVICE, "config/report-module.xml",
                "com.flowcentraltech.flowcentral.resources.report-messages", ModuleInstallLevelConstants.REPORT_MODULE_LEVEL);
    }

}
