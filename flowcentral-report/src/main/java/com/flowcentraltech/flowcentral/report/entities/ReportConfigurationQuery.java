/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.report.entities;

import com.flowcentraltech.flowcentral.application.entities.BaseApplicationEntityQuery;

/**
 * Report configuration query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ReportConfigurationQuery extends BaseApplicationEntityQuery<ReportConfiguration> {

    public ReportConfigurationQuery() {
        super(ReportConfiguration.class);
    }
}
