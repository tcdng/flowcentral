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
 * References configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class RefsConfig {

    private List<RefConfig> refList;

    public List<RefConfig> getRefList() {
        return refList;
    }

    @XmlElement(name = "reference")
    public void setRefList(List<RefConfig> refList) {
        this.refList = refList;
    }

}
