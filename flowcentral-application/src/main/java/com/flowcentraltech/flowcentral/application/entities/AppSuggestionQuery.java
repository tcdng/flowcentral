/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseAuditEntityQuery;

/**
 * Application suggestion query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppSuggestionQuery extends BaseAuditEntityQuery<AppSuggestion> {

    public AppSuggestionQuery() {
        super(AppSuggestion.class);
    }

    public AppSuggestionQuery applicationName(String applicationName) {
        return (AppSuggestionQuery) addEquals("applicationName", applicationName);
    }

    public AppSuggestionQuery suggestionTypeName(String suggestionTypeName) {
        return (AppSuggestionQuery) addEquals("suggestionTypeName", suggestionTypeName);
    }   
}
