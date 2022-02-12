/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.workflow.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseAuditEntityQuery;

/**
 * Workflow item history query.
 * 
 * @author Lateef Ojulari
 * @version 1.0
 */
public class WfItemHistQuery extends BaseAuditEntityQuery<WfItemHist> {

    public WfItemHistQuery() {
        super(WfItemHist.class);
    }

    public WfItemHistQuery itemDescLike(String itemDesc) {
        return (WfItemHistQuery) addLike("itemDesc", itemDesc);
    }
}
