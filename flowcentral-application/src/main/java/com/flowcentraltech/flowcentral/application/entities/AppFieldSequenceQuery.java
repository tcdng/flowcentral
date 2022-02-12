/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseAuditEntityQuery;

/**
 * Application field sequence query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppFieldSequenceQuery extends BaseAuditEntityQuery<AppFieldSequence> {

    public AppFieldSequenceQuery() {
        super(AppFieldSequence.class);
    }

    public AppFieldSequenceQuery entityInstId(Long entityInstId) {
        return (AppFieldSequenceQuery) addEquals("entityInstId", entityInstId);
    }

    public AppFieldSequenceQuery entity(String entity) {
        return (AppFieldSequenceQuery) addEquals("entity", entity);
    }

    public AppFieldSequenceQuery category(String category) {
        return (AppFieldSequenceQuery) addEquals("category", category);
    }

}
