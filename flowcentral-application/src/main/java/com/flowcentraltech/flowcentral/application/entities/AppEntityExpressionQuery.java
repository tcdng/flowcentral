/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseConfigNamedEntityQuery;

/**
 * Application entity expression query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppEntityExpressionQuery extends BaseConfigNamedEntityQuery<AppEntityExpression> {

    public AppEntityExpressionQuery() {
        super(AppEntityExpression.class);
    }

    public AppEntityExpressionQuery appEntityId(Long appEntityId) {
        return (AppEntityExpressionQuery) addEquals("appEntityId", appEntityId);
    }

}
