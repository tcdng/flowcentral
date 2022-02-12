/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.security.constants;

import com.flowcentraltech.flowcentral.configuration.constants.AbstractFlowCentralStaticSettings;
import com.flowcentraltech.flowcentral.configuration.constants.ModuleInstallLevelConstants;
import com.tcdng.unify.core.annotation.AutoDetect;

/**
 * Security module static settings.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@AutoDetect
public class SecurityModuleStaticSettings extends AbstractFlowCentralStaticSettings {

    public SecurityModuleStaticSettings() {
        super(SecurityModuleNameConstants.SECURITY_MODULE_SERVICE, "config/security-module.xml",
                "com.flowcentraltech.flowcentral.resources.security-messages", ModuleInstallLevelConstants.SECURITY_MODULE_LEVEL);
    }

}
