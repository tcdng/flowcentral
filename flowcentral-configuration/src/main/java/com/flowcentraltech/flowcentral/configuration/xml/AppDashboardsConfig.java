/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * Dashboards configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppDashboardsConfig {

    private List<AppDashboardConfig> dashboardList;

    public List<AppDashboardConfig> getDashboardList() {
        return dashboardList;
    }

    @XmlElement(name = "dashboard")
    public void setDashboardList(List<AppDashboardConfig> dashboardList) {
        this.dashboardList = dashboardList;
    }

}
