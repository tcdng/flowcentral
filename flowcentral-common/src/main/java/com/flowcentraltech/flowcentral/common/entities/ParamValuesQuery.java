/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.common.entities;

/**
 * Common parameter values query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ParamValuesQuery extends BaseAuditEntityQuery<ParamValues> {

    public ParamValuesQuery() {
        super(ParamValues.class);
    }

    public ParamValuesQuery entityInstId(Long entityInstId) {
        return (ParamValuesQuery) addEquals("entityInstId", entityInstId);
    }

    public ParamValuesQuery entity(String entity) {
        return (ParamValuesQuery) addEquals("entity", entity);
    }

    public ParamValuesQuery category(String category) {
        return (ParamValuesQuery) addEquals("category", category);
    }

}
