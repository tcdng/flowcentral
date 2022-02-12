/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.panels;

import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.UplBinding;
import com.tcdng.unify.web.ui.widget.panel.DetachedPanel;

/**
 * Table column editor panel.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-tablecolumneditorpanel")
@UplBinding("web/studio/upl/tablecolumneditorpanel.upl")
public class TableColumnEditorPanel extends DetachedPanel {

    @Override
    public void onPageConstruct() throws UnifyException {
        super.onPageConstruct();
        setDisabled("editValField", true);
    }

    public String getFieldId() throws UnifyException {
        return getWidgetByShortName("editValField").getId();
    }

    public String getLabelId() throws UnifyException {
        return getWidgetByShortName("editValLabel").getId();
    }

    public String getLinkId() throws UnifyException {
        return getWidgetByShortName("editValLink").getId();
    }

    public String getWidgetId() throws UnifyException {
        return getWidgetByShortName("editValWidget").getId();
    }

    public String getWidthId() throws UnifyException {
        return getWidgetByShortName("editValWidth").getId();
    }

    public String getSwitchId() throws UnifyException {
        return getWidgetByShortName("editValSwitch").getId();
    }

    public String getDisabledId() throws UnifyException {
        return getWidgetByShortName("editValDisabled").getId();
    }

    public String getEditableId() throws UnifyException {
        return getWidgetByShortName("editValEditable").getId();
    }

    public String getSortableId() throws UnifyException {
        return getWidgetByShortName("editValSortable").getId();
    }

    public String getApplyId() throws UnifyException {
        return getWidgetByShortName("editApplyBtn").getId();
    }

    public String getCancelId() throws UnifyException {
        return getWidgetByShortName("editCancelBtn").getId();
    }
}
