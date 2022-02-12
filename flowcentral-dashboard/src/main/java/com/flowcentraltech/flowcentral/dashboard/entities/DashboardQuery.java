/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.dashboard.entities;

import com.flowcentraltech.flowcentral.application.entities.BaseApplicationEntityQuery;

/**
 * Dashboard query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class DashboardQuery extends BaseApplicationEntityQuery<Dashboard> {

    public DashboardQuery() {
        super(Dashboard.class);
    }

}
