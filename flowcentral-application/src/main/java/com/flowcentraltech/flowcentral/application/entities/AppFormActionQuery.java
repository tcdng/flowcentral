/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseConfigNamedEntityQuery;

/**
 * Application for action query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppFormActionQuery extends BaseConfigNamedEntityQuery<AppFormAction> {

    public AppFormActionQuery() {
        super(AppFormAction.class);
    }

    public AppFormActionQuery appFormId(Long appFormId) {
        return (AppFormActionQuery) addEquals("appFormId", appFormId);
    }
}
