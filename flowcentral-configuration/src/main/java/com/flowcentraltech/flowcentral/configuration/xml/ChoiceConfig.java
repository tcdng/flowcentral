/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Choice configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ChoiceConfig {

    private String name;

    private String val;

    public String getName() {
        return name;
    }

    @XmlAttribute(required = true)
    public void setName(String name) {
        this.name = name;
    }

    public String getVal() {
        return val;
    }

    @XmlAttribute(required = true)
    public void setVal(String val) {
        this.val = val;
    }

}
