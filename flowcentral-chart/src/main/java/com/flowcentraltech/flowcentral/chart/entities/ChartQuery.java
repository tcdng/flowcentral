/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.chart.entities;

import com.flowcentraltech.flowcentral.application.entities.BaseApplicationEntityQuery;

/**
 * Chart query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ChartQuery extends BaseApplicationEntityQuery<Chart> {

    public ChartQuery() {
        super(Chart.class);
    }

}
