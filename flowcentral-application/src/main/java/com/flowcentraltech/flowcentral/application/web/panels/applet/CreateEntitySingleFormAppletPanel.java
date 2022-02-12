/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.panels.applet;

import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.UplBinding;

/**
 * Create entity single form applet panel.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-createentitysingleformappletpanel")
@UplBinding("web/application/upl/createentitysingleformappletpanel.upl")
public class CreateEntitySingleFormAppletPanel extends AbstractEntitySingleFormAppletPanel {

    @Override
    public void switchState() throws UnifyException {
        super.switchState();

        CreateEntitySingleFormApplet applet = getCreateEntityApplet();
        applet.ensureRootAppletStruct();

        final AbstractEntitySingleFormApplet.ViewMode viewMode = applet.getMode();

        switch (viewMode) {
            case MAINTAIN_FORM_SCROLL:
            case MAINTAIN_PRIMARY_FORM_NO_SCROLL:
            case MAINTAIN_FORM:
            case NEW_FORM:
            case NEW_PRIMARY_FORM:
                break;
            case SEARCH:
            default:
                break;
        }
    }

    protected CreateEntitySingleFormApplet getCreateEntityApplet() throws UnifyException {
        return getValue(CreateEntitySingleFormApplet.class);
    }
}
