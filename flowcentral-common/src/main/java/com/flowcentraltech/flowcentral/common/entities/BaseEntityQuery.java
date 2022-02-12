/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.common.entities;

import com.tcdng.unify.core.criterion.CompoundRestriction;
import com.tcdng.unify.core.system.entities.SequencedEntityQuery;

/**
 * Base query object for base entity sub-classes.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class BaseEntityQuery<T extends BaseEntity> extends SequencedEntityQuery<T> {

    public BaseEntityQuery(Class<T> entityClass) {
        super(entityClass);
    }

    public BaseEntityQuery(Class<T> entityClass, boolean applyAppQueryLimit) {
        super(entityClass, applyAppQueryLimit);
    }

    public BaseEntityQuery(Class<T> entityClass, CompoundRestriction restrictions, boolean applyAppQueryLimit) {
        super(entityClass, restrictions, applyAppQueryLimit);
    }

    public final BaseEntityQuery<T> excludeSysRecords() {
        return (BaseEntityQuery<T>) addGreaterThan("id", Long.valueOf(0L));
    }
}
