/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.controllers;

import com.flowcentraltech.flowcentral.application.web.panels.applet.CreateEntityApplet;
import com.tcdng.unify.core.UnifyException;

/**
 * Create entity applet page bean.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class CreateEntityAppletPageBean extends AbstractEntityFormAppletPageBean<CreateEntityApplet> {

    public CreateEntityApplet getApplet() {
        return super.getApplet();
    }

    @Override
    public void setApplet(CreateEntityApplet applet) throws UnifyException {
        super.setApplet(applet);
    }

}
