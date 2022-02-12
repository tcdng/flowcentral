/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.data;

import java.util.Collections;
import java.util.List;

/**
 * Unique constraint definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class UniqueConstraintDef {

    private String name;

    private String description;

    private List<String> fieldList;

    private boolean caseInsensitive;
    
    public UniqueConstraintDef(String name, String description, List<String> fieldList, boolean caseInsensitive) {
        this.name = name;
        this.description = description;
        this.fieldList = Collections.unmodifiableList(fieldList);
        this.caseInsensitive = caseInsensitive;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getFieldList() {
        return fieldList;
    }

    public boolean isSingleFieldConstraint(String fieldName) {
        return fieldList != null && fieldList.size() == 1 && fieldList.get(0).equals(fieldName);
    }
    
    public boolean isCaseInsensitive() {
        return caseInsensitive;
    }

    @Override
    public String toString() {
        return "UniqueConstraintDef [name=" + name + ", description=" + description + ", fieldList=" + fieldList
                + ", caseInsensitive=" + caseInsensitive + "]";
    }

}
