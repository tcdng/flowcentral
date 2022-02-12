/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.system.data;

import java.util.Arrays;

import com.flowcentraltech.flowcentral.common.data.ParamValuesDef;

/**
 * Schedule task runtime info.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ScheduledTaskDef {

    private Long id;

    private String lock;

    private String description;

    private String taskName;

    private long startOffset;

    private long endOffset;

    private long repeatMillSecs;

    private String[] weekdays;

    private String[] days;

    private String[] months;

    private ParamValuesDef paramValuesDef;

    private long version;

    public ScheduledTaskDef(Long id, String lock, String description, String taskName, long startOffset, long endOffset,
            long repeatMillSecs, String[] weekdays, String[] days, String[] months, ParamValuesDef paramValuesDef,
            long version) {
        this.id = id;
        this.lock = lock;
        this.description = description;
        this.taskName = taskName;
        this.startOffset = startOffset;
        this.endOffset = endOffset;
        this.repeatMillSecs = repeatMillSecs;
        this.weekdays = weekdays;
        this.days = days;
        this.months = months;
        this.paramValuesDef = paramValuesDef;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public String getLock() {
        return lock;
    }

    public String getDescription() {
        return description;
    }

    public String getTaskName() {
        return taskName;
    }

    public long getStartOffset() {
        return startOffset;
    }

    public long getEndOffset() {
        return endOffset;
    }

    public long getRepeatMillSecs() {
        return repeatMillSecs;
    }

    public String[] getWeekdays() {
        return weekdays;
    }

    public String[] getDays() {
        return days;
    }

    public String[] getMonths() {
        return months;
    }

    public ParamValuesDef getParamValuesDef() {
        return paramValuesDef;
    }

    public long getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "ScheduledTaskDef [lock=" + lock + ", description=" + description + ", taskName=" + taskName
                + ", startOffset=" + startOffset + ", endOffset=" + endOffset + ", repeatMillSecs=" + repeatMillSecs
                + ", weekdays=" + Arrays.toString(weekdays) + ", days=" + Arrays.toString(days) + ", months="
                + Arrays.toString(months) + ", paramValuesDef=" + paramValuesDef + ", version=" + version + "]";
    }

}
