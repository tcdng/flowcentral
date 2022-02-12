/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.studio.web.controllers;

import com.flowcentraltech.flowcentral.application.web.controllers.AbstractEntityFormAppletPageBean;
import com.flowcentraltech.flowcentral.studio.web.panels.applet.StudioAppComponentApplet;

/**
 * Studio application component applet page bean.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class StudioAppComponentAppletPageBean extends AbstractEntityFormAppletPageBean<StudioAppComponentApplet> {

    public String getInstTitle() {
        return getApplet().getInstTitle();
    }

    public String getTypeTitle() {
        return getApplet().getTypeTitle();
    }

}
