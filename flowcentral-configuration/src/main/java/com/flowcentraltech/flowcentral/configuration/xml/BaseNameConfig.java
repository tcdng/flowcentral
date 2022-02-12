/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Convenient abstract base class for named configurations.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class BaseNameConfig {

    private String name;

    private String description;

    private String label;

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

    public String getLabel() {
        return label;
    }

    @XmlAttribute(required = true)
    public void setLabel(String label) {
        this.label = label;
    }
}
