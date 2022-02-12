/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.organization.constants;

import com.flowcentraltech.flowcentral.configuration.constants.AbstractFlowCentralStaticSettings;
import com.flowcentraltech.flowcentral.configuration.constants.ModuleInstallLevelConstants;
import com.tcdng.unify.core.annotation.AutoDetect;

/**
 * Organization module static settings.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@AutoDetect
public class OrganizationModuleStaticSettings extends AbstractFlowCentralStaticSettings {

    public OrganizationModuleStaticSettings() {
        super(OrganizationModuleNameConstants.ORGANIZATION_MODULE_SERVICE, "config/organization-module.xml",
                "com.flowcentraltech.flowcentral.resources.organization-messages",
                ModuleInstallLevelConstants.ORGANIZATION_MODULE_LEVEL);
    }

}
