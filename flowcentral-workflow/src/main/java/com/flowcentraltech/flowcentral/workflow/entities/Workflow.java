/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.workflow.entities;

import java.util.List;

import com.flowcentraltech.flowcentral.application.entities.BaseApplicationEntity;
import com.tcdng.unify.core.annotation.ChildList;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.Table;

/**
 * Workflow entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_WORKFLOW")
public class Workflow extends BaseApplicationEntity {

    @Column(name = "FLOW_LABEL", length = 64)
    private String label;

    @Column(length = 128)
    private String entity;

    @Column(length = 128, nullable = true)
    private String descFormat;
    
    @ChildList
    private List<WorkflowFilter> filterList;

    @ChildList
    private List<WfStep> stepList;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getDescFormat() {
        return descFormat;
    }

    public void setDescFormat(String descFormat) {
        this.descFormat = descFormat;
    }

    public List<WorkflowFilter> getFilterList() {
        return filterList;
    }

    public void setFilterList(List<WorkflowFilter> filterList) {
        this.filterList = filterList;
    }

    public List<WfStep> getStepList() {
        return stepList;
    }

    public void setStepList(List<WfStep> stepList) {
        this.stepList = stepList;
    }

}
