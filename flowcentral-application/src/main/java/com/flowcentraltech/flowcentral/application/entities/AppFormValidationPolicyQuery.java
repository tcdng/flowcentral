/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseConfigNamedEntityQuery;

/**
 * Application form validation policy query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppFormValidationPolicyQuery extends BaseConfigNamedEntityQuery<AppFormValidationPolicy> {

    public AppFormValidationPolicyQuery() {
        super(AppFormValidationPolicy.class);
    }

    public AppFormValidationPolicyQuery appFormId(Long appFormId) {
        return (AppFormValidationPolicyQuery) addEquals("appFormId", appFormId);
    }
}
