/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseConfigNamedEntityQuery;

/**
 * Application table action query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppTableActionQuery extends BaseConfigNamedEntityQuery<AppTableAction> {

    public AppTableActionQuery() {
        super(AppTableAction.class);
    }

    public AppTableActionQuery appTableId(Long appTableId) {
        return (AppTableActionQuery) addEquals("appTableId", appTableId);
    }
}
