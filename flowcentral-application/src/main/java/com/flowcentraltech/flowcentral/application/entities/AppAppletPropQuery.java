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
public class AppAppletPropQuery extends BaseConfigEntityQuery<AppAppletProp> {

    public AppAppletPropQuery() {
        super(AppAppletProp.class);
    }

    public AppAppletPropQuery appAppletId(Long appAppletId) {
        return (AppAppletPropQuery) addEquals("appAppletId", appAppletId);
    }
}
