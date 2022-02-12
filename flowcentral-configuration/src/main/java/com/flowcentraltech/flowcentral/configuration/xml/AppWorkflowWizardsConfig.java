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
 * Application workflow wizards configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppWorkflowWizardsConfig {

    private List<AppWorkflowWizardConfig> workflowWizardList;

    public List<AppWorkflowWizardConfig> getWorkflowWizardList() {
        return workflowWizardList;
    }

    @XmlElement(name = "workflow-wizard", required = true)
    public void setWorkflowWizardList(List<AppWorkflowWizardConfig> workflowWizardList) {
        this.workflowWizardList = workflowWizardList;
    }

}
