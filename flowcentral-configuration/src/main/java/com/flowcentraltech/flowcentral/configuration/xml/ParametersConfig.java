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
 * Parameters configuration.
 * 
 * @author Lateef Ojulari
 * @version 1.0
 */
public class ParametersConfig {

    private List<ParameterConfig> parameterList;

    public List<ParameterConfig> getParameterList() {
        return parameterList;
    }

    @XmlElement(name = "parameter", required = true)
    public void setParameterList(List<ParameterConfig> parameterList) {
        this.parameterList = parameterList;
    }
}
