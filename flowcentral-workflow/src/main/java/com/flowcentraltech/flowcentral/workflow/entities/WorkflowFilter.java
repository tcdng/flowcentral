/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.workflow.entities;

import com.flowcentraltech.flowcentral.application.entities.AppFilter;
import com.flowcentraltech.flowcentral.common.entities.BaseConfigNamedEntity;
import com.tcdng.unify.core.annotation.Child;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.annotation.UniqueConstraint;

/**
 * Workflow filter entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_WORKFLOWFILTER", uniqueConstraints = { @UniqueConstraint({ "workflowId", "name" }),
        @UniqueConstraint({ "workflowId", "description" }) })
public class WorkflowFilter extends BaseConfigNamedEntity {

    @ForeignKey(Workflow.class)
    private Long workflowId;

    @Child(category = "workflow")
    private AppFilter filter;

    @Override
    public String getListKey() {
        return getName();
    }

    public Long getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(Long workflowId) {
        this.workflowId = workflowId;
    }

    public AppFilter getFilter() {
        return filter;
    }

    public void setFilter(AppFilter filter) {
        this.filter = filter;
    }

}
