/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.chart.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseEntityQuery;

/**
 * Chart snapshot series query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ChartSnapshotSeriesQuery extends BaseEntityQuery<ChartSnapshotSeries> {

    public ChartSnapshotSeriesQuery() {
        super(ChartSnapshotSeries.class);
    }

    public ChartSnapshotSeriesQuery chartSnapshotId(Long chartSnapshotId) {
        return (ChartSnapshotSeriesQuery) addEquals("chartSnapshotId", chartSnapshotId);
    }
}
