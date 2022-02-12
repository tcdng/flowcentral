/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.panels.applet;

import com.flowcentraltech.flowcentral.application.business.AppletUtilities;
import com.flowcentraltech.flowcentral.application.data.AppletDef;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.web.ui.widget.EventHandler;

/**
 * Headless tabs form applet object.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class HeadlessTabsFormApplet extends AbstractEntityFormApplet {

    public HeadlessTabsFormApplet(AppletUtilities au, String pathVariable, EventHandler[] formSwitchOnChangeHandlers,
            EventHandler[] assnSwitchOnChangeHandlers) throws UnifyException {
        super(au, pathVariable, formSwitchOnChangeHandlers, assnSwitchOnChangeHandlers);
        currFormAppletDef = getRootAppletDef();
        headlessForm = au.constructHeadlessTabsForm(getCtx(), this, getRootAppletDef().getDescription(),
                currFormAppletDef);

        navBackToHeadless();
    }

    @Override
    protected AppletDef getAlternateFormAppletDef() throws UnifyException {
        return null;
    }
}
