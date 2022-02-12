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
 * Workflow routings configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class WfRoutingsConfig {

    private List<WfRoutingConfig> wfRoutingConfigList;

    public List<WfRoutingConfig> getWfRoutingConfigList() {
        return wfRoutingConfigList;
    }

    @XmlElement(name = "routing", required = true)
    public void setWfRoutingConfigList(List<WfRoutingConfig> wfRoutingConfigList) {
        this.wfRoutingConfigList = wfRoutingConfigList;
    }

}
