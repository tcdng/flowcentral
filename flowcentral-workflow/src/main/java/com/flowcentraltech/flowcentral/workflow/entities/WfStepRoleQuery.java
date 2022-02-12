/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.workflow.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseEntityQuery;

/**
 * Workflow role query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class WfStepRoleQuery extends BaseEntityQuery<WfStepRole> {

    public WfStepRoleQuery() {
        super(WfStepRole.class);
    }

    public WfStepRoleQuery roleCode(String roleCode) {
        return (WfStepRoleQuery) addEquals("roleCode", roleCode);
    }

    public WfStepRoleQuery wfStepName(String wfStepName) {
        return (WfStepRoleQuery) addEquals("wfStepName", wfStepName);
    }

    public WfStepRoleQuery workflowName(String workflowName) {
        return (WfStepRoleQuery) addEquals("workflowName", workflowName);
    }

    public WfStepRoleQuery applicationName(String applicationName) {
        return (WfStepRoleQuery) addEquals("applicationName", applicationName);
    }
}
