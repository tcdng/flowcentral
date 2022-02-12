/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseAuditEntityQuery;

/**
 * Application set values query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppSetValuesQuery extends BaseAuditEntityQuery<AppSetValues> {

    public AppSetValuesQuery() {
        super(AppSetValues.class);
    }

    public AppSetValuesQuery entityInstId(Long entityInstId) {
        return (AppSetValuesQuery) addEquals("entityInstId", entityInstId);
    }

    public AppSetValuesQuery entity(String entity) {
        return (AppSetValuesQuery) addEquals("entity", entity);
    }

    public AppSetValuesQuery category(String category) {
        return (AppSetValuesQuery) addEquals("category", category);
    }

}
