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
 * Application workflow configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppWorkflowsConfig {

    private List<AppWorkflowConfig> workflowList;

    public List<AppWorkflowConfig> getWorkflowList() {
        return workflowList;
    }

    @XmlElement(name = "workflow", required = true)
    public void setWorkflowList(List<AppWorkflowConfig> workflowList) {
        this.workflowList = workflowList;
    }

}
