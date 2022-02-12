/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.dashboard.web.lists;

import com.flowcentraltech.flowcentral.common.web.lists.AbstractFlowCentralListCommand;
import com.flowcentraltech.flowcentral.dashboard.business.DashboardModuleService;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.list.ListParam;

/**
 * Convenient abstract base class for dashboard list commands.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractDashboardListCommand<T extends ListParam> extends AbstractFlowCentralListCommand<T> {

    @Configurable
    private DashboardModuleService dashboardModuleService;

    public AbstractDashboardListCommand(Class<T> paramType) {
        super(paramType);
    }

    public void setDashboardModuleService(DashboardModuleService dashboardModuleService) {
        this.dashboardModuleService = dashboardModuleService;
    }

    protected DashboardModuleService getDashboardModuleService() {
        return dashboardModuleService;
    }

}
