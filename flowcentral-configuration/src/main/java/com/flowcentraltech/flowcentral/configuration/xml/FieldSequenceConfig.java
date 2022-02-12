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
 * Field sequence configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class FieldSequenceConfig {

    private List<FieldSequenceEntryConfig> entryList;

    public FieldSequenceConfig(List<FieldSequenceEntryConfig> entryList) {
        this.entryList = entryList;
    }

    public FieldSequenceConfig() {

    }

    public List<FieldSequenceEntryConfig> getEntryList() {
        return entryList;
    }

    @XmlElement(name = "entry", required = true)
    public void setEntryList(List<FieldSequenceEntryConfig> entryList) {
        this.entryList = entryList;
    }

}
