/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseConfigNamedEntityQuery;

/**
 * Application form field validation policy query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppFormFieldValidationPolicyQuery extends BaseConfigNamedEntityQuery<AppFormFieldValidationPolicy> {

    public AppFormFieldValidationPolicyQuery() {
        super(AppFormFieldValidationPolicy.class);
    }

    public AppFormFieldValidationPolicyQuery appFormId(Long appFormId) {
        return (AppFormFieldValidationPolicyQuery) addEquals("appFormId", appFormId);
    }
}
