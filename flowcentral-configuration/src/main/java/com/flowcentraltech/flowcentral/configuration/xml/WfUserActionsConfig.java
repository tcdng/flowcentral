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
 * Workflow user actions configuration.
 * 
 * @author Lateef Ojulari
 * @version 1.0
 */
public class WfUserActionsConfig {

    private List<WfUserActionConfig> wfUserActionConfigList;

    public List<WfUserActionConfig> getWfUserActionConfigList() {
        return wfUserActionConfigList;
    }

    @XmlElement(name = "userAction", required = true)
    public void setWfUserActionConfigList(List<WfUserActionConfig> wfUserActionConfigList) {
        this.wfUserActionConfigList = wfUserActionConfigList;
    }

}
