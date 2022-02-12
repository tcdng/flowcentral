/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Property set configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class PropertySetConfig {

    private String label;

    private List<PropertyListPropConfig> propList;

    public String getLabel() {
        return label;
    }

    @XmlAttribute(required = true)
    public void setLabel(String label) {
        this.label = label;
    }

    public List<PropertyListPropConfig> getPropList() {
        return propList;
    }

    @XmlElement(name = "property", required = true)
    public void setPropList(List<PropertyListPropConfig> propList) {
        this.propList = propList;
    }

}
