/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.controllers;

import com.flowcentraltech.flowcentral.application.web.panels.applet.ManageEntityListSingleFormApplet;
import com.tcdng.unify.core.UnifyException;

/**
 * Manage entity list single form applet page bean.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ManageEntityListSingleFormAppletPageBean extends AbstractEntitySingleFormAppletPageBean<ManageEntityListSingleFormApplet> {

    public ManageEntityListSingleFormApplet getApplet() {
        return super.getApplet();
    }

    @Override
    public void setApplet(ManageEntityListSingleFormApplet applet) throws UnifyException {
        super.setApplet(applet);
    }

}
