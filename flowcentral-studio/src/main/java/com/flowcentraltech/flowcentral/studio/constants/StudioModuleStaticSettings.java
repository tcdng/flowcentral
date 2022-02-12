/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.studio.constants;

import com.flowcentraltech.flowcentral.configuration.constants.AbstractFlowCentralStaticSettings;
import com.flowcentraltech.flowcentral.configuration.constants.ModuleInstallLevelConstants;
import com.tcdng.unify.core.annotation.AutoDetect;

/**
 * Studio module static settings.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@AutoDetect
public class StudioModuleStaticSettings extends AbstractFlowCentralStaticSettings {

    public StudioModuleStaticSettings() {
        super(StudioModuleNameConstants.STUDIO_MODULE_SERVICE, "config/studio-module.xml",
                "com.flowcentraltech.flowcentral.resources.studio-messages", ModuleInstallLevelConstants.STUDIO_MODULE_LEVEL);
    }

}
