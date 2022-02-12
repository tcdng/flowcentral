/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.controllers;

import com.flowcentraltech.flowcentral.application.web.panels.applet.AbstractEntitySingleFormApplet;
import com.tcdng.unify.web.annotation.ResultMapping;
import com.tcdng.unify.web.annotation.ResultMappings;
import com.tcdng.unify.web.constant.ReadOnly;
import com.tcdng.unify.web.constant.ResetOnWrite;
import com.tcdng.unify.web.constant.Secured;

/**
 * Abstract base class for entity form applet controllers.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@ResultMappings({ @ResultMapping(name = "refreshapplet",
        response = { "!hidepopupresponse", "!refreshpanelresponse panels:$l{appletPanel}" }) })
public abstract class AbstractEntitySingleFormAppletController<T extends AbstractEntitySingleFormApplet, U extends AbstractEntitySingleFormAppletPageBean<T>>
        extends AbstractAppletController<U> {

    public AbstractEntitySingleFormAppletController(Class<U> pageBeanClass, Secured secured, ReadOnly readOnly,
            ResetOnWrite resetOnWrite) {
        super(pageBeanClass, secured, readOnly, resetOnWrite);
    }

}
