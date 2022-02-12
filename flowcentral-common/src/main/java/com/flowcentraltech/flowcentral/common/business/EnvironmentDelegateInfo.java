/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.business;

import com.tcdng.unify.core.database.Entity;

/**
 * Environment delegate information.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class EnvironmentDelegateInfo {

    private String entityLongName;

    private Class<? extends Entity> entityClass;

    private EnvironmentDelegate environmentDelegate;

    public EnvironmentDelegateInfo(String entityLongName, Class<? extends Entity> entityClass,
            EnvironmentDelegate environmentDelegate) {
        this.entityLongName = entityLongName;
        this.entityClass = entityClass;
        this.environmentDelegate = environmentDelegate;
    }

    public String getEntityLongName() {
        return entityLongName;
    }

    public Class<? extends Entity> getEntityClass() {
        return entityClass;
    }

    public EnvironmentDelegate getEnvironmentDelegate() {
        return environmentDelegate;
    }
}
