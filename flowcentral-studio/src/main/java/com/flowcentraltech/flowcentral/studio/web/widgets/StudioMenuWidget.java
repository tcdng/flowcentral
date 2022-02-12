/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.studio.web.widgets;

import com.flowcentraltech.flowcentral.studio.constants.StudioAppComponentType;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.web.ui.widget.AbstractPanel;
import com.tcdng.unify.web.ui.widget.Control;

/**
 * Studio menu widget.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-studiomenu")
public class StudioMenuWidget extends AbstractPanel {

    public static final String WORK_MENU_CATEGORIES = "menuCats";

    public static final String WORK_MENU_ITEMS = "menuItems";

    private Control currentSelCtrl;

    private StudioAppComponentType currentSel;

    @Override
    public void onPageConstruct() throws UnifyException {
        super.onPageConstruct();
        currentSelCtrl = (Control) addInternalWidget("!ui-hidden binding:currentSel");
    }

    public StudioAppComponentType getCurrentSel() {
        return currentSel;
    }

    public void setCurrentSel(StudioAppComponentType currentSel) {
        this.currentSel = currentSel;
    }

    public Control getCurrentSelCtrl() {
        return currentSelCtrl;
    }

    public String getCategoryId() throws UnifyException {
        return getPrefixedId("cat_");
    }
}
