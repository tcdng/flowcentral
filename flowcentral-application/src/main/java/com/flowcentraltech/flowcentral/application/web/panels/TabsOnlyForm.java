/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.panels;

import com.flowcentraltech.flowcentral.application.web.data.FormContext;
import com.flowcentraltech.flowcentral.application.web.widgets.BreadCrumbs;
import com.flowcentraltech.flowcentral.application.web.widgets.TabSheet;

/**
 * Tabs only form.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class TabsOnlyForm extends AbstractForm {

    private TabSheet tabSheet;

    public TabsOnlyForm(FormContext ctx, BreadCrumbs breadCrumbs) {
        super(ctx, breadCrumbs);
    }

    public void setTabSheet(TabSheet tabSheet) {
        this.tabSheet = tabSheet;
    }

    public TabSheet getTabSheet() {
        return tabSheet;
    }

}
