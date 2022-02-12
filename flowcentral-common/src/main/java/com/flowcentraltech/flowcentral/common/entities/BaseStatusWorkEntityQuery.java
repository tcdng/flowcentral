/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.common.entities;

import com.flowcentraltech.flowcentral.common.constants.RecordStatus;

/**
 * Base query object for base work entity sub-classes.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class BaseStatusWorkEntityQuery<T extends BaseStatusWorkEntity> extends BaseWorkEntityQuery<T> {

    public BaseStatusWorkEntityQuery(Class<T> entityClass) {
        super(entityClass);
    }

    public BaseStatusWorkEntityQuery(Class<T> entityClass, boolean applyAppQueryLimit) {
        super(entityClass, applyAppQueryLimit);
    }

    public final BaseStatusWorkEntityQuery<T> status(RecordStatus status) {
        return (BaseStatusWorkEntityQuery<T>) addEquals("status", status);
    }
}
