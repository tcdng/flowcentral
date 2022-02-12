/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.workflow.constants;

/**
 * Workflow module error constants.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface WorkflowModuleErrorConstants {

    /** Can not find workflow {0}. */
    String CANNOT_FIND_APPLICATION_WORKFLOW = "WORKFLOW_0001";

    /**
     * Can not submit incompatible instance type {0} to workflow {1} in application
     * {2}.
     */
    String CANNOT_SUBMIT_INST_TO_INCOMPATIBLE_WORKFLOW = "WORKFLOW_0002";

    /**
     * Item with ID {0} for type {1} already in workflow {2} in application {3}.
     */
    String INST_ALREADY_IN_WORKFLOW = "WORKFLOW_0003";

    /**
     * Attempt to submit workflow item to a closed workflow channel {0}.
     */
    String WORKFLOW_CHANNEL_IS_CLOSED = "WORKFLOW_0004";

}
