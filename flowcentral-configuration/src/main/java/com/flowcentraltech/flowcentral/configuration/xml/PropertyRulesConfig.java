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
 * Property rules configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class PropertyRulesConfig {

    private List<PropertyRuleConfig> propertyRuleConfigList;

    public List<PropertyRuleConfig> getPropertyRuleConfigList() {
        return propertyRuleConfigList;
    }

    @XmlElement(name = "propertyRule")
    public void setPropertyRuleConfigList(List<PropertyRuleConfig> propertyRuleConfigList) {
        this.propertyRuleConfigList = propertyRuleConfigList;
    }

}
