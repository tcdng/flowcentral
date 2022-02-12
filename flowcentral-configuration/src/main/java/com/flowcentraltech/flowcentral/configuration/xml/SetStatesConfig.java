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
 * Set states configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class SetStatesConfig {

    private List<SetStateConfig> setStateList;

    public List<SetStateConfig> getSetStateList() {
        return setStateList;
    }

    @XmlElement(name = "setState", required = true)
    public void setSetStateList(List<SetStateConfig> setStateList) {
        this.setStateList = setStateList;
    }

}
