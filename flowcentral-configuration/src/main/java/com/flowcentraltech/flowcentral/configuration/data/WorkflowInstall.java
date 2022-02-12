/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.data;

import com.flowcentraltech.flowcentral.configuration.xml.WfConfig;

/**
 * Workflow installation configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class WorkflowInstall {

    private WfConfig wfConfig;

    public WorkflowInstall(WfConfig wfConfig) {
        this.wfConfig = wfConfig;
    }

    public WfConfig getWfConfig() {
        return wfConfig;
    }

}
