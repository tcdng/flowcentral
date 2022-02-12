/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.writers;

import java.util.List;

import com.flowcentraltech.flowcentral.application.constants.ApplicationModuleSysParamConstants;
import com.flowcentraltech.flowcentral.application.data.TableColumnDef;
import com.flowcentraltech.flowcentral.application.data.TableDef;
import com.flowcentraltech.flowcentral.application.web.widgets.AbstractTable;
import com.flowcentraltech.flowcentral.application.web.widgets.AbstractTableWidget;
import com.flowcentraltech.flowcentral.system.business.SystemModuleService;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.annotation.Writes;
import com.tcdng.unify.core.constant.OrderType;
import com.tcdng.unify.core.data.ValueStore;
import com.tcdng.unify.core.util.DataUtils;
import com.tcdng.unify.web.ui.widget.AbstractMultiControl.ChildWidgetInfo;
import com.tcdng.unify.web.ui.widget.Control;
import com.tcdng.unify.web.ui.widget.EventHandler;
import com.tcdng.unify.web.ui.widget.PushType;
import com.tcdng.unify.web.ui.widget.ResponseWriter;
import com.tcdng.unify.web.ui.widget.Widget;
import com.tcdng.unify.web.ui.widget.writer.AbstractControlWriter;

/**
 * Table widget writer.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Writes(AbstractTableWidget.class)
@Component("fc-table-writer")
public class TableWriter extends AbstractControlWriter {

    @Configurable
    private SystemModuleService systemModuleService;

    public final void setSystemModuleService(SystemModuleService systemModuleService) {
        this.systemModuleService = systemModuleService;
    }

    @Override
    protected void doWriteStructureAndContent(ResponseWriter writer, Widget widget) throws UnifyException {
        AbstractTableWidget<?, ?, ?> tableWidget = (AbstractTableWidget<?, ?, ?>) widget;
        if (tableWidget.isMultiSelect()) {
            writeHiddenPush(writer, tableWidget.getSelectCtrl(), PushType.CHECKBOX);
        }

        AbstractTable<?, ?> table = tableWidget.getTable(); // Must call this here to initialize table
        TableDef tableDef = table.getTableDef();
        boolean sortable = tableDef.isSortable() && table.getNumberOfPages() > 0;
        writer.write("<div");
        writeTagStyleClassWithLeadingExtraStyleClasses(writer, tableWidget, "fc-table");
        writeTagStyle(writer, tableWidget);
        writer.write(">");
        writer.write("<div><table");
        writeTagId(writer, tableWidget);
        writeTagStyleClass(writer, "table");
        writer.write(">");
        writeHeaderRow(writer, tableWidget);
        writeBodyRows(writer, tableWidget);
        writer.write("</table></div>");
        if (sortable) {
            writer.writeStructureAndContent(tableWidget.getSortColumnCtrl());
        }
        writer.write("</div>");
    }

    @Override
    protected void doWriteBehavior(ResponseWriter writer, Widget widget) throws UnifyException {
        super.doWriteBehavior(writer, widget);
        AbstractTableWidget<?, ?, ?> tableWidget = (AbstractTableWidget<?, ?, ?>) widget;
        final String tableWidgetId = tableWidget.getId();
        final boolean isContainerEditable = tableWidget.isContainerEditable();

        // External control behavior
        final AbstractTable<?, ?> table = tableWidget.getTable();
        final EventHandler[] switchOnChangeHandlers = table.getSwitchOnChangeHandlers();
        final TableDef tableDef = table.getTableDef();
        List<ValueStore> valueList = tableWidget.getValueList();
        int len = valueList.size();
        for (int i = 0; i < len; i++) {
            ValueStore valueStore = valueList.get(i);
            int index = 0;
            for (ChildWidgetInfo widgetInfo : tableWidget.getChildWidgetInfos()) {
                if (widgetInfo.isExternal()) {
                    TableColumnDef tabelColumnDef = tableDef.getColumnDef(index);
                    Widget chWidget = widgetInfo.getWidget();
                    chWidget.setValueStore(valueStore);
                    writer.writeBehavior(chWidget);
                    if (switchOnChangeHandlers != null && tabelColumnDef.isSwitchOnChange()) {
                        final String cId = chWidget.isBindEventsToFacade() ? chWidget.getFacadeId() : chWidget.getId();
                        for (EventHandler eventHandler : switchOnChangeHandlers) {
                            writer.writeBehavior(eventHandler, cId, tabelColumnDef.getFieldName());
                        }
                    }

                    if (isContainerEditable && tableWidget.isInputWidget(chWidget)) {
                        addPageAlias(tableWidgetId, chWidget);
                    }
                    index++;
                }
            }
        }

        if (isContainerEditable && table.isEntryMode()) {
            getRequestContextUtil().addOnSaveContentWidget(tableWidgetId);
        }

        // Append table rigging
        writer.beginFunction("fux.rigTable");
        writer.writeParam("pId", tableWidgetId);
        writer.writeParam("pContId", tableWidget.getContainerId());
        writer.writeCommandURLParam("pCmdURL");
        if (tableWidget.isMultiSelect()) {
            writer.writeParam("pSelAllId", tableWidget.getSelectAllId());
            writer.writeParam("pSelCtrlId", tableWidget.getSelectCtrl().getId());
            writer.writeParam("pMultiSel", true);
            writer.writeParam("pMultiSelDepList",
                    DataUtils.toArray(String.class, tableWidget.getMultiSelDependentList()));
        }

        writer.writeParam("pRefPanels", table.getRefreshPanelIds());

        boolean sortable = tableDef.isSortable() && table.getNumberOfPages() > 0;
        if (sortable) {
            writer.writeParam("pSortIndexId", tableWidget.getSortColumnCtrl().getId());
            writer.writeParam("pColHeaderId", tableWidget.getColumnHeaderId());
            writer.writeParam("pColCount", tableDef.getColumnCount());
        }

        if (table.getTotalItemCount() <= 0) {
            writer.writeParam("pConDepList", DataUtils.toArray(String.class, tableWidget.getContentDependentList()));
        }
        writer.endFunction();
    }

    private void writeHeaderRow(ResponseWriter writer, AbstractTableWidget<?, ?, ?> tableWidget) throws UnifyException {
        writer.write("<tr>");
        final AbstractTable<?, ?> table = tableWidget.getTable();
        final TableDef tableDef = table.getTableDef();
        final boolean entryMode = table.isEntryMode();
        if (!entryMode) {
            writeHeaderMultiSelect(writer, tableWidget);
        }

        if (tableDef.isSerialNo()) {
            writer.write("<th class=\"mserialh\"><span>");
            writer.write(getSessionMessage("tablewidget.serialno"));
            writer.write("</span></th>");
        }

        final boolean sysHeaderUppercase = systemModuleService.getSysParameterValue(boolean.class,
                ApplicationModuleSysParamConstants.ALL_TABLE_HEADER_TO_UPPERCASE);
        final boolean sysHeaderCenterAlign = systemModuleService.getSysParameterValue(boolean.class,
                ApplicationModuleSysParamConstants.ALL_TABLE_HEADER_CENTER_ALIGNED);
        final boolean sortable = tableDef.isSortable() && tableWidget.getTable().getNumberOfPages() > 0;
        String columnHeaderId = tableWidget.getColumnHeaderId();
        int index = 0;
        for (ChildWidgetInfo widgetInfo : tableWidget.getChildWidgetInfos()) {
            if (widgetInfo.isExternal()) {
                TableColumnDef tabelColumnDef = tableDef.getColumnDef(index);
                writer.write("<th");
                if (sysHeaderCenterAlign || tableDef.isHeaderCenterAlign()) {
                    writeTagStyle(writer, tabelColumnDef.getHeaderStyle() + "text-align:center;");
                } else {
                    writeTagStyle(writer, tabelColumnDef.getHeaderStyle());
                }
                writer.write("><span ");
                boolean appendSortedSym = false;
                if (sortable && tabelColumnDef.isSortable()) {
                    writer.write("id = \"").write(columnHeaderId).write(index).write("\"");
                    if (appendSortedSym = (index == tableWidget.getSortColumnIndex())) {
                        writer.write(" class = \"sorted g_fsm\"");
                    } else {
                        writer.write(" class = \"sort\"");
                    }
                }
                writer.write(">");
                String caption = tableDef.getFieldLabel(index);
                if (caption != null) {
                    if (sysHeaderUppercase || tableDef.isHeaderToUpperCase()) {
                        writer.writeWithHtmlEscape(caption.toUpperCase());
                    } else {
                        writer.writeWithHtmlEscape(caption);
                    }
                } else {
                    writer.writeHtmlFixedSpace();
                }

                if (appendSortedSym) {
                    writer.write("&nbsp;");
                    if (OrderType.ASCENDING.equals(tableWidget.getSortType())) {
                        writer.write(resolveSymbolHtmlHexCode("caret-up"));
                    } else {
                        writer.write(resolveSymbolHtmlHexCode("caret-down"));
                    }
                }
                writer.write("</span>");
                writer.write("</th>");
                index++;
            }
        }

        if (entryMode) {
            writeHeaderMultiSelect(writer, tableWidget);
        }

        writer.write("</tr>");
    }

    private void writeHeaderMultiSelect(ResponseWriter writer, AbstractTableWidget<?, ?, ?> tableWidget)
            throws UnifyException {
        if (tableWidget.isMultiSelect()) {
            writer.write("<th class=\"mselh\">");
            writer.write("<span");
            writeTagId(writer, "fac_" + tableWidget.getSelectAllId());
            if (tableWidget.isContainerDisabled()) {
                writeTagStyleClass(writer, "g_cbd");
            } else {
                writeTagStyleClass(writer, "g_cbb");
            }
            writer.write("/>");
            writer.write("<input type=\"checkbox\"");
            writeTagId(writer, tableWidget.getSelectAllId());
            writer.write("/>");
            writer.write("</th>");
        }
    }

    private void writeBodyRows(ResponseWriter writer, AbstractTableWidget<?, ?, ?> tableWidget) throws UnifyException {
        final AbstractTable<?, ?> table = tableWidget.getTable();
        final boolean entryMode = table.isEntryMode();
        final int pageIndex = table.getDispStartIndex() + 1;
        final TableDef tableDef = table.getTableDef();
        final boolean isSerialNo = tableDef.isSerialNo();
        boolean isEvenRow = true;
        List<ValueStore> valueList = tableWidget.getValueList();
        int len = valueList.size();
        for (int i = 0; i < len; i++) {
            ValueStore valueStore = valueList.get(i);
            Long id = valueStore.retrieve(Long.class, "id");
            writer.write("<tr");
            if (isEvenRow) {
                writeTagStyleClass(writer, "even");
                isEvenRow = false;
            } else {
                writeTagStyleClass(writer, "odd");
                isEvenRow = true;
            }

            writeTagName(writer, tableWidget.getRowId());
            writer.write(">");

            if (!entryMode) {
                writeRowMultiSelect(writer, tableWidget, id, i);
            }

            if (isSerialNo) {
                writer.write("<td class=\"mseriald\"><span>");
                writer.write(pageIndex + i);
                writer.write(".</span></td>");
            }

            int index = 0;
            for (ChildWidgetInfo widgetInfo : tableWidget.getChildWidgetInfos()) {
                if (widgetInfo.isExternal()) {
                    TableColumnDef tabelColumnDef = tableDef.getColumnDef(index);
                    Widget chWidget = widgetInfo.getWidget();
                    chWidget.setEditable(tabelColumnDef.isEditable());
                    chWidget.setDisabled(tabelColumnDef.isDisabled());
                    chWidget.setValueStore(valueStore);
                    writer.write("<td");
                    writeTagStyle(writer, chWidget.getColumnStyle());
                    writer.write(">");
                    writer.writeStructureAndContent(chWidget);
                    writer.write("</td>");
                    index++;
                }
            }

            if (entryMode) {
                writeRowMultiSelect(writer, tableWidget, id, i);
            }

            writer.write("</tr>");
        }
    }

    public void writeRowMultiSelect(ResponseWriter writer, AbstractTableWidget<?, ?, ?> tableWidget, Long id, int index)
            throws UnifyException {
        if (tableWidget.isMultiSelect()) {
            final Control selectCtrl = tableWidget.getSelectCtrl();
            final boolean selected = tableWidget.getTable().isSelected(id);
            writer.write("<td class=\"mseld\">");
            String namingIndexId = selectCtrl.getNamingIndexedId(index);
            writer.write("<span ");
            writeTagId(writer, "fac_" + namingIndexId);
            if (tableWidget.isContainerDisabled()) {
                if (selected) {
                    writeTagStyleClass(writer, "g_cbc");
                } else {
                    writeTagStyleClass(writer, "g_cbd");
                }
            } else {
                if (selected) {
                    writeTagStyleClass(writer, "g_cba");
                } else {
                    writeTagStyleClass(writer, "g_cbb");
                }
            }

            writer.write("/>");
            writer.write("<input type=\"checkbox\"");
            writeTagId(writer, namingIndexId);
            writeTagName(writer, selectCtrl.getId());
            writeTagValue(writer, index);
            if (selected) {
                writer.write(" checked=\"checked\"");
            }
            writer.write("/>");
            writer.write("</span>");
            writer.write("</td>");
        }
    }
}
