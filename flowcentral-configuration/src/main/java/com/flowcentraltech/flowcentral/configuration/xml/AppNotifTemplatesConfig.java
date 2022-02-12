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
 * Application notification templates configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppNotifTemplatesConfig {

    private List<AppNotifTemplateConfig> notifTemplateList;

    public List<AppNotifTemplateConfig> getNotifTemplateList() {
        return notifTemplateList;
    }

    @XmlElement(name = "notifTemplate", required = true)
    public void setNotifTemplateList(List<AppNotifTemplateConfig> notifTemplateList) {
        this.notifTemplateList = notifTemplateList;
    }

}
