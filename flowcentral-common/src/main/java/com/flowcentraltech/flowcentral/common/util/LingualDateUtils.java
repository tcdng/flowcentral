/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.util;

import java.util.Calendar;
import java.util.Date;

import com.flowcentraltech.flowcentral.common.data.DateRange;
import com.flowcentraltech.flowcentral.configuration.constants.LingualDateType;
import com.tcdng.unify.core.util.CalendarUtils;

/**
 * Lingual date utilities.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public final class LingualDateUtils {

    private LingualDateUtils() {

    }

    public static DateRange getDateRangeFromNow(Date now, LingualDateType type) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(now);
        cal1.setTime(now);
        switch (type) {
            case LAST_12MONTHS:
                cal1.add(Calendar.MONTH, -12);
                break;
            case LAST_3MONTHS:
                cal1.add(Calendar.MONTH, -3);
                break;
            case LAST_6MONTHS:
                cal1.add(Calendar.MONTH, -6);
                break;
            case LAST_9MONTHS:
                cal1.add(Calendar.MONTH, -9);
                break;
            case LAST_MONTH:
                cal1.add(Calendar.MONTH, -1);
                cal2.add(Calendar.MONTH, -1);
                cal1.set(Calendar.DAY_OF_MONTH, 1);
                cal2.set(Calendar.DAY_OF_MONTH, cal2.getActualMaximum(Calendar.DAY_OF_MONTH));
                break;
            case LAST_WEEK:
                cal1.add(Calendar.DATE, -7);
                cal2.add(Calendar.DATE, -7);
                cal1.set(Calendar.DAY_OF_WEEK, 1);
                cal2.set(Calendar.DAY_OF_WEEK, 7);
                break;
            case LAST_YEAR:
                cal1.add(Calendar.YEAR, -1);
                cal2.add(Calendar.YEAR, -1);
                cal1.set(Calendar.DAY_OF_YEAR, 1);
                cal2.set(Calendar.DAY_OF_YEAR, cal2.getActualMaximum(Calendar.DAY_OF_YEAR));
                break;
            case NEXT_12MONTHS:
                cal2.add(Calendar.MONTH, 12);
                break;
            case NEXT_3MONTHS:
                cal2.add(Calendar.MONTH, 3);
                break;
            case NEXT_6MONTHS:
                cal2.add(Calendar.MONTH, 6);
                break;
            case NEXT_9MONTHS:
                cal2.add(Calendar.MONTH, 9);
                break;
            case NEXT_MONTH:
                cal1.add(Calendar.MONTH, 1);
                cal2.add(Calendar.MONTH, 1);
                cal1.set(Calendar.DAY_OF_MONTH, 1);
                cal2.set(Calendar.DAY_OF_MONTH, cal2.getActualMaximum(Calendar.DAY_OF_MONTH));
                break;
            case NEXT_WEEK:
                cal1.add(Calendar.DATE, 7);
                cal2.add(Calendar.DATE, 7);
                cal1.set(Calendar.DAY_OF_WEEK, 1);
                cal2.set(Calendar.DAY_OF_WEEK, 7);
                break;
            case NEXT_YEAR:
                cal1.add(Calendar.YEAR, 1);
                cal2.add(Calendar.YEAR, 1);
                cal1.set(Calendar.DAY_OF_YEAR, 1);
                cal2.set(Calendar.DAY_OF_YEAR, cal2.getActualMaximum(Calendar.DAY_OF_YEAR));
                break;
            case THIS_MONTH:
                cal1.set(Calendar.DAY_OF_MONTH, 1);
                cal2.set(Calendar.DAY_OF_MONTH, cal2.getActualMaximum(Calendar.DAY_OF_MONTH));
                break;
            case THIS_WEEK:
                cal1.set(Calendar.DAY_OF_WEEK, 1);
                cal2.set(Calendar.DAY_OF_WEEK, 7);
                break;
            case THIS_YEAR:
                cal1.set(Calendar.DAY_OF_YEAR, 1);
                cal2.set(Calendar.DAY_OF_YEAR, cal2.getActualMaximum(Calendar.DAY_OF_YEAR));
                break;
            case TOMORROW:
                cal1.add(Calendar.DATE, 1);
                cal2.add(Calendar.DATE, 1);
                break;
            case YESTERDAY:
                cal1.add(Calendar.DATE, -1);
                cal2.add(Calendar.DATE, -1);
                break;
            case TODAY:
            default:
                break;
        }

        return new DateRange(CalendarUtils.getMidnightDate(cal1.getTime()),
                CalendarUtils.getLastSecondDate(cal2.getTime()));
    }

    public static Date getDateFromNow(Date now, LingualDateType type) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(now);
        switch (type) {
            case LAST_12MONTHS:
                cal1.add(Calendar.MONTH, -12);
                break;
            case LAST_3MONTHS:
                cal1.add(Calendar.MONTH, -3);
                break;
            case LAST_6MONTHS:
                cal1.add(Calendar.MONTH, -6);
                break;
            case LAST_9MONTHS:
                cal1.add(Calendar.MONTH, -9);
                break;
            case LAST_MONTH:
                cal1.add(Calendar.MONTH, -1);
                cal1.set(Calendar.DAY_OF_MONTH, 1);
                break;
            case LAST_WEEK:
                cal1.add(Calendar.DATE, -7);
                cal1.set(Calendar.DAY_OF_WEEK, 1);
                break;
            case LAST_YEAR:
                cal1.add(Calendar.YEAR, -1);
                cal1.set(Calendar.DAY_OF_YEAR, 1);
                break;
            case NEXT_12MONTHS:
                cal1.add(Calendar.MONTH, 12);
                break;
            case NEXT_3MONTHS:
                cal1.add(Calendar.MONTH, 3);
                break;
            case NEXT_6MONTHS:
                cal1.add(Calendar.MONTH, 6);
                break;
            case NEXT_9MONTHS:
                cal1.add(Calendar.MONTH, 9);
                break;
            case NEXT_MONTH:
                cal1.add(Calendar.MONTH, 1);
                cal1.set(Calendar.DAY_OF_MONTH, 1);
                break;
            case NEXT_WEEK:
                cal1.add(Calendar.DATE, 7);
                cal1.set(Calendar.DAY_OF_WEEK, 1);
                break;
            case NEXT_YEAR:
                cal1.add(Calendar.YEAR, 1);
                cal1.set(Calendar.DAY_OF_YEAR, 1);
                break;
            case THIS_MONTH:
                cal1.set(Calendar.DAY_OF_MONTH, 1);
                break;
            case THIS_WEEK:
                cal1.set(Calendar.DAY_OF_WEEK, 1);
                break;
            case THIS_YEAR:
                cal1.set(Calendar.DAY_OF_YEAR, 1);
                break;
            case TOMORROW:
                cal1.add(Calendar.DATE, 1);
                break;
            case YESTERDAY:
                cal1.add(Calendar.DATE, -1);
                break;
            case TODAY:
            default:
                break;
        }

        return CalendarUtils.getMidnightDate(cal1.getTime());
    }
}
