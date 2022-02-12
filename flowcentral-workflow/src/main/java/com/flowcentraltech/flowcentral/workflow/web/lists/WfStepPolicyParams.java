/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.workflow.web.lists;

import com.flowcentraltech.flowcentral.configuration.constants.WorkflowStepType;
import com.tcdng.unify.core.list.AbstractListParam;

/**
 * Workflow step policy parameters.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class WfStepPolicyParams extends AbstractListParam {

    private WorkflowStepType type;

    public WfStepPolicyParams(WorkflowStepType type) {
        this.type = type;
    }

    public WorkflowStepType getType() {
        return type;
    }

    @Override
    public boolean isPresent() {
        return type != null;
    }

}
