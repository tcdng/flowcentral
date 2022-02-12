/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.workflow.entities;

import com.flowcentraltech.flowcentral.application.entities.BaseApplicationEntityQuery;

/**
 * Workflow query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class WorkflowQuery extends BaseApplicationEntityQuery<Workflow> {

    public WorkflowQuery() {
        super(Workflow.class);
    }

    public WorkflowQuery entity(String entity) {
        return (WorkflowQuery) addEquals("entity", entity);
    }

}
