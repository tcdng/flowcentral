/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.report.entities;

import java.util.Collection;

import com.flowcentraltech.flowcentral.common.entities.BaseEntityQuery;

/**
 * Query class for reportable fields.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ReportableFieldQuery extends BaseEntityQuery<ReportableField> {

    public ReportableFieldQuery() {
        super(ReportableField.class);
    }

    public ReportableFieldQuery reportableId(Long reportableId) {
        return (ReportableFieldQuery) addEquals("reportableId", reportableId);
    }

    public ReportableFieldQuery parameterOnly(boolean parameterOnly) {
        return (ReportableFieldQuery) addEquals("parameterOnly", parameterOnly);
    }

    public ReportableFieldQuery name(String name) {
        return (ReportableFieldQuery) addEquals("name", name);
    }

    public ReportableFieldQuery nameIn(Collection<String> names) {
        return (ReportableFieldQuery) addAmongst("name", names);
    }

    public ReportableFieldQuery nameNotIn(Collection<String> names) {
        return (ReportableFieldQuery) addNotAmongst("name", names);
    }
}
