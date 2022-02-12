/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.common.entities;

import com.flowcentraltech.flowcentral.common.constants.ConfigType;
import com.tcdng.unify.core.criterion.CompoundRestriction;

/**
 * Base query object for base configuration entity sub-classes.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class BaseConfigEntityQuery<T extends BaseConfigEntity> extends BaseEntityQuery<T> {

    public BaseConfigEntityQuery(Class<T> entityClass) {
        super(entityClass);
    }

    public BaseConfigEntityQuery(Class<T> entityClass, boolean applyAppQueryLimit) {
        super(entityClass, applyAppQueryLimit);
    }

    public BaseConfigEntityQuery(Class<T> entityClass, CompoundRestriction restrictions, boolean applyAppQueryLimit) {
        super(entityClass, restrictions, applyAppQueryLimit);
    }

    public final BaseConfigEntityQuery<T> configType(ConfigType configType) {
        return (BaseConfigEntityQuery<T>) addEquals("configType", configType);
    }

}
