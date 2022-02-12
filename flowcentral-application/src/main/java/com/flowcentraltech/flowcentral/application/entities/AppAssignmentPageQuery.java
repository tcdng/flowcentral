/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

/**
 * Application assignment page query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppAssignmentPageQuery extends BaseApplicationEntityQuery<AppAssignmentPage> {

    public AppAssignmentPageQuery() {
        super(AppAssignmentPage.class);
    }

    public AppAssignmentPageQuery entity(String entity) {
        return (AppAssignmentPageQuery) addEquals("entity", entity);
    }

}
