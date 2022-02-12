/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.controllers;

import com.flowcentraltech.flowcentral.application.web.panels.applet.AbstractApplet;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.web.ui.AbstractPageBean;

/**
 * Convenient abstract base class for applet page bean.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractAppletPageBean<T extends AbstractApplet> extends AbstractPageBean {

    private T applet;

    private String altCaption;

    private String altSubCaption;

    public T getApplet() {
        return applet;
    }

    public void setApplet(T applet) throws UnifyException{
        this.applet = applet;
        altCaption = applet.getPageAltCaption();
        altSubCaption = applet.getPageAltSubCaption();
    }

    public String getAltCaption() {
        return altCaption;
    }

    public String getAltSubCaption() {
        return altSubCaption;
    }

}
