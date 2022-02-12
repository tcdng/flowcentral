/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.workflow.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseEntityQuery;

/**
 * Workflow transition queue.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class WfTransitionQueueQuery extends BaseEntityQuery<WfTransitionQueue> {

    public WfTransitionQueueQuery() {
        super(WfTransitionQueue.class);
    }

    public WfTransitionQueueQuery unprocessed() {
        return (WfTransitionQueueQuery) addIsNull("processingDt");
    }

}
