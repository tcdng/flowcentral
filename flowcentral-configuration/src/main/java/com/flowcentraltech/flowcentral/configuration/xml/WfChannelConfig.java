/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.configuration.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.flowcentraltech.flowcentral.configuration.constants.ChannelDirectionType;
import com.flowcentraltech.flowcentral.configuration.xml.adapter.ChannelDirectionTypeXmlAdapter;

/**
 * Workflow channel configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class WfChannelConfig extends BaseNameConfig {

    private ChannelDirectionType direction;

    private String entity;

    private String destination;

    private String rule;

    public ChannelDirectionType getDirection() {
        return direction;
    }

    @XmlJavaTypeAdapter(ChannelDirectionTypeXmlAdapter.class)
    @XmlAttribute(name = "direction", required = true)
    public void setDirection(ChannelDirectionType direction) {
        this.direction = direction;
    }

    public String getEntity() {
        return entity;
    }

    @XmlAttribute(required = true)
    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getDestination() {
        return destination;
    }

    @XmlAttribute(required = true)
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getRule() {
        return rule;
    }

    @XmlAttribute
    public void setRule(String rule) {
        this.rule = rule;
    }

}
