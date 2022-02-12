/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.data;

/**
 * Entity instance name parts.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class EntityInstNameParts {

    private String entityName;

    private Long id;

    public EntityInstNameParts(String entityName, Long id) {
        this.entityName = entityName;
        this.id = id;
    }

    public String getEntityName() {
        return entityName;
    }

    public Long getInstId() {
        return id;
    }

}
