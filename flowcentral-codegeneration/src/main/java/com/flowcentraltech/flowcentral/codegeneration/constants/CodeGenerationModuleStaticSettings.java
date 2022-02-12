/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.codegeneration.constants;

import com.flowcentraltech.flowcentral.configuration.constants.AbstractFlowCentralStaticSettings;
import com.flowcentraltech.flowcentral.configuration.constants.ModuleInstallLevelConstants;
import com.tcdng.unify.core.annotation.AutoDetect;

/**
 * Code generation module static settings.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@AutoDetect
public class CodeGenerationModuleStaticSettings extends AbstractFlowCentralStaticSettings {

    public CodeGenerationModuleStaticSettings() {
        super(CodeGenerationModuleNameConstants.CODEGENERATION_MODULE_SERVICE, "config/codegeneration-module.xml",
                "com.flowcentraltech.flowcentral.resources.codegeneration-messages",
                ModuleInstallLevelConstants.MINIMAL_PRIORITY_LEVEL);
    }

}
