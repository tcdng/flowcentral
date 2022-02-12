/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.panels.applet;

import com.flowcentraltech.flowcentral.application.business.AppletUtilities;
import com.flowcentraltech.flowcentral.application.constants.AppletPropertyConstants;
import com.flowcentraltech.flowcentral.application.data.FilterDef;
import com.flowcentraltech.flowcentral.application.web.data.FormContext;
import com.flowcentraltech.flowcentral.application.web.panels.EntitySearch;
import com.tcdng.unify.core.UnifyException;

/**
 * Manage entity list single form applet object.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ManageEntityListSingleFormApplet extends AbstractEntitySingleFormApplet {

    public ManageEntityListSingleFormApplet(AppletUtilities au, String pathVariable) throws UnifyException {
        super(au, pathVariable);
        entitySearch = au.constructEntitySearch(new FormContext(getCtx()), null, null,
                getRootAppletDef().getDescription(), getRootAppletDef(), null, EntitySearch.ENABLE_ALL);
        if (isRootAppletPropWithValue(AppletPropertyConstants.BASE_RESTRICTION)) {
            entitySearch.setBaseFilter(new FilterDef(getRootAppletFilterDef(AppletPropertyConstants.BASE_RESTRICTION)),
                    au.getSpecialParamProvider());
        }

        navBackToSearch();
    }

}
