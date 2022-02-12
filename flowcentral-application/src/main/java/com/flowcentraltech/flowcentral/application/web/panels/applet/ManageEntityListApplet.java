/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.panels.applet;

import com.flowcentraltech.flowcentral.application.business.AppletUtilities;
import com.flowcentraltech.flowcentral.application.constants.AppletPropertyConstants;
import com.flowcentraltech.flowcentral.application.data.AppletDef;
import com.flowcentraltech.flowcentral.application.data.FilterDef;
import com.flowcentraltech.flowcentral.application.web.data.FormContext;
import com.flowcentraltech.flowcentral.application.web.panels.EntitySearch;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.web.ui.widget.EventHandler;

/**
 * Manage entity list applet object.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ManageEntityListApplet extends AbstractEntityFormApplet {

    public ManageEntityListApplet(AppletUtilities au, String pathVariable, EventHandler[] formSwitchOnChangeHandlers,
            EventHandler[] assnSwitchOnChangeHandlers) throws UnifyException {
        super(au, pathVariable, formSwitchOnChangeHandlers, assnSwitchOnChangeHandlers);
        currFormAppletDef = getRootAppletDef();
        entitySearch = au.constructEntitySearch(new FormContext(getCtx()), this, null,
                getRootAppletDef().getDescription(), currFormAppletDef, null, EntitySearch.ENABLE_ALL);
        if (isRootAppletPropWithValue(AppletPropertyConstants.BASE_RESTRICTION)) {
            entitySearch.setBaseFilter(new FilterDef(getRootAppletFilterDef(AppletPropertyConstants.BASE_RESTRICTION)),
                    au.getSpecialParamProvider());
        }

        navBackToSearch();
    }

    @Override
    protected AppletDef getAlternateFormAppletDef() throws UnifyException {
        return null;
    }
}
