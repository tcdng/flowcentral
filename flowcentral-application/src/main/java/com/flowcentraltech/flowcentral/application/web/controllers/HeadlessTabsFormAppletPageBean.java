/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.controllers;

import com.flowcentraltech.flowcentral.application.web.panels.applet.HeadlessTabsFormApplet;
import com.tcdng.unify.core.UnifyException;

/**
 * Headless tabs form applet page bean.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class HeadlessTabsFormAppletPageBean extends AbstractEntityFormAppletPageBean<HeadlessTabsFormApplet> {

    public HeadlessTabsFormApplet getApplet() {
        return super.getApplet();
    }

    @Override
    public void setApplet(HeadlessTabsFormApplet applet) throws UnifyException {
        super.setApplet(applet);
    }

}
