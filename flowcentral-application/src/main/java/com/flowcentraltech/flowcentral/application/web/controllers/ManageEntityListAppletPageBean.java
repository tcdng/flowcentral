/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.controllers;

import com.flowcentraltech.flowcentral.application.web.panels.applet.ManageEntityListApplet;
import com.tcdng.unify.core.UnifyException;

/**
 * Manage entity list applet page bean.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ManageEntityListAppletPageBean extends AbstractEntityFormAppletPageBean<ManageEntityListApplet> {

    public ManageEntityListApplet getApplet() {
        return super.getApplet();
    }

    @Override
    public void setApplet(ManageEntityListApplet applet) throws UnifyException {
        super.setApplet(applet);
    }

}
