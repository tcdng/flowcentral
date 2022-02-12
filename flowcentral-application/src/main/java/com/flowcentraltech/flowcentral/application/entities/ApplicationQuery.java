/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseConfigNamedEntityQuery;

/**
 * Application query object.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ApplicationQuery extends BaseConfigNamedEntityQuery<Application> {

    public ApplicationQuery() {
        super(Application.class);
    }

    public ApplicationQuery moduleId(Long moduleId) {
        return (ApplicationQuery) addEquals("moduleId", moduleId);
    }

    public ApplicationQuery moduleName(String moduleName) {
        return (ApplicationQuery) addEquals("moduleName", moduleName);
    }

    public ApplicationQuery isMenuAccess() {
        return (ApplicationQuery) addEquals("menuAccess", true);
    }

}
