/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.workflow.web.controllers;

import com.flowcentraltech.flowcentral.application.web.controllers.AbstractEntityFormAppletPageBean;
import com.flowcentraltech.flowcentral.workflow.web.panels.applet.ReviewWorkItemsApplet;
import com.tcdng.unify.core.UnifyException;

/**
 * Review work items applet page bean.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ReviewWorkItemsAppletPageBean extends AbstractEntityFormAppletPageBean<ReviewWorkItemsApplet> {

    public ReviewWorkItemsApplet getApplet() {
        return super.getApplet();
    }

    @Override
    public void setApplet(ReviewWorkItemsApplet applet) throws UnifyException {
        super.setApplet(applet);
    }
}
