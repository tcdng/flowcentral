/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.workflow.constants;

import com.flowcentraltech.flowcentral.configuration.constants.AbstractFlowCentralStaticSettings;
import com.flowcentraltech.flowcentral.configuration.constants.ModuleInstallLevelConstants;
import com.tcdng.unify.core.annotation.AutoDetect;

/**
 * Workflow module static settings.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@AutoDetect
public class WorkflowModuleStaticSettings extends AbstractFlowCentralStaticSettings {

    public WorkflowModuleStaticSettings() {
        super(WorkflowModuleNameConstants.WORKFLOW_MODULE_SERVICE, "config/workflow-module.xml",
                "com.flowcentraltech.flowcentral.resources.workflow-messages", ModuleInstallLevelConstants.WORKFLOW_MODULE_LEVEL);
    }

}
