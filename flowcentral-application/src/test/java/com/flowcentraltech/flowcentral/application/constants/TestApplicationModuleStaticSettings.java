/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.constants;

import com.flowcentraltech.flowcentral.configuration.constants.AbstractFlowCentralStaticSettings;
import com.flowcentraltech.flowcentral.configuration.constants.ModuleInstallLevelConstants;
import com.tcdng.unify.core.annotation.AutoDetect;

/**
 * Test application module static settings.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@AutoDetect
public class TestApplicationModuleStaticSettings extends AbstractFlowCentralStaticSettings {

    public TestApplicationModuleStaticSettings() {
        super(ApplicationModuleNameConstants.APPLICATION_MODULE_SERVICE, "config/test-application-module.xml",
                "com.flowcentraltech.flowcentral.resources.test-application-messages",
                ModuleInstallLevelConstants.APPLICATION_MODULE_LEVEL);
    }

}
