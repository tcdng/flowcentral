/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseConfigNamedEntityQuery;

/**
 * Application entity index query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppEntityIndexQuery extends BaseConfigNamedEntityQuery<AppEntityIndex> {

    public AppEntityIndexQuery() {
        super(AppEntityIndex.class);
    }

    public AppEntityIndexQuery appEntityId(Long appEntityId) {
        return (AppEntityIndexQuery) addEquals("appEntityId", appEntityId);
    }

}
