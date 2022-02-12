/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.codegeneration.generators;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipOutputStream;

import com.flowcentraltech.flowcentral.configuration.xml.AppDashboardConfig;
import com.flowcentraltech.flowcentral.configuration.xml.AppDashboardsConfig;
import com.flowcentraltech.flowcentral.configuration.xml.DashboardTileConfig;
import com.flowcentraltech.flowcentral.dashboard.business.DashboardModuleService;
import com.flowcentraltech.flowcentral.dashboard.entities.Dashboard;
import com.flowcentraltech.flowcentral.dashboard.entities.DashboardTile;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.util.DataUtils;

/**
 * Dashboards XML Generator.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("dashboards-xml-generator")
public class DashboardsXmlGenerator extends AbstractStaticArtifactGenerator {

    @Configurable
    private DashboardModuleService dashboardModuleService;

    public void setDashboardModuleService(DashboardModuleService dashboardModuleService) {
        this.dashboardModuleService = dashboardModuleService;
    }

    @Override
    protected void doGenerate(ExtensionModuleStaticFileBuilderContext ctx, String applicationName, ZipOutputStream out)
            throws UnifyException {
        List<Long> dashboardIdList = dashboardModuleService.findDashboardIdList(applicationName);
        if (!DataUtils.isBlank(dashboardIdList)) {
            final String lowerCaseApplicationName = applicationName.toLowerCase();

            AppDashboardsConfig appDashboardsConfig = new AppDashboardsConfig();
            List<AppDashboardConfig> dashboardConfigList = new ArrayList<AppDashboardConfig>();
            for (Long dashboardId : dashboardIdList) {
                AppDashboardConfig appDashboardConfig = new AppDashboardConfig();
                Dashboard dashboard = dashboardModuleService.findDashboard(dashboardId);
                String descKey = getDescriptionKey(lowerCaseApplicationName, "dashboard", dashboard.getName());
                ctx.addMessage(StaticMessageCategoryType.DASHBOARD, descKey, dashboard.getDescription());

                appDashboardConfig.setName(dashboard.getName());
                appDashboardConfig.setDescription("$m{" + descKey + "}");
                appDashboardConfig.setSections(dashboard.getSections());

                // Tiles
                if (!DataUtils.isBlank(dashboard.getTileList())) {
                    List<DashboardTileConfig> tileList = new ArrayList<DashboardTileConfig>();
                    for (DashboardTile dashboardTile : dashboard.getTileList()) {
                        DashboardTileConfig dashboardTileConfig = new DashboardTileConfig();
                        descKey = getDescriptionKey(lowerCaseApplicationName, "dashboardtile", dashboardTile.getName());
                        ctx.addMessage(StaticMessageCategoryType.DASHBOARD, descKey, dashboardTile.getDescription());
                        
                        dashboardTileConfig.setType(dashboardTile.getType());
                        dashboardTileConfig.setChart(dashboardTile.getChart());
                        dashboardTileConfig.setName(dashboardTile.getName());
                        dashboardTileConfig.setDescription("$m{" + descKey + "}");
                        dashboardTileConfig.setSection(dashboardTile.getSection());
                        dashboardTileConfig.setIndex(dashboardTile.getIndex());
                        tileList.add(dashboardTileConfig);
                    }
                    
                    appDashboardConfig.setTileList(tileList);
                }

                dashboardConfigList.add(appDashboardConfig);
            }

            appDashboardsConfig.setDashboardList(dashboardConfigList);
            ctx.setDashboardsConfig(appDashboardsConfig);
        }

    }

}
