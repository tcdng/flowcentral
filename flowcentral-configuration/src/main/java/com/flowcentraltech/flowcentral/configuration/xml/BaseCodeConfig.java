/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Convenient abstract base class for code configurations.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class BaseCodeConfig {

    private String code;

    private String description;

    public String getCode() {
        return code;
    }

    @XmlAttribute(required = true)
    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    @XmlAttribute(required = true)
    public void setDescription(String description) {
        this.description = description;
    }
}
