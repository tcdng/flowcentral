/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.system.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseAuditEntityQuery;

/**
 * Environment variable query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class EnvironmentVariableQuery extends BaseAuditEntityQuery<EnvironmentVariable> {

    public EnvironmentVariableQuery() {
        super(EnvironmentVariable.class);
    }

    public EnvironmentVariableQuery name(String name) {
        return (EnvironmentVariableQuery) addEquals("name", name);
    }

    public EnvironmentVariableQuery nameLike(String name) {
        return (EnvironmentVariableQuery) addLike("name", name);
    }

    public EnvironmentVariableQuery descriptionLike(String description) {
        return (EnvironmentVariableQuery) addLike("description", description);
    }
}
