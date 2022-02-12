/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.system.constants;

import com.flowcentraltech.flowcentral.configuration.constants.AbstractFlowCentralStaticSettings;
import com.flowcentraltech.flowcentral.configuration.constants.ModuleInstallLevelConstants;
import com.tcdng.unify.core.annotation.AutoDetect;

/**
 * System module static settings.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@AutoDetect
public class SystemModuleStaticSettings extends AbstractFlowCentralStaticSettings {

    public SystemModuleStaticSettings() {
        super(SystemModuleNameConstants.SYSTEM_MODULE_SERVICE, "config/system-module.xml",
                "com.flowcentraltech.flowcentral.resources.system-messages", ModuleInstallLevelConstants.SYSTEM_MODULE_LEVEL);
    }

}
