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
 * Applets configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppletsConfig {

    private List<AppletConfig> appletList;

    public List<AppletConfig> getAppletList() {
        return appletList;
    }

    @XmlElement(name = "applet")
    public void setAppletList(List<AppletConfig> appletList) {
        this.appletList = appletList;
    }

}
