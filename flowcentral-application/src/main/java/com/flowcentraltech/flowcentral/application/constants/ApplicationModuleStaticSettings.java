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
 * Application module static settings.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@AutoDetect
public class ApplicationModuleStaticSettings extends AbstractFlowCentralStaticSettings {

    public ApplicationModuleStaticSettings() {
        super(ApplicationModuleNameConstants.APPLICATION_MODULE_SERVICE, "config/application-module.xml",
                "com.flowcentraltech.flowcentral.resources.application-messages",
                ModuleInstallLevelConstants.APPLICATION_MODULE_LEVEL);
    }

}
