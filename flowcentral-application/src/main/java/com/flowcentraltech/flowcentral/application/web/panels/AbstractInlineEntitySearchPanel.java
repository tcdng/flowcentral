/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.panels;

import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.web.ui.widget.panel.AbstractStandalonePanel;

/**
 * Convenient abstract base class for in-line entity search panel.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractInlineEntitySearchPanel extends AbstractStandalonePanel {

    @Override
    public void onPageConstruct() throws UnifyException {
        super.onPageConstruct();
        setVisible("entitySearchPanel.reportBtn", false);
    }

    @Override
    public void switchState() throws UnifyException {
        super.switchState();

        EntitySearch entitySearch = getValue(EntitySearch.class);
        setRequestAttribute(getEditActionKey(), entitySearch.getEditAction());
    }

    protected abstract String getEditActionKey();
}
