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
 * Workflow alerts configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class WfAlertsConfig {

    private List<WfAlertConfig> wfAlertConfigList;

    public List<WfAlertConfig> getWfAlertConfigList() {
        return wfAlertConfigList;
    }

    @XmlElement(name = "alert", required = true)
    public void setWfAlertConfigList(List<WfAlertConfig> wfAlertConfigList) {
        this.wfAlertConfigList = wfAlertConfigList;
    }

}
