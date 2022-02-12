/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Application configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@XmlRootElement(name = "application")
public class AppConfig extends BaseNameConfig {

    private String module;

    private int displayIndex;

    private boolean developable;

    private boolean menuAccess;

    private AppReportsConfig reportsConfig;

    private AppNotifTemplatesConfig notifTemplatesConfig;

    private AppWorkflowsConfig workflowsConfig;

    private AppWorkflowWizardsConfig workflowWizardsConfig;
    
    private AppletsConfig appletsConfig;
    
    private WidgetTypesConfig widgetTypesConfig;

    private RefsConfig refsConfig;

    private AppEntitiesConfig entitiesConfig;

    private AppTablesConfig tablesConfig;

    private WfChannelsConfig wfChannelsConfig;
    
    private AppFormsConfig formsConfig;

    private AppAssignmentPagesConfig assignmentPagesConfig;

    private PropertyListsConfig propertyListsConfig;

    private PropertyRulesConfig propertyRulesConfig;

    private AppChartsConfig chartsConfig;

    private AppDashboardsConfig dashboardsConfig;

    private SuggestionTypesConfig suggestionTypesConfig;

    public AppConfig() {
        menuAccess = true;
    }
    
    public String getModule() {
        return module;
    }

    @XmlAttribute(required = true)
    public void setModule(String module) {
        this.module = module;
    }

    public int getDisplayIndex() {
        return displayIndex;
    }

    @XmlAttribute
    public void setDisplayIndex(int displayIndex) {
        this.displayIndex = displayIndex;
    }

    public boolean isDevelopable() {
        return developable;
    }

    @XmlAttribute
    public void setDevelopable(boolean developable) {
        this.developable = developable;
    }

    public boolean isMenuAccess() {
        return menuAccess;
    }

    @XmlAttribute
    public void setMenuAccess(boolean menuAccess) {
        this.menuAccess = menuAccess;
    }

    public AppReportsConfig getReportsConfig() {
        return reportsConfig;
    }

    @XmlElement(name = "reports")
    public void setReportsConfig(AppReportsConfig reportsConfig) {
        this.reportsConfig = reportsConfig;
    }

    public AppNotifTemplatesConfig getNotifTemplatesConfig() {
        return notifTemplatesConfig;
    }

    @XmlElement(name = "notifTemplates")
    public void setNotifTemplatesConfig(AppNotifTemplatesConfig notifTemplatesConfig) {
        this.notifTemplatesConfig = notifTemplatesConfig;
    }

    public AppWorkflowsConfig getWorkflowsConfig() {
        return workflowsConfig;
    }

    @XmlElement(name = "workflows")
    public void setWorkflowsConfig(AppWorkflowsConfig workflowsConfig) {
        this.workflowsConfig = workflowsConfig;
    }

    public AppWorkflowWizardsConfig getWorkflowWizardsConfig() {
        return workflowWizardsConfig;
    }

    @XmlElement(name = "workflow-wizards")
    public void setWorkflowWizardsConfig(AppWorkflowWizardsConfig workflowWizardsConfig) {
        this.workflowWizardsConfig = workflowWizardsConfig;
    }

    public AppletsConfig getAppletsConfig() {
        return appletsConfig;
    }

    @XmlElement(name = "applets")
    public void setAppletsConfig(AppletsConfig appletsConfig) {
        this.appletsConfig = appletsConfig;
    }

    public WidgetTypesConfig getWidgetTypesConfig() {
        return widgetTypesConfig;
    }

    @XmlElement(name = "widgetTypes")
    public void setWidgetTypesConfig(WidgetTypesConfig widgetTypesConfig) {
        this.widgetTypesConfig = widgetTypesConfig;
    }

    public RefsConfig getRefsConfig() {
        return refsConfig;
    }

    @XmlElement(name = "references")
    public void setRefsConfig(RefsConfig refsConfig) {
        this.refsConfig = refsConfig;
    }

    public AppEntitiesConfig getEntitiesConfig() {
        return entitiesConfig;
    }

    @XmlElement(name = "entities")
    public void setEntitiesConfig(AppEntitiesConfig entitiesConfig) {
        this.entitiesConfig = entitiesConfig;
    }

    public AppTablesConfig getTablesConfig() {
        return tablesConfig;
    }

    @XmlElement(name = "tables")
    public void setTablesConfig(AppTablesConfig tablesConfig) {
        this.tablesConfig = tablesConfig;
    }

    public AppFormsConfig getFormsConfig() {
        return formsConfig;
    }

    @XmlElement(name = "forms")
    public void setFormsConfig(AppFormsConfig formsConfig) {
        this.formsConfig = formsConfig;
    }

    public WfChannelsConfig getWfChannelsConfig() {
        return wfChannelsConfig;
    }

    @XmlElement(name = "workflow-channels")
    public void setWfChannelsConfig(WfChannelsConfig wfChannelsConfig) {
        this.wfChannelsConfig = wfChannelsConfig;
    }

    public AppAssignmentPagesConfig getAssignmentPagesConfig() {
        return assignmentPagesConfig;
    }

    @XmlElement(name = "assignmentPages")
    public void setAssignmentPagesConfig(AppAssignmentPagesConfig assignmentPagesConfig) {
        this.assignmentPagesConfig = assignmentPagesConfig;
    }

    public PropertyListsConfig getPropertyListsConfig() {
        return propertyListsConfig;
    }

    @XmlElement(name = "propertyLists")
    public void setPropertyListsConfig(PropertyListsConfig propertyListsConfig) {
        this.propertyListsConfig = propertyListsConfig;
    }

    public PropertyRulesConfig getPropertyRulesConfig() {
        return propertyRulesConfig;
    }

    @XmlElement(name = "propertyRules")
    public void setPropertyRulesConfig(PropertyRulesConfig propertyRulesConfig) {
        this.propertyRulesConfig = propertyRulesConfig;
    }

    public AppChartsConfig getChartsConfig() {
        return chartsConfig;
    }

    @XmlElement(name = "charts")
    public void setChartsConfig(AppChartsConfig chartsConfig) {
        this.chartsConfig = chartsConfig;
    }

    public AppDashboardsConfig getDashboardsConfig() {
        return dashboardsConfig;
    }

    @XmlElement(name = "dashboards")
    public void setDashboardsConfig(AppDashboardsConfig dashboardsConfig) {
        this.dashboardsConfig = dashboardsConfig;
    }

    public SuggestionTypesConfig getSuggestionTypesConfig() {
        return suggestionTypesConfig;
    }

    @XmlElement(name = "suggestionTypes")
    public void setSuggestionTypesConfig(SuggestionTypesConfig suggestionTypesConfig) {
        this.suggestionTypesConfig = suggestionTypesConfig;
    }
}
