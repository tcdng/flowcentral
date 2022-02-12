/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.panels;

import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.UplBinding;
import com.tcdng.unify.web.ui.widget.panel.DialogRackCrudPanel;

/**
 * Convenient abstract base class for studio dialog CRUD panels.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@UplBinding("web/studio/upl/studiodialogcrudpanel.upl")
public abstract class AbstractStudioDialogCrudPanel extends DialogRackCrudPanel {

    @Override
    public void onPageConstruct() throws UnifyException {
        super.onPageConstruct();
        setVisible("applyBtn", false);
    }
}
