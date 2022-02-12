/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.controllers;

import com.flowcentraltech.flowcentral.application.web.panels.applet.DataImportApplet;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.UplBinding;
import com.tcdng.unify.web.constant.ReadOnly;
import com.tcdng.unify.web.constant.ResetOnWrite;
import com.tcdng.unify.web.constant.Secured;

/**
 * Data import applet controller.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("/dataimportapplet")
@UplBinding("web/application/upl/dataimportappletpage.upl")
public class DataImportAppletController extends AbstractAppletController<DataImportPageBean> {

    public DataImportAppletController() {
        super(DataImportPageBean.class, Secured.TRUE, ReadOnly.FALSE, ResetOnWrite.FALSE);
    }

    @Override
    protected void onOpenPage() throws UnifyException {
        super.onOpenPage();

        DataImportPageBean pageBean = getPageBean();
        if (pageBean.getApplet() == null) {
            DataImportApplet applet = new DataImportApplet(getAu(), getPathVariable());
            pageBean.setApplet(applet);
            setPageTitle(applet);
        }
    }

}
