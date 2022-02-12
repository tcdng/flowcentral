/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.system.entities;

import java.util.Date;

import com.flowcentraltech.flowcentral.common.entities.BaseEntityQuery;
import com.tcdng.unify.core.task.TaskStatus;
import com.tcdng.unify.core.util.CalendarUtils;

/**
 * Scheduled task history query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ScheduledTaskHistQuery extends BaseEntityQuery<ScheduledTaskHist> {

    public ScheduledTaskHistQuery() {
        super(ScheduledTaskHist.class);
    }

    public ScheduledTaskHistQuery taskStatus(TaskStatus taskStatus) {
        return (ScheduledTaskHistQuery) addEquals("taskStatus", taskStatus);
    }

    public ScheduledTaskHistQuery taskName(String taskName) {
        return (ScheduledTaskHistQuery) addEquals("taskName", taskName);
    }

    public ScheduledTaskHistQuery scheduledTaskId(Long scheduledTaskId) {
        return (ScheduledTaskHistQuery) addEquals("scheduledTaskId", scheduledTaskId);
    }

    public ScheduledTaskHistQuery startedOn(Date date) {
        return (ScheduledTaskHistQuery) addBetween("startedOn", CalendarUtils.getMidnightDate(date),
                CalendarUtils.getLastSecondDate(date));
    }
}
