/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.common.entities;

import com.flowcentraltech.flowcentral.common.constants.RecordStatus;

/**
 * Base query object for base status entity sub-classes.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class BaseStatusEntityQuery<T extends BaseStatusEntity> extends BaseAuditEntityQuery<T> {

    public BaseStatusEntityQuery(Class<T> entityClass) {
        super(entityClass);
    }

    public BaseStatusEntityQuery(Class<T> entityClass, boolean applyAppQueryLimit) {
        super(entityClass, applyAppQueryLimit);
    }

    public final BaseStatusEntityQuery<T> status(RecordStatus status) {
        return (BaseStatusEntityQuery<T>) addEquals("status", status);
    }
}
