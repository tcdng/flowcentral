/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.system.entities;

import java.util.Date;

import com.flowcentraltech.flowcentral.common.entities.BaseStatusEntityPolicy;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.database.Entity;
import com.tcdng.unify.core.util.CalendarUtils;
import com.tcdng.unify.core.util.DataUtils;

/**
 * Scheduled task entity policy
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("scheduledtask-entitypolicy")
public class ScheduledTaskPolicy extends BaseStatusEntityPolicy {

    @Override
    public Object preCreate(Entity record, Date now) throws UnifyException {
        ScheduledTask scheduledTask = (ScheduledTask) record;
        scheduledTask.setNextExecutionOn(getNextExecutionOn(scheduledTask, now));
        return super.preCreate(record, now);
    }

    @Override
    public void preUpdate(Entity record, Date now) throws UnifyException {
        ScheduledTask scheduledTask = (ScheduledTask) record;
        scheduledTask.setNextExecutionOn(getNextExecutionOn(scheduledTask, now));
        super.preUpdate(record, now);
    }

    private Date getNextExecutionOn(ScheduledTask scheduledTask, Date now) throws UnifyException {
        Date nextExecutionOn = CalendarUtils.getMidnightDate(now);
        String[] weekdays = DataUtils.convert(String[].class, scheduledTask.getWeekdays());
        String[] days = DataUtils.convert(String[].class, scheduledTask.getDays());
        String[] months = DataUtils.convert(String[].class, scheduledTask.getMonths());
        if (!CalendarUtils.isWithinCalendar(weekdays, days, months, nextExecutionOn)) {
            nextExecutionOn = CalendarUtils.getNextEligibleDate(weekdays, days, months, nextExecutionOn);
        }

        return CalendarUtils.getDateWithOffset(nextExecutionOn,
                CalendarUtils.getTimeOfDayOffset(scheduledTask.getStartTime()));
    }
}
