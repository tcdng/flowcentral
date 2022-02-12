/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * Property list configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class PropertyListConfig extends BaseNameConfig {

    private List<PropertySetConfig> propSetList;

    public List<PropertySetConfig> getPropSetList() {
        return propSetList;
    }

    @XmlElement(name = "propertySet", required = true)
    public void setPropSetList(List<PropertySetConfig> propSetList) {
        this.propSetList = propSetList;
    }

}
