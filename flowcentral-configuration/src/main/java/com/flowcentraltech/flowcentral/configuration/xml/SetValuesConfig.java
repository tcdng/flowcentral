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
 * Set values configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class SetValuesConfig {

    private String name;

    private String description;

    private List<SetValueConfig> setValueList;

    public String getName() {
        return name;
    }

    @XmlAttribute
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    @XmlAttribute
    public void setDescription(String description) {
        this.description = description;
    }

    public List<SetValueConfig> getSetValueList() {
        return setValueList;
    }

    @XmlElement(name = "setValue", required = true)
    public void setSetValueList(List<SetValueConfig> setValueList) {
        this.setValueList = setValueList;
    }

}
