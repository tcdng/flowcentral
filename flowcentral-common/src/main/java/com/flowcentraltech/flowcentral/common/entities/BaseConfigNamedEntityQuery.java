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
 * Base query object for base configuration named entity sub-classes.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class BaseConfigNamedEntityQuery<T extends BaseConfigNamedEntity> extends BaseNamedEntityQuery<T> {

    public BaseConfigNamedEntityQuery(Class<T> entityClass) {
        super(entityClass);
    }

    public BaseConfigNamedEntityQuery(Class<T> entityClass, boolean applyAppQueryLimit) {
        super(entityClass, applyAppQueryLimit);
    }

    public BaseConfigNamedEntityQuery(Class<T> entityClass, CompoundRestriction restrictions,
            boolean applyAppQueryLimit) {
        super(entityClass, restrictions, applyAppQueryLimit);
    }

    public final BaseConfigNamedEntityQuery<T> configType(ConfigType configType) {
        return (BaseConfigNamedEntityQuery<T>) addEquals("configType", configType);
    }

}
