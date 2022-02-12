/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.panels.applet;

import com.flowcentraltech.flowcentral.application.business.AppletUtilities;
import com.flowcentraltech.flowcentral.application.web.panels.AbstractForm.FormMode;
import com.tcdng.unify.core.UnifyException;

/**
 * Create entity single form applet object.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class CreateEntitySingleFormApplet extends AbstractEntitySingleFormApplet {

    public CreateEntitySingleFormApplet(AppletUtilities au, String pathVariable)
            throws UnifyException {
        super(au, pathVariable);
        form = constructNewForm(FormMode.CREATE);
        viewMode = ViewMode.NEW_PRIMARY_FORM;
    }
}
