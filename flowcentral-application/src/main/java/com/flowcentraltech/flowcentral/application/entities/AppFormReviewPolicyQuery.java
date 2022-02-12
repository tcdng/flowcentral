/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseConfigNamedEntityQuery;

/**
 * Application form review policy query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppFormReviewPolicyQuery extends BaseConfigNamedEntityQuery<AppFormReviewPolicy> {

    public AppFormReviewPolicyQuery() {
        super(AppFormReviewPolicy.class);
    }

    public AppFormReviewPolicyQuery appFormId(Long appFormId) {
        return (AppFormReviewPolicyQuery) addEquals("appFormId", appFormId);
    }
}
