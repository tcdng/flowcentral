/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.report.entities;

import com.flowcentraltech.flowcentral.application.entities.BaseApplicationEntityQuery;

/**
 * Query class for reportable definition records.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ReportableDefinitionQuery extends BaseApplicationEntityQuery<ReportableDefinition> {

    public ReportableDefinitionQuery() {
        super(ReportableDefinition.class);
    }

    public ReportableDefinitionQuery entity(String entity) {
        return (ReportableDefinitionQuery) addEquals("entity", entity);
    }
}
