/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.panels;

import com.flowcentraltech.flowcentral.application.business.AppletUtilities;
import com.flowcentraltech.flowcentral.application.web.widgets.BreadCrumbs;

/**
 * Convenient abstract base class for studio editor pages.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractStudioEditorPage {

    private final AppletUtilities au;

    private final BreadCrumbs breadCrumbs;

    private String displayItemCounter;

    private String displayItemCounterClass;

    public AbstractStudioEditorPage(AppletUtilities au, BreadCrumbs breadCrumbs) {
        this.au = au;
        this.breadCrumbs = breadCrumbs;
    }

    public final String getMainTitle() {
        return breadCrumbs.getLastBreadCrumb().getTitle();
    }

    public final String getSubTitle() {
        return breadCrumbs.getLastBreadCrumb().getSubTitle();
    }

    public final BreadCrumbs getBreadCrumbs() {
        return breadCrumbs;
    }

    public final AppletUtilities getAu() {
        return au;
    }

    public final String getDisplayItemCounter() {
        return displayItemCounter;
    }

    public final void setDisplayItemCounter(String displayItemCounter) {
        this.displayItemCounter = displayItemCounter;
    }

    public final String getDisplayItemCounterClass() {
        return displayItemCounterClass;
    }

    public final void setDisplayItemCounterClass(String displayItemCounterClass) {
        this.displayItemCounterClass = displayItemCounterClass;
    }

}
