/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.system.entities;

import java.util.Date;

import com.flowcentraltech.flowcentral.common.entities.BaseStatusEntity;
import com.flowcentraltech.flowcentral.common.entities.ParamValues;
import com.tcdng.unify.core.annotation.Child;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ColumnType;
import com.tcdng.unify.core.annotation.Policy;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.annotation.UniqueConstraint;

/**
 * Scheduled task entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Policy("scheduledtask-entitypolicy")
@Table(name = "FC_SCHEDULEDTASK", uniqueConstraints = { @UniqueConstraint({ "description" }) })
public class ScheduledTask extends BaseStatusEntity {

    @Column(name = "SCHEDTASK_DESC", length = 64)
    private String description;

    @Column(name = "TASK_NM")
    private String taskName;

    @Column(type = ColumnType.TIMESTAMP_UTC)
    private Date startTime;

    @Column(type = ColumnType.TIMESTAMP_UTC, nullable = true)
    private Date endTime;

    @Column(type = ColumnType.TIMESTAMP_UTC)
    private Date nextExecutionOn;

    @Column(type = ColumnType.TIMESTAMP_UTC, nullable = true)
    private Date lastExecutionOn;

    @Column(nullable = true)
    private String frequency;

    @Column(length = 128, nullable = true)
    private String weekdays;

    @Column(length = 128, nullable = true)
    private String days;

    @Column(length = 128, nullable = true)
    private String months;

    @Child(category = "scheduledtask")
    private ParamValues paramValues;

    @Override
    public String getDescription() {
        return description;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getNextExecutionOn() {
        return nextExecutionOn;
    }

    public void setNextExecutionOn(Date nextExecutionOn) {
        this.nextExecutionOn = nextExecutionOn;
    }

    public Date getLastExecutionOn() {
        return lastExecutionOn;
    }

    public void setLastExecutionOn(Date lastExecutionOn) {
        this.lastExecutionOn = lastExecutionOn;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getWeekdays() {
        return weekdays;
    }

    public void setWeekdays(String weekdays) {
        this.weekdays = weekdays;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getMonths() {
        return months;
    }

    public void setMonths(String months) {
        this.months = months;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ParamValues getParamValues() {
        return paramValues;
    }

    public void setParamValues(ParamValues paramValues) {
        this.paramValues = paramValues;
    }

}
