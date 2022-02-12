/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseConfigNamedEntityQuery;

/**
 * Application entity unique constraint query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppEntityUniqueConstraintQuery extends BaseConfigNamedEntityQuery<AppEntityUniqueConstraint> {

    public AppEntityUniqueConstraintQuery() {
        super(AppEntityUniqueConstraint.class);
    }

    public AppEntityUniqueConstraintQuery appEntityId(Long appEntityId) {
        return (AppEntityUniqueConstraintQuery) addEquals("appEntityId", appEntityId);
    }

}
