/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.tcdng.unify.core.util.xml.adapter.CDataXmlAdapter;

/**
 * Entity expression configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class EntityExpressionConfig {

    private String name;

    private String description;

    private String expression;

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

    public String getExpression() {
        return expression;
    }

    @XmlJavaTypeAdapter(CDataXmlAdapter.class)
    @XmlAttribute(required = true)
    public void setExpression(String expression) {
        this.expression = expression;
    }

}
