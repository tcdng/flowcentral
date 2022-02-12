/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.workflow.entities;

import com.flowcentraltech.flowcentral.application.entities.AppSetValues;
import com.flowcentraltech.flowcentral.common.entities.BaseAuditEntity;
import com.tcdng.unify.core.annotation.Child;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.ListOnly;
import com.tcdng.unify.core.annotation.Table;

/**
 * Workflow step set values entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_WORKSTEPSETVALUES")
public class WfStepSetValues extends BaseAuditEntity {

    @ForeignKey(WfStep.class)
    private Long wfStepId;

    @ListOnly(key = "wfStepId", property = "description")
    private String wfStepDesc;

    @Child(category = "wfstep")
    private AppSetValues setValues;

    @Override
    public String getDescription() {
        return null;
    }

    public Long getWfStepId() {
        return wfStepId;
    }

    public void setWfStepId(Long wfStepId) {
        this.wfStepId = wfStepId;
    }

    public AppSetValues getSetValues() {
        return setValues;
    }

    public void setSetValues(AppSetValues setValues) {
        this.setValues = setValues;
    }

    public String getWfStepDesc() {
        return wfStepDesc;
    }

    public void setWfStepDesc(String wfStepDesc) {
        this.wfStepDesc = wfStepDesc;
    }

}
