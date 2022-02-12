/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.util;

/**
 * Privilege name parts.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class PrivilegeNameParts {

    private String type;

    private String entityName;

    public PrivilegeNameParts(String type, String entityName) {
        this.type = type;
        this.entityName = entityName;
    }

    public String getType() {
        return type;
    }

    public String getEntityName() {
        return entityName;
    }

    @Override
    public String toString() {
        return "PrivilegeNameParts [type=" + type + ", entityName=" + entityName + "]";
    }

}
