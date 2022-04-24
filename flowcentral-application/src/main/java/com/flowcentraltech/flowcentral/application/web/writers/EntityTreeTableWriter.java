/*
 * Copyright 2021-2022 FlowCentral Technologies Limited.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.flowcentraltech.flowcentral.application.web.writers;

import java.util.List;

import com.flowcentraltech.flowcentral.application.web.widgets.EntityTreeTable;
import com.flowcentraltech.flowcentral.application.web.widgets.EntityTreeTable.EntityTreeItem;
import com.flowcentraltech.flowcentral.application.web.widgets.EntityTreeTable.EntityTreeLevel;
import com.flowcentraltech.flowcentral.application.web.widgets.EntityTreeTableWidget;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Writes;
import com.tcdng.unify.core.data.ValueStore;
import com.tcdng.unify.core.util.StringUtils;
import com.tcdng.unify.web.ui.widget.Control;
import com.tcdng.unify.web.ui.widget.PushType;
import com.tcdng.unify.web.ui.widget.ResponseWriter;
import com.tcdng.unify.web.ui.widget.Widget;
import com.tcdng.unify.web.ui.widget.writer.AbstractControlWriter;

/**
 * Entity tree table widget writer.
 * 
 * @author FlowCentral Technologies Limited
 * @since 1.0
 */
@Writes(EntityTreeTableWidget.class)
@Component("fc-entitytreetable-writer")
public class EntityTreeTableWriter extends AbstractControlWriter {

    @Override
    protected void doWriteStructureAndContent(ResponseWriter writer, Widget widget) throws UnifyException {
        EntityTreeTableWidget tableWidget = (EntityTreeTableWidget) widget;
        EntityTreeTable table = tableWidget.getEntityTreeTable();
        if (table != null) {
            if (table.isMultiSelect()) {
                writeHiddenPush(writer, tableWidget.getSelectCtrl(), PushType.CHECKBOX);
            }

            writer.write("<div");
            writeTagAttributes(writer, tableWidget);
            writer.write(">");
            writer.write("<div><table");
            writeTagId(writer, tableWidget);
            writeTagStyleClass(writer, "table");
            writer.write(">");

            if (table.isMultiColumn()) {
                // TODO
            } else {
                writer.write("<colgroup>");
                final int prefixColumns = table.isMultiSelect() ? table.getLevelCount()
                        : table.getLevelCount() - 1;
                for (int i = 0; i < prefixColumns; i++) {
                    writer.write("<col class=\"cpre\">");
                }

                if (table.isShowLabel()) {
                    writer.write("<col class=\"clabel\">");
                }

                writer.write("<col class=\"cline\">");
                writer.write("</colgroup>");
            }

            writeBodyRows(writer, tableWidget);
            writer.write("</table></div>");
            writer.write("</div>");
        }
    }

    @Override
    protected void doWriteBehavior(ResponseWriter writer, Widget widget) throws UnifyException {
        super.doWriteBehavior(writer, widget);
        EntityTreeTableWidget tableWidget = (EntityTreeTableWidget) widget;
        EntityTreeTable table = tableWidget.getEntityTreeTable();
        if (table != null) {
            // Append table rigging
            writer.beginFunction("fux.rigEntityTreeTable");
            writer.writeParam("pId", tableWidget.getId());
            writer.writeParam("pContId", tableWidget.getContainerId());
            writer.writeCommandURLParam("pCmdURL");
            if (table.isMultiSelect()) {
                writer.writeParam("pSelCtrlId", tableWidget.getSelectCtrl().getId());
                writer.writeParam("pMultiSel", true);
                writer.writeParam("pLvlChain", table.getItemLevelChain());
            }
            writer.endFunction();
        }
    }

    private void writeBodyRows(ResponseWriter writer, EntityTreeTableWidget tableWidget) throws UnifyException {
        EntityTreeTable table = tableWidget.getEntityTreeTable();
        if (table != null) {
            List<EntityTreeItem> items = table.getItems();
            final int prefixColumns = table.isMultiSelect() ? table.getLevelCount() : table.getLevelCount() - 1;
            final int len = items.size();
            final boolean multiSelect = table.isMultiSelect();
            final boolean showLabel = table.isShowLabel();
            boolean isEvenRow = true;

            if (table.isMultiColumn()) {
                // TODO
            } else {
                for (int i = 0; i < len; i++) {
                    EntityTreeItem item = items.get(i);
                    final int level = item.getLevel();
                    EntityTreeLevel treeLevel = table.getLevel(level);
                    ValueStore valueStore = item.getInstValueStore();
                    Long id = valueStore.retrieve(Long.class, "id");
                    writer.write("<tr");
                    if (level == 0) {
                        isEvenRow = !isEvenRow;
                    }
                    
                    if (isEvenRow) {
                        writeTagStyleClass(writer, "even");
                    } else {
                        writeTagStyleClass(writer, "odd");
                    }
                    
                    writeTagName(writer, tableWidget.getRowId());
                    writer.write(">");

                    writePreColumns(writer, tableWidget, item, id, i);

                    int filler = prefixColumns - level;
                    if (multiSelect) {
                        filler--;
                    }

                    if (showLabel) {
                        writer.write("<td class=\"mlabel\" colspan=\"");
                        writer.write(filler + 1);
                        writer.write("\"><span>");
                        writer.writeWithHtmlEscape(treeLevel.getLabel());
                        writer.write("</span></td>");
                    }

                    writer.write("<td class=\"mline\" colspan=\"");
                    if (showLabel) {
                        writer.write(1);
                    } else {
                        writer.write(filler + 1);
                    }
                    writer.write("\"><span>");
                    String line = StringUtils.buildParameterizedString(treeLevel.getLineFormat(),
                            item.getInstValueStore());
                    writer.writeWithHtmlEscape(line);
                    writer.write("</span></td>");
                    writer.write("</tr>");
                }
            }
        }
    }

    private void writePreColumns(ResponseWriter writer, EntityTreeTableWidget tableWidget, EntityTreeItem item, Long id,
            int index) throws UnifyException {
        EntityTreeTable table = tableWidget.getEntityTreeTable();
        final int depth = item.getLevel();
        if (table != null && table.isMultiSelect()) {
            final Control selectCtrl = tableWidget.getSelectCtrl();
            final boolean selected = item.isSelected();
            writer.write("<td class=\"msel\" colspan=\"");
            writer.write(depth + 1);
            writer.write("\">");
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
        } else if (depth > 0) {
            writer.write("<td class=\"mpre\" colspan=\"");
            writer.write(depth);
            writer.write("\"></td>");
        }
    }
}
