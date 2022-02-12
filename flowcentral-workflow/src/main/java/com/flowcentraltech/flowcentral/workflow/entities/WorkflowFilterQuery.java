/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.workflow.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseConfigNamedEntityQuery;

/**
 * Workflow filter query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class WorkflowFilterQuery extends BaseConfigNamedEntityQuery<WorkflowFilter> {

    public WorkflowFilterQuery() {
        super(WorkflowFilter.class);
    }

    public WorkflowFilterQuery workflowId(Long workflowId) {
        return (WorkflowFilterQuery) addEquals("workflowId", workflowId);
    }

}
