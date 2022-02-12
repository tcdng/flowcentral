/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.panels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.flowcentraltech.flowcentral.application.business.AppletUtilities;
import com.flowcentraltech.flowcentral.application.data.EntityDef;
import com.flowcentraltech.flowcentral.application.data.TabSheetDef;
import com.flowcentraltech.flowcentral.application.entities.AppTable;
import com.flowcentraltech.flowcentral.application.entities.AppTableColumn;
import com.flowcentraltech.flowcentral.application.web.widgets.BreadCrumbs;
import com.flowcentraltech.flowcentral.application.web.widgets.TabSheet;
import com.flowcentraltech.flowcentral.application.web.widgets.TabSheet.TabSheetItem;
import com.flowcentraltech.flowcentral.application.web.widgets.TabSheetEventHandler;
import com.flowcentraltech.flowcentral.configuration.constants.RendererType;
import com.flowcentraltech.flowcentral.studio.web.widgets.TableEditor;
import com.flowcentraltech.flowcentral.studio.web.widgets.TableEditor.TableColumn;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.database.Query;

/**
 * Table editor page.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class TableEditorPage extends AbstractStudioEditorPage implements TabSheetEventHandler {

    private static final int DESIGN_INDEX = 0;

    private static final int PREVIEW_INDEX = 1;

    private final EntityDef entityDef;

    private final Object baseId;

    private TabSheet tabSheet;

    private TableEditor tableEditor;

    private TablePreview tablePreview;

    public TableEditorPage(AppletUtilities au, EntityDef entityDef, Object baseId, BreadCrumbs breadCrumbs) {
        super(au, breadCrumbs);
        this.entityDef = entityDef;
        this.baseId = baseId;
    }

    public TabSheet getTabSheet() {
        return tabSheet;
    }

    public TableEditor getTableEditor() {
        return tableEditor;
    }

    public TablePreview getTablePreview() {
        return tablePreview;
    }

    public EntityDef getEntityDef() {
        return entityDef;
    }

    public Object getBaseId() {
        return baseId;
    }

    @Override
    public void onChoose(TabSheetItem tabSheetItem) throws UnifyException {
        switch (tabSheetItem.getIndex()) {
            case DESIGN_INDEX:
                break;
            case PREVIEW_INDEX:
                tablePreview.reload();
                break;
            default:
        }
    }

    public void commitDesign() throws UnifyException {
        AppTable appTable = getAu().getEnvironment().find(AppTable.class, baseId);
        List<AppTableColumn> columnList = Collections.emptyList();
        if (tableEditor.getDesign() != null && tableEditor.getDesign().getColumns() != null) {
            columnList = new ArrayList<AppTableColumn>();
            for (TableColumn tableColumn : tableEditor.getDesign().getColumns()) {
                AppTableColumn appTableColumn = new AppTableColumn();
                appTableColumn.setField(tableColumn.getFldNm());
                appTableColumn.setRenderWidget(tableColumn.getWidget());
                appTableColumn.setLabel(tableColumn.getLabel());
                appTableColumn.setLinkAct(tableColumn.getLink());
                appTableColumn.setWidthRatio(tableColumn.getWidth());
                appTableColumn.setSwitchOnChange(tableColumn.isSwitchOnChange());
                appTableColumn.setEditable(tableColumn.isEditable());
                appTableColumn.setDisabled(tableColumn.isDisabled());
                appTableColumn.setSortable(tableColumn.isSort());
                columnList.add(appTableColumn);
            }
        }

        appTable.setColumnList(columnList);
        getAu().getEnvironment().updateByIdVersion(appTable);
    }

    public void newEditor() throws UnifyException {
        TableEditor.Builder teb = TableEditor.newBuilder(entityDef);
        for (AppTableColumn appTableColumn : getAu().getEnvironment()
                .findAll(Query.of(AppTableColumn.class).addEquals("appTableId", baseId).addOrder("id"))) {
            teb.addColumn(appTableColumn.getField(), appTableColumn.getRenderWidget(), appTableColumn.getLabel(),
                    appTableColumn.getLinkAct(), appTableColumn.getWidthRatio(), appTableColumn.isSwitchOnChange(),
                    appTableColumn.isDisabled(), appTableColumn.isEditable(), appTableColumn.isSortable());
        }

        TabSheetDef.Builder tsdb = TabSheetDef.newBuilder(null, 1L);
        tsdb.addTabDef("editor", getAu().resolveSessionMessage("$m{studio.apptable.form.design}"), "!fc-tableeditor",
                RendererType.SIMPLE_WIDGET);
        tsdb.addTabDef("preview", getAu().resolveSessionMessage("$m{studio.apptable.form.preview}"),
                "fc-tablepreviewpanel", RendererType.STANDALONE_PANEL);
        tableEditor = teb.build();
        tablePreview = new TablePreview(getAu(), tableEditor);
//        tablePreview.reload();
        final String appletName = null;
        tabSheet = new TabSheet(tsdb.build(),
                Arrays.asList(new TabSheetItem("tableEditor", appletName, tableEditor, DESIGN_INDEX, true),
                        new TabSheetItem("tablePreview", appletName, tablePreview, PREVIEW_INDEX, true)));
        tabSheet.setEventHandler(this);
    }
}
