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
 * Headless tabs form applet panel.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-headlesstabsformappletpanel")
@UplBinding("web/application/upl/headlesstabsformappletpanel.upl")
public class HeadlessTabsFormAppletPanel extends AbstractEntityFormAppletPanel {

    @Override
    public void switchState() throws UnifyException {
        super.switchState();

        final HeadlessTabsFormApplet applet = getHeadlessTabsFormApplet();
        applet.ensureCurrentAppletStruct();

        final AbstractEntityFormApplet.ViewMode viewMode = applet.getMode();
        switch (viewMode) {
            case ASSIGNMENT_PAGE:
            case PROPERTYLIST_PAGE:
            case LISTING_FORM:
            case MAINTAIN_FORM_SCROLL:
            case MAINTAIN_PRIMARY_FORM_NO_SCROLL:
            case MAINTAIN_CHILDLIST_FORM_NO_SCROLL:
            case MAINTAIN_RELATEDLIST_FORM_NO_SCROLL:
            case MAINTAIN_HEADLESSLIST_FORM_NO_SCROLL:
            case MAINTAIN_FORM:
            case MAINTAIN_CHILDLIST_FORM:
            case MAINTAIN_RELATEDLIST_FORM:
            case MAINTAIN_HEADLESSLIST_FORM:
            case NEW_FORM:
            case NEW_PRIMARY_FORM:
            case NEW_CHILD_FORM:
            case NEW_CHILDLIST_FORM:
            case NEW_RELATEDLIST_FORM:
            case NEW_HEADLESSLIST_FORM:
            case SEARCH:
                break;
            case HEADLESS_TAB:
                switchContent("headlessTabsFormPanel");
            default:
                break;
        }
    }

    protected HeadlessTabsFormApplet getHeadlessTabsFormApplet() throws UnifyException {
        return getValue(HeadlessTabsFormApplet.class);
    }
}
