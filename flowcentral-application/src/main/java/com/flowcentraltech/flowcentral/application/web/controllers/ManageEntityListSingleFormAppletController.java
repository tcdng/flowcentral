/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.controllers;

import com.flowcentraltech.flowcentral.application.web.panels.applet.ManageEntityListSingleFormApplet;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.UplBinding;
import com.tcdng.unify.web.constant.ReadOnly;
import com.tcdng.unify.web.constant.ResetOnWrite;
import com.tcdng.unify.web.constant.Secured;

/**
 * Manage entity list single form applet controller.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("/manageentitylistsingleformapplet")
@UplBinding("web/application/upl/manageentitylistsingleformappletpage.upl")
public class ManageEntityListSingleFormAppletController extends
        AbstractEntitySingleFormAppletController<ManageEntityListSingleFormApplet, ManageEntityListSingleFormAppletPageBean> {

    public ManageEntityListSingleFormAppletController() {
        super(ManageEntityListSingleFormAppletPageBean.class, Secured.TRUE, ReadOnly.FALSE, ResetOnWrite.FALSE);
    }

    @Override
    protected void onOpenPage() throws UnifyException {
        super.onOpenPage();
        ManageEntityListSingleFormAppletPageBean pageBean = getPageBean();
        if (pageBean.getApplet() == null) {
            ManageEntityListSingleFormApplet applet = new ManageEntityListSingleFormApplet(getAu(), getPathVariable());
            pageBean.setApplet(applet);
            if (pageBean.getAltCaption() == null) {
                setPageTitle(applet);
            }
        }
    }

}
