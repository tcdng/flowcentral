/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseConfigNamedEntityQuery;

/**
 * Convenient abstract base class for application definition query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class BaseApplicationEntityQuery<T extends BaseApplicationEntity>
        extends BaseConfigNamedEntityQuery<T> {

    public BaseApplicationEntityQuery(Class<T> entityClass, boolean applyAppQueryLimit) {
        super(entityClass, applyAppQueryLimit);
    }

    public BaseApplicationEntityQuery(Class<T> entityClass) {
        super(entityClass);
    }

    public BaseApplicationEntityQuery<T> applicationId(Long applicationId) {
        return (BaseApplicationEntityQuery<T>) addEquals("applicationId", applicationId);
    }

    public BaseApplicationEntityQuery<T> applicationName(String applicationName) {
        return (BaseApplicationEntityQuery<T>) addEquals("applicationName", applicationName);
    }

}
