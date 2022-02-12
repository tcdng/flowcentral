/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.dashboard.web.controllers;

import com.flowcentraltech.flowcentral.dashboard.web.widgets.DashboardSlate;
import com.tcdng.unify.web.ui.AbstractPageBean;

/**
 * Application dashboard page bean.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ApplicationDashboardPageBean extends AbstractPageBean {

    private DashboardSlate dashboardSlate;

    private String selDashboard;

    public DashboardSlate getDashboardSlate() {
        return dashboardSlate;
    }

    public void setDashboardSlate(DashboardSlate dashboardSlate) {
        this.dashboardSlate = dashboardSlate;
    }

    public String getSelDashboard() {
        return selDashboard;
    }

    public void setSelDashboard(String selDashboard) {
        this.selDashboard = selDashboard;
    }
}
