/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.chart.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseAuditEntityQuery;

/**
 * Chart snapshot query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ChartSnapshotQuery extends BaseAuditEntityQuery<ChartSnapshot> {

    public ChartSnapshotQuery() {
        super(ChartSnapshot.class);
    }

    public ChartSnapshotQuery name(String name) {
        return (ChartSnapshotQuery) addEquals("name", name);
    }
}
