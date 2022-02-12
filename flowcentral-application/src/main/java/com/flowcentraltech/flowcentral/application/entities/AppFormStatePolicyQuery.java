/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseConfigNamedEntityQuery;

/**
 * Application form state policy query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppFormStatePolicyQuery extends BaseConfigNamedEntityQuery<AppFormStatePolicy> {

    public AppFormStatePolicyQuery() {
        super(AppFormStatePolicy.class);
    }

    public AppFormStatePolicyQuery appFormId(Long appFormId) {
        return (AppFormStatePolicyQuery) addEquals("appFormId", appFormId);
    }
}
