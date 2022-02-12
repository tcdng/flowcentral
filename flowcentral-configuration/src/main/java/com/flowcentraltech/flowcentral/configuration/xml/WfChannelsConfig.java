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
 * Workflow channels configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class WfChannelsConfig {

    private List<WfChannelConfig> channelList;

    public List<WfChannelConfig> getChannelList() {
        return channelList;
    }

    @XmlElement(name = "workflow-channel")
    public void setChannelList(List<WfChannelConfig> channelList) {
        this.channelList = channelList;
    }

}
