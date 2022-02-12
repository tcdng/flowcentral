/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.controllers;

import com.flowcentraltech.flowcentral.application.web.panels.applet.AbstractEntityFormApplet;
import com.tcdng.unify.core.UnifyException;

/**
 * Abstract base class for entity form applet page beans.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractEntityFormAppletPageBean<T extends AbstractEntityFormApplet>
        extends AbstractAppletPageBean<T> {

    public T getApplet() {
        return super.getApplet();
    }

    @Override
    public void setApplet(T applet) throws UnifyException {
        super.setApplet(applet);
    }

}
