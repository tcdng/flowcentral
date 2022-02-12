/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

/**
 * Application table query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppTableQuery extends BaseApplicationEntityQuery<AppTable> {

    public AppTableQuery() {
        super(AppTable.class);
    }

    public AppTableQuery entity(String entity) {
        return (AppTableQuery) addEquals("entity", entity);
    }

}
