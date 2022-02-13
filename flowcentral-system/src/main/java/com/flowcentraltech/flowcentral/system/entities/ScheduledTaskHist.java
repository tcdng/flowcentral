/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.system.entities;

import java.util.Date;

import com.flowcentraltech.flowcentral.common.entities.BaseEntity;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ColumnType;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.ListOnly;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.task.TaskStatus;
import com.tcdng.unify.core.util.StringUtils;

/**
 * Scheduled task history.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_SCHEDULEDTASKHIST")
public class ScheduledTaskHist extends BaseEntity {

    @ForeignKey(ScheduledTask.class)
    private Long scheduledTaskId;

    @ForeignKey
    private TaskStatus taskStatus;

    @Column(type = ColumnType.TIMESTAMP_UTC)
    private Date startedOn;

    @Column(type = ColumnType.TIMESTAMP_UTC, nullable = true)
    private Date finishedOn;

    @Column(length = 512, nullable = true)
    private String errorMsg;

    @ListOnly(key = "scheduledTaskId", property = "description")
    private String scheduledTaskDesc;

    @ListOnly(key = "scheduledTaskId", property = "taskName")
    private String taskName;

    @ListOnly(key = "taskStatus", property = "description")
    private String taskStatusDesc;

    @Override
    public String getDescription() {
        return StringUtils.concatenate(scheduledTaskDesc, " - startedOn:", getStartedOn(), "- status: ", taskStatus);
    }

    public Long getScheduledTaskId() {
        return scheduledTaskId;
    }

    public void setScheduledTaskId(Long scheduledTaskId) {
        this.scheduledTaskId = scheduledTaskId;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Date getStartedOn() {
        return startedOn;
    }

    public void setStartedOn(Date startedOn) {
        this.startedOn = startedOn;
    }

    public Date getFinishedOn() {
        return finishedOn;
    }

    public void setFinishedOn(Date finishedOn) {
        this.finishedOn = finishedOn;
    }

    public String getScheduledTaskDesc() {
        return scheduledTaskDesc;
    }

    public void setScheduledTaskDesc(String scheduledTaskDesc) {
        this.scheduledTaskDesc = scheduledTaskDesc;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskStatusDesc() {
        return taskStatusDesc;
    }

    public void setTaskStatusDesc(String taskStatusDesc) {
        this.taskStatusDesc = taskStatusDesc;
    }
}