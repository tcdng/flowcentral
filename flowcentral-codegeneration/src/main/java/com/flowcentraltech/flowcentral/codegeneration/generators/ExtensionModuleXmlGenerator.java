/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.codegeneration.generators;

import java.util.zip.ZipOutputStream;

import com.flowcentraltech.flowcentral.configuration.xml.ModuleConfig;
import com.flowcentraltech.flowcentral.configuration.xml.util.ConfigurationUtils;
import com.flowcentraltech.flowcentral.system.business.SystemModuleService;
import com.flowcentraltech.flowcentral.system.entities.Module;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;

/**
 * Extension module XML generator.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("extension-module-xml-generator")
public class ExtensionModuleXmlGenerator extends AbstractStaticArtifactGenerator {

    @Configurable
    private SystemModuleService systemModuleService;

    public ExtensionModuleXmlGenerator() {
        super("src/main/resources/config/");
    }

    public final void setSystemModuleService(SystemModuleService systemModuleService) {
        this.systemModuleService = systemModuleService;
    }

    @Override
    protected void doGenerate(ExtensionModuleStaticFileBuilderContext ctx, String moduleName, ZipOutputStream zos)
            throws UnifyException {
        final String lowerCaseModuleName = moduleName.toLowerCase();
        final String filename =  lowerCaseModuleName + "-extension-module.xml";
        openEntry(filename, zos);
        
        final ModuleConfig moduleConfig = new ModuleConfig();
        Module module = systemModuleService.findModule(moduleName);
        String descKey = lowerCaseModuleName + ".extension.description";
        String labelKey = lowerCaseModuleName + ".extension.label";
        ctx.addMessage(StaticMessageCategoryType.HEADER, descKey, module.getDescription());
        ctx.addMessage(StaticMessageCategoryType.HEADER, labelKey, module.getLabel());
        moduleConfig.setName(moduleName);
        moduleConfig.setDescription("$m{" + descKey + "}");
        moduleConfig.setLabel("$m{" + labelKey + "}");
        moduleConfig.setPrincipal(false); // Extension
        moduleConfig.setShortCode(module.getShortCode());
        moduleConfig.setModuleAppsConfig(ctx.getModuleAppsConfig());

        ConfigurationUtils.writeConfig(moduleConfig, zos);
        closeEntry(zos);
    }
}
