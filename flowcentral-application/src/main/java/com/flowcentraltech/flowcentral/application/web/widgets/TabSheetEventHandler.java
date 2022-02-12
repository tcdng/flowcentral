/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.web.widgets;

import com.flowcentraltech.flowcentral.application.web.widgets.TabSheet.TabSheetItem;
import com.tcdng.unify.core.UnifyException;

/**
 * Tab sheet event handler
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface TabSheetEventHandler {

    /**
     * Handle on choose.
     * 
     * @param tabSheetItem
     *                     the tab sheet item.
     * @throws UnifyException
     *                        if an error occurs
     */
    void onChoose(TabSheetItem tabSheetItem) throws UnifyException;
}
