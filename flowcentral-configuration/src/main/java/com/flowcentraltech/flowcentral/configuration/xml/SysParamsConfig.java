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
 * System parameters configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class SysParamsConfig {

    private List<SysParamConfig> sysParamList;

    public List<SysParamConfig> getSysParamList() {
        return sysParamList;
    }

    @XmlElement(name = "sysParameter", required = true)
    public void setSysParamList(List<SysParamConfig> sysParamList) {
        this.sysParamList = sysParamList;
    }

    @Override
    public String toString() {
        return "SysParamsConfig [sysParamList=" + sysParamList + "]";
    }
}
