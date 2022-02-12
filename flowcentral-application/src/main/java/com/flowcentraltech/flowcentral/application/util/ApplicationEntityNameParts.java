/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.util;

/**
 * Application entity name parts.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ApplicationEntityNameParts {

    private String longName;

    private String applicationName;

    private String entityName;

    public ApplicationEntityNameParts(String longName, String applicationName, String entityName) {
        this.longName = longName;
        this.applicationName = applicationName;
        this.entityName = entityName;
    }

    public String getLongName() {
        return longName;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public String getEntityName() {
        return entityName;
    }

}
