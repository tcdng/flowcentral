/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.configuration.constants.FormType;

/**
 * Application form query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppFormQuery extends BaseApplicationEntityQuery<AppForm> {

    public AppFormQuery() {
        super(AppForm.class);
    }

    public AppFormQuery entity(String entity) {
        return (AppFormQuery) addEquals("entity", entity);
    }

    public AppFormQuery type(FormType type) {
        return (AppFormQuery) addEquals("type", type);
    }

}
