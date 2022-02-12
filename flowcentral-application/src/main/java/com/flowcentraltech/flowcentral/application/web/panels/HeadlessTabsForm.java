/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.panels;

import com.flowcentraltech.flowcentral.application.business.AppletUtilities;
import com.flowcentraltech.flowcentral.application.web.widgets.TabSheet;

/**
 * Headless tabs form.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class HeadlessTabsForm {

    private final AppletUtilities au;
    
    private final TabSheet headlessTabSheet;

    public HeadlessTabsForm(AppletUtilities au, TabSheet headlessTabSheet) {
        this.au = au;
        this.headlessTabSheet = headlessTabSheet;
    }

    public AppletUtilities getAu() {
        return au;
    }

    public TabSheet getHeadlessTabSheet() {
        return headlessTabSheet;
    }
    
    public EntitySearch getCurrentEntitySearch() {
        return (EntitySearch) getHeadlessTabSheet().getCurrentItem().getValObject();
    }
    
    public String getCurrentAppletName() {
        return getHeadlessTabSheet().getCurrentItem().getAppletName();
    }
}
