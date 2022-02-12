/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.workflow.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseConfigNamedEntityQuery;
import com.flowcentraltech.flowcentral.configuration.constants.WorkflowStepType;
import com.tcdng.unify.core.criterion.And;
import com.tcdng.unify.core.criterion.NotEquals;

/**
 * Workflow step query.
 * 
 * @author Lateef Ojulari
 * @version 1.0
 */
public class WfStepQuery extends BaseConfigNamedEntityQuery<WfStep> {

    public WfStepQuery() {
        super(WfStep.class);
    }

    public WfStepQuery workflowId(Long workflowId) {
        return (WfStepQuery) addEquals("workflowId", workflowId);
    }

    public WfStepQuery routableTo() {
        return (WfStepQuery) addRestriction(new And().add(new NotEquals("type", WorkflowStepType.START))
                .add(new NotEquals("type", WorkflowStepType.ERROR)));
    }

    public WfStepQuery receivableFrom() {
        return (WfStepQuery) addRestriction(new And().add(new NotEquals("type", WorkflowStepType.END))
                .add(new NotEquals("type", WorkflowStepType.ERROR)));
    }
}
