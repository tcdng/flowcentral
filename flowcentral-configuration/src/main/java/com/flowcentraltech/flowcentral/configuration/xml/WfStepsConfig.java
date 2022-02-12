/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.configuration.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * Workflow steps configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class WfStepsConfig {

    private List<WfStepConfig> stepList;

    public List<WfStepConfig> getStepList() {
        return stepList;
    }

    @XmlElement(name = "step", required = true)
    public void setStepList(List<WfStepConfig> stepList) {
        this.stepList = stepList;
    }
}
