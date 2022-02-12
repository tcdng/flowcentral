/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseConfigEntityQuery;
import com.flowcentraltech.flowcentral.configuration.constants.FormElementType;

/**
 * Application form element query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppFormElementQuery extends BaseConfigEntityQuery<AppFormElement> {

    public AppFormElementQuery() {
        super(AppFormElement.class);
    }

    public AppFormElementQuery appFormId(Long appFormId) {
        return (AppFormElementQuery) addEquals("appFormId", appFormId);
    }

    public AppFormElementQuery type(FormElementType type) {
        return (AppFormElementQuery) addEquals("type", type);
    }
}
