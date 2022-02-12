/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.studio.web.panels;

import com.flowcentraltech.flowcentral.studio.web.widgets.TableEditor;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.UplBinding;
import com.tcdng.unify.web.annotation.Action;

/**
 * Table editor page panel.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-tableeditorpagepanel")
@UplBinding("web/studio/upl/tableeditorpagepanel.upl")
public class TableEditorPagePanel extends AbstractStudioEditorPagePanel {

    @Override
    public void switchState() throws UnifyException {
        super.switchState();

        final boolean readOnly = isAppletContextReadOnly();
        TableEditor tableEditor = getTableEditorPage().getTableEditor();
        tableEditor.setReadOnly(readOnly);
        if (tableEditor.getEditColumnId() == null) {
            tableEditor.setEditColumnId(getWidgetByShortName("editColumnPanel").getId());
        }

        setWidgetVisible("saveBtn", !readOnly);
        setWidgetEditable("editColumnPanel", !readOnly);
    }

    @Action
    public void preview() throws UnifyException {
        getTableEditorPage().getTablePreview().reload();
    }

    @Action
    public void saveDesign() throws UnifyException {
        TableEditorPage tableEditorPage = getTableEditorPage();
        tableEditorPage.commitDesign();
        hintUser("$m{studioapptableapplet.tableeditor.success.hint}", tableEditorPage.getSubTitle());
    }

    private TableEditorPage getTableEditorPage() throws UnifyException {
        return getValue(TableEditorPage.class);
    }
}
