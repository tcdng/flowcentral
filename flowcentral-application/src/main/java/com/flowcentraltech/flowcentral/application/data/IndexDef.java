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
 * Index definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class IndexDef {

    private String name;

    private String description;

    private List<String> fieldList;

    public IndexDef(String name, String description, List<String> fieldList) {
        this.name = name;
        this.description = description;
        this.fieldList = Collections.unmodifiableList(fieldList);
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

    @Override
    public String toString() {
        return "IndexDef [fieldList=" + fieldList + "]";
    }

}
