/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.report.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseEntityQuery;

/**
 * Report parameter query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ReportParameterQuery extends BaseEntityQuery<ReportParameter> {

    public ReportParameterQuery() {
        super(ReportParameter.class);
    }

    public ReportParameterQuery reportConfigurationId(Long reportConfigurationId) {
        return (ReportParameterQuery) addEquals("reportConfigurationId", reportConfigurationId);
    }
}
