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
 * Application workflow wizard entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_WORKWIZARD")
public class WfWizard extends BaseApplicationEntity {

    @Column(name = "WIZARD_LABEL", length = 64)
    private String label;

    @Column(name = "WIZARD_ENTITY", length = 128)
    private String entity;

    @Column(length = 128, nullable = true)
    private String submitWorkflow;

    @ChildList
    private List<WfWizardStep> stepList;

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

    public String getSubmitWorkflow() {
        return submitWorkflow;
    }

    public void setSubmitWorkflow(String submitWorkflow) {
        this.submitWorkflow = submitWorkflow;
    }

    public List<WfWizardStep> getStepList() {
        return stepList;
    }

    public void setStepList(List<WfWizardStep> stepList) {
        this.stepList = stepList;
    }

}
