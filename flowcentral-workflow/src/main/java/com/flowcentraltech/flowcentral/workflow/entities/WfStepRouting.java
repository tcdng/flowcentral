/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.workflow.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseNamedEntity;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.ListOnly;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.annotation.UniqueConstraint;

/**
 * Workflow step routing entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_WORKSTEPROUTING", uniqueConstraints = { @UniqueConstraint({ "wfStepId", "name" }),
        @UniqueConstraint({ "wfStepId", "description" }) })
public class WfStepRouting extends BaseNamedEntity {

    @ForeignKey(WfStep.class)
    private Long wfStepId;

    @Column(name = "NEXT_STEP_NM", length = 64)
    private String nextStepName;

    @Column(name = "CONDITION_NM", length = 64)
    private String conditionName;

    @ListOnly(key = "wfStepId", property = "description")
    private String wfStepDesc;

    public Long getWfStepId() {
        return wfStepId;
    }

    public void setWfStepId(Long wfStepId) {
        this.wfStepId = wfStepId;
    }

    public String getNextStepName() {
        return nextStepName;
    }

    public void setNextStepName(String nextStepName) {
        this.nextStepName = nextStepName;
    }

    public String getConditionName() {
        return conditionName;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    public String getWfStepDesc() {
        return wfStepDesc;
    }

    public void setWfStepDesc(String wfStepDesc) {
        this.wfStepDesc = wfStepDesc;
    }

}
