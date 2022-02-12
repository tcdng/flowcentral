/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Entity unique constraint configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class EntityUniqueConstraintConfig {

    private String name;

    private String description;

    private String fieldList;

    public String getFieldList() {
        return fieldList;
    }

    @XmlAttribute(required = true)
    public void setFieldList(String fieldList) {
        this.fieldList = fieldList;
    }

    public String getName() {
        return name;
    }

    @XmlAttribute(required = true)
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    @XmlAttribute(required = true)
    public void setDescription(String description) {
        this.description = description;
    }

}
