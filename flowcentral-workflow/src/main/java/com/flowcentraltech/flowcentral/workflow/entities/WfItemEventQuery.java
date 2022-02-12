/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.workflow.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseEntityQuery;

/**
 * Workflow item event query.
 * 
 * @author Lateef Ojulari
 * @version 1.0
 */
public class WfItemEventQuery extends BaseEntityQuery<WfItemEvent> {

    public WfItemEventQuery() {
        super(WfItemEvent.class);
    }

    public WfItemEventQuery wfItemHistId(Long wfItemHistId) {
        return (WfItemEventQuery) addEquals("wfItemHistId", wfItemHistId);
    }

    public WfItemEventQuery commentsOnly() {
        return (WfItemEventQuery) addIsNotNull("comment");
    }
}
