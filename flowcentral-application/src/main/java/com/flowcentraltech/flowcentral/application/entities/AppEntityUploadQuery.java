/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseConfigNamedEntityQuery;

/**
 * Application entity upload query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppEntityUploadQuery extends BaseConfigNamedEntityQuery<AppEntityUpload> {

    public AppEntityUploadQuery() {
        super(AppEntityUpload.class);
    }

    public AppEntityUploadQuery appEntityId(Long appEntityId) {
        return (AppEntityUploadQuery) addEquals("appEntityId", appEntityId);
    }

    public AppEntityUploadQuery applicationId(Long applicationId) {
        return (AppEntityUploadQuery) addEquals("applicationId", applicationId);
    }

    public AppEntityUploadQuery applicationName(String applicationName) {
        return (AppEntityUploadQuery) addEquals("applicationName", applicationName);
    }

    public AppEntityUploadQuery entityName(String entityName) {
        return (AppEntityUploadQuery) addEquals("entityName", entityName);
    }

}
