/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.panels.applet;

import com.flowcentraltech.flowcentral.application.business.AppletUtilities;
import com.flowcentraltech.flowcentral.application.data.AppletDef;
import com.flowcentraltech.flowcentral.application.web.panels.AbstractForm.FormMode;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.web.ui.widget.EventHandler;

/**
 * Create entity applet object.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class CreateEntityApplet extends AbstractEntityFormApplet {

    public CreateEntityApplet(AppletUtilities au, String pathVariable, EventHandler[] formSwitchOnChangeHandlers,
            EventHandler[] assnSwitchOnChangeHandlers) throws UnifyException {
        super(au, pathVariable, formSwitchOnChangeHandlers, assnSwitchOnChangeHandlers);
        currFormAppletDef = getRootAppletDef();
        form = constructNewForm(FormMode.CREATE, null, false);
        viewMode = ViewMode.NEW_PRIMARY_FORM;
    }

    @Override
    protected AppletDef getAlternateFormAppletDef() throws UnifyException {
        return null;
    }
}
