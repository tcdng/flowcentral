/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.panels;

import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.UplBinding;

/**
 * Child list panel.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-childlistpanel")
@UplBinding("web/application/upl/childlistpanel.upl")
public class ChildListPanel extends AbstractInlineEntitySearchPanel {

    @Override
    protected String getEditActionKey() {
        return "childlist.edit.actionpath";
    }

}
