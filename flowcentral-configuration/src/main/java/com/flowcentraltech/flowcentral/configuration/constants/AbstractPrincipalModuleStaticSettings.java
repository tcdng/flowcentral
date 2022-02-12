/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.configuration.constants;

/**
 * Convenient abstract base class for principal module static settings
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractPrincipalModuleStaticSettings extends AbstractFlowCentralStaticSettings {

    public AbstractPrincipalModuleStaticSettings(String messageBase) {
        super(messageBase, ModuleInstallLevelConstants.PRINCIPAL_MODULE_LEVEL);
    }

    public AbstractPrincipalModuleStaticSettings(String installerName, String moduleConfigName, String messageBase) {
        super(installerName, moduleConfigName, messageBase, ModuleInstallLevelConstants.PRINCIPAL_MODULE_LEVEL);
    }

}
