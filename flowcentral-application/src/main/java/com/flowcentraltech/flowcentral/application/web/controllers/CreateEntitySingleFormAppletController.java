/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.controllers;

import com.flowcentraltech.flowcentral.application.web.panels.applet.CreateEntitySingleFormApplet;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.UplBinding;
import com.tcdng.unify.web.constant.ReadOnly;
import com.tcdng.unify.web.constant.ResetOnWrite;
import com.tcdng.unify.web.constant.Secured;

/**
 * Create entity single form applet controller.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("/createentitysingleformapplet")
@UplBinding("web/application/upl/createentitysingleformappletpage.upl")
public class CreateEntitySingleFormAppletController extends
        AbstractEntitySingleFormAppletController<CreateEntitySingleFormApplet, CreateEntitySingleFormAppletPageBean> {

    public CreateEntitySingleFormAppletController() {
        super(CreateEntitySingleFormAppletPageBean.class, Secured.TRUE, ReadOnly.FALSE, ResetOnWrite.FALSE);
    }

    @Override
    protected void onOpenPage() throws UnifyException {
        super.onOpenPage();

        CreateEntitySingleFormAppletPageBean pageBean = getPageBean();
        if (pageBean.getApplet() == null) {
            CreateEntitySingleFormApplet applet = new CreateEntitySingleFormApplet(getAu(), getPathVariable());
            pageBean.setApplet(applet);
            if (pageBean.getAltCaption() == null) {
                setPageTitle(applet);
            }
        }
    }

}
