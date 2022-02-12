/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.common.entities;

import java.util.Date;

import com.tcdng.unify.core.criterion.CompoundRestriction;
import com.tcdng.unify.core.util.CalendarUtils;

/**
 * Base query object for base audit entity sub-classes.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class BaseAuditEntityQuery<T extends BaseAuditEntity> extends BaseEntityQuery<T> {

    public BaseAuditEntityQuery(Class<T> entityClass) {
        super(entityClass);
    }

    public BaseAuditEntityQuery(Class<T> entityClass, boolean applyAppQueryLimit) {
        super(entityClass, applyAppQueryLimit);
    }

    public BaseAuditEntityQuery(Class<T> entityClass, CompoundRestriction restrictions, boolean applyAppQueryLimit) {
        super(entityClass, restrictions, applyAppQueryLimit);
    }

    public final BaseAuditEntityQuery<T> createdBy(String createdBy) {
        return (BaseAuditEntityQuery<T>) addEquals("createdBy", createdBy);
    }

    public final BaseAuditEntityQuery<T> createdOn(Date date) {
        return (BaseAuditEntityQuery<T>) addBetween("createDt", CalendarUtils.getMidnightDate(date),
                CalendarUtils.getLastSecondDate(date));
    }

    public final BaseAuditEntityQuery<T> createdBetween(Date fromDate, Date toDate) {
        return (BaseAuditEntityQuery<T>) addBetween("createDt", CalendarUtils.getMidnightDate(fromDate),
                CalendarUtils.getLastSecondDate(toDate));
    }

    public final BaseAuditEntityQuery<T> createdBefore(Date date) {
        return (BaseAuditEntityQuery<T>) addLessThan("createDt", date);
    }

    public final BaseAuditEntityQuery<T> createdOnBefore(Date date) {
        return (BaseAuditEntityQuery<T>) addLessThanEqual("createDt", date);
    }

    public final BaseAuditEntityQuery<T> createdAfter(Date date) {
        return (BaseAuditEntityQuery<T>) addGreaterThan("createDt", date);
    }

    public final BaseAuditEntityQuery<T> createdOnAfter(Date date) {
        return (BaseAuditEntityQuery<T>) addGreaterThanEqual("createDt", date);
    }

    public final BaseAuditEntityQuery<T> updatedBy(String updatedBy) {
        return (BaseAuditEntityQuery<T>) addEquals("updatedBy", updatedBy);
    }

    public final BaseAuditEntityQuery<T> updatedOn(Date date) {
        return (BaseAuditEntityQuery<T>) addBetween("updateDt", CalendarUtils.getMidnightDate(date),
                CalendarUtils.getLastSecondDate(date));
    }

    public final BaseAuditEntityQuery<T> updatedBetween(Date fromDate, Date toDate) {
        return (BaseAuditEntityQuery<T>) addBetween("updateDt", CalendarUtils.getMidnightDate(fromDate),
                CalendarUtils.getLastSecondDate(toDate));
    }

    public final BaseAuditEntityQuery<T> updatedBefore(Date date) {
        return (BaseAuditEntityQuery<T>) addLessThan("updateDt", date);
    }

    public final BaseAuditEntityQuery<T> updatedOnBefore(Date date) {
        return (BaseAuditEntityQuery<T>) addLessThanEqual("updateDt", date);
    }

    public final BaseAuditEntityQuery<T> updatedAfter(Date date) {
        return (BaseAuditEntityQuery<T>) addGreaterThan("updateDt", date);
    }

    public final BaseAuditEntityQuery<T> updatedOnAfter(Date date) {
        return (BaseAuditEntityQuery<T>) addGreaterThanEqual("updateDt", date);
    }
}
