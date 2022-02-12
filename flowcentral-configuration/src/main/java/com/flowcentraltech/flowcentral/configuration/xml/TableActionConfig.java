/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.configuration.xml;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Table action configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class TableActionConfig extends BaseNameConfig {

    private String policy;

    private int orderIndex;

    public String getPolicy() {
        return policy;
    }

    @XmlAttribute(required = true)
    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public int getOrderIndex() {
        return orderIndex;
    }

    @XmlAttribute
    public void setOrderIndex(int orderIndex) {
        this.orderIndex = orderIndex;
    }
}
