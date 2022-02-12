/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.flowcentraltech.flowcentral.configuration.constants.EntityBaseType;

/**
 * Application entity query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppEntityQuery extends BaseApplicationEntityQuery<AppEntity> {

    private static final List<EntityBaseType> BASE_WORK_TYPES = Collections.unmodifiableList(Arrays.asList(EntityBaseType.BASE_WORK_ENTITY, EntityBaseType.BASE_STATUS_WORK_ENTITY));
    
    public AppEntityQuery() {
        super(AppEntity.class);
    }

    public AppEntityQuery entityClass(String entityClass) {
        return (AppEntityQuery) addEquals("entityClass", entityClass);
    }

    public AppEntityQuery isWorkEntity() {
        return (AppEntityQuery) addAmongst("baseType", BASE_WORK_TYPES);
    }
}
