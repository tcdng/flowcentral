/*
 * Copyright 2021-2022 FlowCentral Technologies Limited.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.flowcentraltech.flowcentral.dashboard.web.lists;

import com.flowcentraltech.flowcentral.common.web.lists.AbstractFlowCentralListCommand;
import com.flowcentraltech.flowcentral.dashboard.business.DashboardModuleService;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.list.ListParam;

/**
 * Convenient abstract base class for dashboard list commands.
 * 
 * @author FlowCentral Technologies Limited
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
