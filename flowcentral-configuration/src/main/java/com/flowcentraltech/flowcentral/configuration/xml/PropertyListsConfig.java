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
 * Property lists configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class PropertyListsConfig {

    private List<PropertyListConfig> propertyConfigList;

    public List<PropertyListConfig> getPropertyConfigList() {
        return propertyConfigList;
    }

    @XmlElement(name = "propertyList")
    public void setPropertyConfigList(List<PropertyListConfig> propertyConfigList) {
        this.propertyConfigList = propertyConfigList;
    }

}
