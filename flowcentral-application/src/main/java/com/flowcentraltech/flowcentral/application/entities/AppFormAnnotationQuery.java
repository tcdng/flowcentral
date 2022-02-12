/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseConfigNamedEntityQuery;

/**
 * Application for annotation query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppFormAnnotationQuery extends BaseConfigNamedEntityQuery<AppFormAnnotation> {

    public AppFormAnnotationQuery() {
        super(AppFormAnnotation.class);
    }

    public AppFormAnnotationQuery appFormId(Long appFormId) {
        return (AppFormAnnotationQuery) addEquals("appFormId", appFormId);
    }
}
