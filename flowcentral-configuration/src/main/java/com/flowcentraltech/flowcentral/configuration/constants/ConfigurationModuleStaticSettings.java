/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.constants;

import com.tcdng.unify.core.annotation.AutoDetect;

/**
 * Configuration module static settings.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@AutoDetect
public class ConfigurationModuleStaticSettings extends AbstractFlowCentralStaticSettings {

    public ConfigurationModuleStaticSettings() {
        super("com.flowcentraltech.flowcentral.resources.configuration-messages",
                ModuleInstallLevelConstants.CONFIGURATION_MODULE_LEVEL);
    }

}
