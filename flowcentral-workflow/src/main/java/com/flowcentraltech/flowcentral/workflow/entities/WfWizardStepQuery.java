/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.workflow.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseConfigNamedEntityQuery;

/**
 * Application workflow wizard step query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class WfWizardStepQuery extends BaseConfigNamedEntityQuery<WfWizardStep> {

    public WfWizardStepQuery() {
        super(WfWizardStep.class);
    }

    public WfWizardStepQuery wfWizardId(Long wfWizardId) {
        return (WfWizardStepQuery) addEquals("wfWizardId", wfWizardId);
    }

}
