/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Related list configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class RelatedListConfig extends BaseNameConfig {

    private String applet;

    private String editAction;

    public String getApplet() {
        return applet;
    }

    @XmlAttribute(required = true)
    public void setApplet(String applet) {
        this.applet = applet;
    }

    public String getEditAction() {
        return editAction;
    }

    @XmlAttribute
    public void setEditAction(String editAction) {
        this.editAction = editAction;
    }

}
