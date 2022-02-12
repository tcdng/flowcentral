/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.system.entities;

import java.util.Date;

import com.flowcentraltech.flowcentral.common.constants.RecordStatus;
import com.flowcentraltech.flowcentral.common.entities.BaseStatusEntityQuery;

/**
 * Scheduled task query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ScheduledTaskQuery extends BaseStatusEntityQuery<ScheduledTask> {

    public ScheduledTaskQuery() {
        super(ScheduledTask.class);
    }

    public ScheduledTaskQuery descriptionLike(String description) {
        return (ScheduledTaskQuery) addLike("description", description);
    }

    public ScheduledTaskQuery taskName(String taskName) {
        return (ScheduledTaskQuery) addEquals("taskName", taskName);
    }

    public ScheduledTaskQuery readyToRunOn(Date date) {
        return (ScheduledTaskQuery) addLessThanEqual("nextExecutionOn", date).addEquals("status", RecordStatus.ACTIVE);
    }
}