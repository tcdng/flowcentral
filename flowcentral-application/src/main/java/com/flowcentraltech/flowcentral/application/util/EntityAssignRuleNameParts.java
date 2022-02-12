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
public class EntityAssignRuleNameParts {

    private final String entityLongName;

    private final String baseFieldName;

    private final String assignFieldName;

    private final String descField;

    public EntityAssignRuleNameParts(String entityLongName, String baseFieldName, String assignFieldName,
            String descField) {
        this.entityLongName = entityLongName;
        this.baseFieldName = baseFieldName;
        this.assignFieldName = assignFieldName;
        this.descField = descField;
    }

    public String getEntityLongName() {
        return entityLongName;
    }

    public String getBaseFieldName() {
        return baseFieldName;
    }

    public String getAssignFieldName() {
        return assignFieldName;
    }

    public String getDescField() {
        return descField;
    }

    public boolean isWithDescField() {
        return descField != null;
    }
}
