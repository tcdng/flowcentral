/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.configuration.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Workflow wizard configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@XmlRootElement(name = "workflow-wizard")
public class WfWizardConfig extends BaseNameConfig {

    private String entity;

    private String submitWorkflow;

    private List<WfWizardStepConfig> stepList;

    public String getEntity() {
        return entity;
    }

    @XmlAttribute(required = true)
    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getSubmitWorkflow() {
        return submitWorkflow;
    }

    @XmlAttribute
    public void setSubmitWorkflow(String submitWorkflow) {
        this.submitWorkflow = submitWorkflow;
    }

    public List<WfWizardStepConfig> getStepList() {
        return stepList;
    }

    @XmlElement(name = "workflow-wizard-step")
    public void setStepList(List<WfWizardStepConfig> stepList) {
        this.stepList = stepList;
    }
}
