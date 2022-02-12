/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseConfigNamedEntityQuery;

/**
 * Application form related list query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppFormRelatedListQuery extends BaseConfigNamedEntityQuery<AppFormRelatedList> {

    public AppFormRelatedListQuery() {
        super(AppFormRelatedList.class);
    }

    public AppFormRelatedListQuery appFormId(Long appFormId) {
        return (AppFormRelatedListQuery) addEquals("appFormId", appFormId);
    }
}
