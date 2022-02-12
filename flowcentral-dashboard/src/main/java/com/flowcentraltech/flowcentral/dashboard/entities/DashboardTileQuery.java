/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.dashboard.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseConfigNamedEntityQuery;

/**
 * Dashboard tile query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class DashboardTileQuery extends BaseConfigNamedEntityQuery<DashboardTile> {

    public DashboardTileQuery() {
        super(DashboardTile.class);
    }

    public DashboardTileQuery dashboardId(Long dashboardId) {
        return (DashboardTileQuery) addEquals("dashboardId", dashboardId);
    }

}
