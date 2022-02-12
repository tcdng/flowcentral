/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.controllers;

import com.flowcentraltech.flowcentral.application.business.AppletUtilities;
import com.flowcentraltech.flowcentral.application.web.panels.applet.AbstractApplet;
import com.flowcentraltech.flowcentral.common.web.controllers.AbstractFlowCentralPageController;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.web.constant.ReadOnly;
import com.tcdng.unify.web.constant.ResetOnWrite;
import com.tcdng.unify.web.constant.Secured;

/**
 * Convenient abstract base class for applet controllers.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractAppletController<T extends AbstractAppletPageBean<? extends AbstractApplet>>
        extends AbstractFlowCentralPageController<T> {

    @Configurable
    private AppletUtilities appletUtilities;

    public AbstractAppletController(Class<T> pageBeanClass, Secured secured, ReadOnly readOnly,
            ResetOnWrite resetOnWrite) {
        super(pageBeanClass, secured, readOnly, resetOnWrite);
    }

    public void setAppletUtilities(AppletUtilities appletUtilities) {
        this.appletUtilities = appletUtilities;
    }

    protected AppletUtilities getAu() {
        return appletUtilities;
    }

    protected void setPageTitle(AbstractApplet applet) throws UnifyException {
        if (applet != null) {
            setPageTitle(applet.getAppletDescription());
        }
    }
}
