/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.report.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseEntityQuery;

/**
 * Report column query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ReportColumnQuery extends BaseEntityQuery<ReportColumn> {

    public ReportColumnQuery() {
        super(ReportColumn.class);
    }

    public ReportColumnQuery reportConfigurationId(Long reportConfigurationId) {
        return (ReportColumnQuery) addEquals("reportConfigurationId", reportConfigurationId);
    }
}
