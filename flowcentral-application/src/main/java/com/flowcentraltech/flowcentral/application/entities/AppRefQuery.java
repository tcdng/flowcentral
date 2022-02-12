/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

/**
 * Application references query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppRefQuery extends BaseApplicationEntityQuery<AppRef> {

    public AppRefQuery() {
        super(AppRef.class);
    }

    public AppRefQuery entity(String entity) {
        return (AppRefQuery) addEquals("entity", entity);
    }
}
