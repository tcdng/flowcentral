/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.workflow.entities;

import com.flowcentraltech.flowcentral.application.entities.BaseApplicationEntityQuery;

/**
 * Application workflow wizard query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class WfWizardQuery extends BaseApplicationEntityQuery<WfWizard> {

    public WfWizardQuery() {
        super(WfWizard.class);
    }

}
