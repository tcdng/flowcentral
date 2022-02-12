/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.workflow.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseEntityQuery;

/**
 * Workflow wizard item query.
 * 
 * @author Lateef Ojulari
 * @version 1.0
 */
public class WfWizardItemQuery extends BaseEntityQuery<WfWizardItem> {

    public WfWizardItemQuery() {
        super(WfWizardItem.class);
    }

    public WfWizardItemQuery wizard(String wizard) {
        return (WfWizardItemQuery) addEquals("wizard", wizard);
    }

    public WfWizardItemQuery ownerId(String ownerId) {
        return (WfWizardItemQuery) addEquals("ownerId", ownerId);
    }

    public WfWizardItemQuery primaryEntityId(Long primaryEntityId) {
        return (WfWizardItemQuery) addEquals("primaryEntityId", primaryEntityId);
    }
}
