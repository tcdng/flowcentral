/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.studio.web.controllers;

import com.flowcentraltech.flowcentral.application.web.controllers.AbstractEntityFormAppletPageBean;
import com.flowcentraltech.flowcentral.studio.web.panels.applet.StudioAppTableApplet;

/**
 * Studio table component applet page bean.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class StudioAppTableAppletPageBean extends AbstractEntityFormAppletPageBean<StudioAppTableApplet> {

    public String getInstTitle() {
        return getApplet().getInstTitle();
    }

    public String getTypeTitle() {
        return getApplet().getTypeTitle();
    }

}
