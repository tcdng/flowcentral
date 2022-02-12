/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.codegeneration.generators;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.flowcentraltech.flowcentral.application.entities.AppEntity;
import com.flowcentraltech.flowcentral.application.util.ApplicationCodeGenUtils;
import com.flowcentraltech.flowcentral.configuration.xml.AppChartsConfig;
import com.flowcentraltech.flowcentral.configuration.xml.AppDashboardsConfig;
import com.flowcentraltech.flowcentral.configuration.xml.AppNotifTemplatesConfig;
import com.flowcentraltech.flowcentral.configuration.xml.AppReportsConfig;
import com.flowcentraltech.flowcentral.configuration.xml.AppWorkflowWizardsConfig;
import com.flowcentraltech.flowcentral.configuration.xml.AppWorkflowsConfig;
import com.flowcentraltech.flowcentral.configuration.xml.ModuleAppConfig;
import com.flowcentraltech.flowcentral.configuration.xml.ModuleAppsConfig;
import com.flowcentraltech.flowcentral.configuration.xml.WfChannelsConfig;

/**
 * Extension module static file builder context.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ExtensionModuleStaticFileBuilderContext {

    private List<StaticApplicationConfig> staticApplicationConfigs;

    private StaticApplicationConfig nextStaticApplicationConfig;

    private ModuleAppsConfig moduleAppsConfig;

    private List<String> entityList;

    private Set<String> zipDirs;

    private Map<String, String> messageReplacements;

    private String basePackage;

    private String moduleName;

    public ExtensionModuleStaticFileBuilderContext(String basePackage, String moduleName,
            Map<String, String> messageReplacements) {
        this.staticApplicationConfigs = new ArrayList<StaticApplicationConfig>();
        this.moduleAppsConfig = new ModuleAppsConfig();
        this.moduleAppsConfig.setModuleAppList(new ArrayList<ModuleAppConfig>());
        this.entityList = new ArrayList<String>();
        this.zipDirs = new HashSet<String>();
        this.basePackage = basePackage;
        this.moduleName = moduleName;
        this.messageReplacements = messageReplacements;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public String getModuleName() {
        return moduleName;
    }

    public List<StaticApplicationConfig> getStaticApplicationConfigs() {
        return staticApplicationConfigs;
    }

    public boolean addZipDir(String zipDir) {
        return zipDirs.add(zipDir);
    }

    public void addEntity(String entityName) {
        entityList.add(entityName);
    }

    public List<String> getEntityList() {
        return entityList;
    }

    public void nextApplication(String applicationName, String applicationDesc) {
        nextStaticApplicationConfig = new StaticApplicationConfig(applicationName, applicationDesc);
        staticApplicationConfigs.add(nextStaticApplicationConfig);
    }

    public void addModuleAppConfig(ModuleAppConfig moduleAppConfig) {
        moduleAppsConfig.getModuleAppList().add(moduleAppConfig);
    }

    public ModuleAppsConfig getModuleAppsConfig() {
        return moduleAppsConfig;
    }

    public void setReportsConfig(AppReportsConfig reportsConfig) {
        nextStaticApplicationConfig.setReportsConfig(reportsConfig);
    }

    public void setNotifTemplatesConfig(AppNotifTemplatesConfig notifTemplatesConfig) {
        nextStaticApplicationConfig.setNotifTemplatesConfig(notifTemplatesConfig);
    }

    public void setWorkflowsConfig(AppWorkflowsConfig workflowsConfig) {
        nextStaticApplicationConfig.setWorkflowsConfig(workflowsConfig);
    }

    public void setWorkflowWizardsConfig(AppWorkflowWizardsConfig workflowWizardsConfig) {
        nextStaticApplicationConfig.setWorkflowWizardsConfig(workflowWizardsConfig);
    }

    public void setWfChannelsConfig(WfChannelsConfig wfChannelsConfig) {
        nextStaticApplicationConfig.setWfChannelsConfig(wfChannelsConfig);
    }

    public void setChartsConfig(AppChartsConfig chartsConfig) {
        nextStaticApplicationConfig.setChartsConfig(chartsConfig);
    }

    public void setDashboardsConfig(AppDashboardsConfig dashboardsConfig) {
        nextStaticApplicationConfig.setDashboardsConfig(dashboardsConfig);
    }

    public void addMessageGap(StaticMessageCategoryType category) {
        nextStaticApplicationConfig.addMessageGap(category);
    }

    public AppChartsConfig getChartsConfig() {
        return nextStaticApplicationConfig.getChartsConfig();
    }

    public AppDashboardsConfig getDashboardsConfig() {
        return nextStaticApplicationConfig.getDashboardsConfig();
    }

    public AppReportsConfig getReportsConfig() {
        return nextStaticApplicationConfig.getReportsConfig();
    }

    public AppNotifTemplatesConfig getNotifTemplatesConfig() {
        return nextStaticApplicationConfig.getNotifTemplatesConfig();
    }

    public AppWorkflowsConfig getWorkflowsConfig() {
        return nextStaticApplicationConfig.getWorkflowsConfig();
    }

    public AppWorkflowWizardsConfig getWorkflowWizardsConfig() {
        return nextStaticApplicationConfig.getWorkflowWizardsConfig();
    }

    public WfChannelsConfig getWfChannelsConfig() {
        return nextStaticApplicationConfig.getWfChannelsConfig();
    }

    public void addMessage(StaticMessageCategoryType category, String key, String val) {
        for (Map.Entry<String, String> entry : messageReplacements.entrySet()) {
            val = val.replaceAll(entry.getKey(), entry.getValue());
        }

        nextStaticApplicationConfig.addMessage(category, key, val);
    }

    public String getExtensionEntityClassName(AppEntity appEntity) {
        return ApplicationCodeGenUtils.generateExtensionEntityClassName(basePackage, moduleName, appEntity.getName());
    }
}
