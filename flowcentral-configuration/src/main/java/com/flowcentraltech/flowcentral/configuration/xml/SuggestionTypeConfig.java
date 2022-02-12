/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Suggestion type configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class SuggestionTypeConfig extends BaseNameConfig {

    private String parent;

    public String getParent() {
        return parent;
    }

    @XmlAttribute
    public void setParent(String parent) {
        this.parent = parent;
    }
        
}
