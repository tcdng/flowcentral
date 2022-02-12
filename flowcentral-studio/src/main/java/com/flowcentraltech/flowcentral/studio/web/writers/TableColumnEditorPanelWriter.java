/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.writers;

import com.flowcentraltech.flowcentral.studio.web.panels.TableColumnEditorPanel;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Writes;
import com.tcdng.unify.web.ui.widget.ResponseWriter;
import com.tcdng.unify.web.ui.widget.Widget;
import com.tcdng.unify.web.ui.widget.writer.panel.DetachedPanelWriter;

/**
 * Table column editor panel writer.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Writes(TableColumnEditorPanel.class)
@Component("tablecolumneditorpanel-writer")
public class TableColumnEditorPanelWriter extends DetachedPanelWriter {

    @Override
    protected void doWriteBehavior(ResponseWriter writer, Widget widget) throws UnifyException {
        super.doWriteBehavior(writer, widget);
        TableColumnEditorPanel tableColumnEditorPanel = (TableColumnEditorPanel) widget;
        writer.beginFunction("fuxstudio.rigTableColumnEditorPanel");
        writer.writeParam("pId", tableColumnEditorPanel.getId());
        writer.writeParam("pFieldId", tableColumnEditorPanel.getFieldId());
        writer.writeParam("pLabelId", tableColumnEditorPanel.getLabelId());
        writer.writeParam("pLinkId", tableColumnEditorPanel.getLinkId());
        writer.writeParam("pWidgetId", tableColumnEditorPanel.getWidgetId());
        writer.writeParam("pWidthId", tableColumnEditorPanel.getWidthId());
        writer.writeParam("pSwitchId", tableColumnEditorPanel.getSwitchId());
        writer.writeParam("pEditableId", tableColumnEditorPanel.getEditableId());
        writer.writeParam("pDisabledId", tableColumnEditorPanel.getDisabledId());
        writer.writeParam("pSortId", tableColumnEditorPanel.getSortableId());
        writer.writeParam("pApplyId", tableColumnEditorPanel.getApplyId());
        writer.writeParam("pCancelId", tableColumnEditorPanel.getCancelId());
        writer.endFunction();
    }

}
