/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseConfigEntityQuery;

/**
 * Application applet property query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppTableColumnQuery extends BaseConfigEntityQuery<AppTableColumn> {

    public AppTableColumnQuery() {
        super(AppTableColumn.class);
    }

    public AppTableColumnQuery appTableId(Long appTableId) {
        return (AppTableColumnQuery) addEquals("appTableId", appTableId);
    }
}
