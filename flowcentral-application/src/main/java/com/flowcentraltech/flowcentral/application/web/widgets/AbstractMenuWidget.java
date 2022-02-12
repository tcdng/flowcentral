/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.widgets;

import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.web.ui.widget.AbstractPanel;

/**
 * Convenient abstract base class for menu widgets.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractMenuWidget extends AbstractPanel {

    public static final String WORK_MENUIDS = "menuIds";

    public static final String WORK_MENUITEMS = "menuItems";

    private boolean collapsedInitial;
    
    public AbstractMenuWidget() {
        this.collapsedInitial = true;
    }
    
    public boolean isCollapsedInitial() throws UnifyException {
        return collapsedInitial;
    }

    public void setCollapsedInitial(boolean collapsedInitial) {
        this.collapsedInitial = collapsedInitial;
    }

}
