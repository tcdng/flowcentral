/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.configuration.constants;

/**
 * Convenient abstract base class for extension module static settings
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractExtensionModuleStaticSettings extends AbstractFlowCentralStaticSettings {

    public AbstractExtensionModuleStaticSettings(String messageBase) {
        super(messageBase, ModuleInstallLevelConstants.EXTENSION_MODULE_LEVEL);
    }

    public AbstractExtensionModuleStaticSettings(String installerName, String moduleConfigName, String messageBase) {
        super(installerName, moduleConfigName, messageBase, ModuleInstallLevelConstants.EXTENSION_MODULE_LEVEL);
    }

}
