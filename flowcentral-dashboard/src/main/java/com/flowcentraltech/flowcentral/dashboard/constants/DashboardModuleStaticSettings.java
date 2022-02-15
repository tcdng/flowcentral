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
package com.flowcentraltech.flowcentral.dashboard.constants;

import com.flowcentraltech.flowcentral.configuration.constants.AbstractFlowCentralStaticSettings;
import com.flowcentraltech.flowcentral.configuration.constants.ModuleInstallLevelConstants;
import com.tcdng.unify.core.annotation.AutoDetect;

/**
 * Dashboard module static settings.
 * 
 * @author FlowCentral Technologies Limited
 * @since 1.0
 */
@AutoDetect
public class DashboardModuleStaticSettings extends AbstractFlowCentralStaticSettings {

    public DashboardModuleStaticSettings() {
        super(DashboardModuleNameConstants.DASHBOARD_MODULE_SERVICE, "config/dashboard-module.xml",
                "com.flowcentraltech.flowcentral.resources.dashboard-messages",
                ModuleInstallLevelConstants.DASHBOARD_MODULE_LEVEL);
    }

}
