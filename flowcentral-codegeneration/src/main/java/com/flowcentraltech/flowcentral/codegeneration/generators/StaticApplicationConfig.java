/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.codegeneration.generators;

import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.flowcentraltech.flowcentral.configuration.xml.AppChartsConfig;
import com.flowcentraltech.flowcentral.configuration.xml.AppDashboardsConfig;
import com.flowcentraltech.flowcentral.configuration.xml.AppNotifTemplatesConfig;
import com.flowcentraltech.flowcentral.configuration.xml.AppReportsConfig;
import com.flowcentraltech.flowcentral.configuration.xml.AppWorkflowWizardsConfig;
import com.flowcentraltech.flowcentral.configuration.xml.AppWorkflowsConfig;
import com.flowcentraltech.flowcentral.configuration.xml.WfChannelsConfig;

/**
 * Static application configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class StaticApplicationConfig {

    private String applicationName;
    
    private String applicationDesc;

    private AppChartsConfig chartsConfig;

    private AppDashboardsConfig dashboardsConfig;

    private AppReportsConfig reportsConfig;

    private AppNotifTemplatesConfig notifTemplatesConfig;

    private AppWorkflowsConfig workflowsConfig;

    private AppWorkflowWizardsConfig workflowWizardsConfig;

    private WfChannelsConfig wfChannelsConfig;
    
    private EnumMap<StaticMessageCategoryType, Map<String, String>> messages;
    
    private long gapCounter;

    public StaticApplicationConfig(String applicationName, String applicationDesc) {
        this.applicationName = applicationName;
        this.applicationDesc = applicationDesc;
        this.messages = new EnumMap<StaticMessageCategoryType, Map<String, String>>(StaticMessageCategoryType.class);
    }

    public String getApplicationName() {
        return applicationName;
    }

    public String getApplicationDesc() {
        return applicationDesc;
    }

    public AppChartsConfig getChartsConfig() {
        return chartsConfig;
    }

    public void setChartsConfig(AppChartsConfig chartsConfig) {
        this.chartsConfig = chartsConfig;
    }

    public AppDashboardsConfig getDashboardsConfig() {
        return dashboardsConfig;
    }

    public void setDashboardsConfig(AppDashboardsConfig dashboardsConfig) {
        this.dashboardsConfig = dashboardsConfig;
    }

    public AppReportsConfig getReportsConfig() {
        return reportsConfig;
    }

    public void setReportsConfig(AppReportsConfig reportsConfig) {
        this.reportsConfig = reportsConfig;
    }

    public AppNotifTemplatesConfig getNotifTemplatesConfig() {
        return notifTemplatesConfig;
    }

    public void setNotifTemplatesConfig(AppNotifTemplatesConfig notifTemplatesConfig) {
        this.notifTemplatesConfig = notifTemplatesConfig;
    }

    public AppWorkflowsConfig getWorkflowsConfig() {
        return workflowsConfig;
    }

    public void setWorkflowsConfig(AppWorkflowsConfig workflowsConfig) {
        this.workflowsConfig = workflowsConfig;
    }

    public AppWorkflowWizardsConfig getWorkflowWizardsConfig() {
        return workflowWizardsConfig;
    }

    public void setWorkflowWizardsConfig(AppWorkflowWizardsConfig workflowWizardsConfig) {
        this.workflowWizardsConfig = workflowWizardsConfig;
    }

    public WfChannelsConfig getWfChannelsConfig() {
        return wfChannelsConfig;
    }

    public void setWfChannelsConfig(WfChannelsConfig wfChannelsConfig) {
        this.wfChannelsConfig = wfChannelsConfig;
    }

    public void addMessageGap(StaticMessageCategoryType category) {
        getMessages(category).put("_ctxGap" + (++gapCounter), null);
    }

    public void addMessage(StaticMessageCategoryType category, String key, String value) {
        getMessages(category).put(key, value);
    }

    public Map<String, String> getMessages(StaticMessageCategoryType category) {
        Map<String, String> msgs = messages.get(category);
        if (msgs == null) {
            synchronized (this) {
                msgs = messages.get(category);
                if (msgs == null) {
                    msgs = new LinkedHashMap<String, String>();
                    messages.put(category, msgs);
                }
            }
        }

        return msgs;
    }
}
