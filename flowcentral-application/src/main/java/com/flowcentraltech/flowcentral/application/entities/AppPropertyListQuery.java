/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

/**
 * Application property list query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppPropertyListQuery extends BaseApplicationEntityQuery<AppPropertyList> {

    public AppPropertyListQuery() {
        super(AppPropertyList.class);
    }

}
