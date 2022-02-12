/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.data;

import com.flowcentraltech.flowcentral.configuration.xml.WfWizardConfig;

/**
 * Workflow wizard installation configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class WorkflowWizardInstall {

    private WfWizardConfig wfWizardConfig;

    public WorkflowWizardInstall(WfWizardConfig wfWizardConfig) {
        this.wfWizardConfig = wfWizardConfig;
    }

    public WfWizardConfig getWfWizardConfig() {
        return wfWizardConfig;
    }

}
