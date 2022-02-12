/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.controllers;

import com.flowcentraltech.flowcentral.application.web.panels.applet.CreateEntitySingleFormApplet;
import com.tcdng.unify.core.UnifyException;

/**
 * Create entity single form applet page bean.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class CreateEntitySingleFormAppletPageBean
        extends AbstractEntitySingleFormAppletPageBean<CreateEntitySingleFormApplet> {

    public CreateEntitySingleFormApplet getApplet() {
        return super.getApplet();
    }

    @Override
    public void setApplet(CreateEntitySingleFormApplet applet) throws UnifyException {
        super.setApplet(applet);
    }

}
