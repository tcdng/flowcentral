/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.dashboard.web.widgets;

import com.flowcentraltech.flowcentral.dashboard.data.DashboardDef;

/**
 * Dashboard slate.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class DashboardSlate {

    private DashboardDef dashboardDef;

    public DashboardSlate(DashboardDef dashboardDef) {
        this.dashboardDef = dashboardDef;
    }

    public DashboardDef getDashboardDef() {
        return dashboardDef;
    }

    @Override
    public String toString() {
        return "DashboardSlate [dashboardDef=" + dashboardDef + "]";
    }
}
