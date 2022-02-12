/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.studio.web.writers;

import com.flowcentraltech.flowcentral.application.data.EntityFieldDef;
import com.flowcentraltech.flowcentral.studio.web.widgets.TableEditor;
import com.flowcentraltech.flowcentral.studio.web.widgets.TableEditorWidget;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Writes;
import com.tcdng.unify.core.util.json.JsonWriter;
import com.tcdng.unify.web.ui.widget.ResponseWriter;
import com.tcdng.unify.web.ui.widget.Widget;
import com.tcdng.unify.web.ui.widget.WriteWork;
import com.tcdng.unify.web.ui.widget.writer.AbstractControlWriter;

/**
 * Table editor widget writer.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Writes(TableEditorWidget.class)
@Component("fc-tableeditor-writer")
public class TableEditorWriter extends AbstractControlWriter {

    private static final String[] COLUMN_PROPERTY_KEYS = { "tableeditor.field", "tableeditor.label", "tableeditor.link",
            "tableeditor.widget", "tableeditor.widthratio", "tableeditor.switchonchange", "tableeditor.disabled",
            "tableeditor.editable", "tableeditor.sortable" };

    @Override
    protected void doWriteStructureAndContent(ResponseWriter writer, Widget widget) throws UnifyException {
        final TableEditorWidget tableEditorWidget = (TableEditorWidget) widget;
        final TableEditor tableEditor = tableEditorWidget.getTableEditor();
        final JsonWriter jsonWriter = new JsonWriter();
        jsonWriter.beginObject();
        writer.write("<div");
        writeTagAttributes(writer, tableEditorWidget);
        writer.write(">");

        jsonWriter.write("downarrow", resolveSymbolHtmlHexCode("arrow-down"));
        jsonWriter.write("plus", resolveSymbolHtmlHexCode("plus"));
        jsonWriter.write("cog", resolveSymbolHtmlHexCode("cog"));
        jsonWriter.write("cross", resolveSymbolHtmlHexCode("cross"));
        jsonWriter.write("none", getSessionMessage("tableeditor.none"));
        jsonWriter.write("placecolumn", getSessionMessage("tableeditor.placeherecolumn"));
        jsonWriter.write("addcolumn", getSessionMessage("tableeditor.addtablecolumn"));
        jsonWriter.write("editable", !tableEditor.isReadOnly());

        // Column property labels
        String[] labels = getSessionMessages(COLUMN_PROPERTY_KEYS);
        jsonWriter.write("propLabels", labels);

        // Body
        writer.write(
                "<div style=\"display:table;table-layout: fixed;width:100%;height:100%;\"><div style=\"display:table-row;\">");
        // Fields
        writer.write("<div class=\"fields\" style=\"display:table-cell;vertical-align:top;width:")
                .write(tableEditorWidget.getChoiceWidth()).write(";\">");
        writer.write("<div class=\"bdy\" id=\"").write(tableEditorWidget.getFieldBaseId()).write("\">");
        writer.write("<div class=\"hdr\">").write(getSessionMessage("tableeditor.availablefields")).write("</div>");
        jsonWriter.beginArray("fields");
        int i = 0;
        for (EntityFieldDef entityFieldDef : tableEditor.getEntityDef().getFieldDefList()) {
            if (entityFieldDef.isTableViewable()) {
                writer.write("<div class=\"fld\" id=\"").write(tableEditorWidget.getChoiceId()).write(i)
                        .write("\"><span>");
                writer.writeWithHtmlEscape(entityFieldDef.getFieldLabel());
                writer.write("</span></div>");

                jsonWriter.beginObject();
                jsonWriter.write("fldLabel", entityFieldDef.getFieldLabel());
                jsonWriter.write("fldNm", entityFieldDef.getFieldName());
                if (entityFieldDef.isWithInputWidget()) {
                    jsonWriter.write("fldWidget", entityFieldDef.getInputWidgetTypeDef().getLongName());
                }
                jsonWriter.endObject();

                i++;
            }
        }
        jsonWriter.endArray();
        writer.write("</div></div>");
        // End fields

        // Design
        writer.write("<div class=\"design\" style=\"display:table-cell;vertical-align:top;\">");
        writer.write("<div id=\"").write(tableEditorWidget.getDesignBaseId()).write("\" class=\"designbase\">");
        writer.write("</div></div>");
        jsonWriter.writeObject("design", tableEditor.getDesign());
        // End design

        writer.write("</div></div>");
        // End body

        // State transfer control
        writer.writeStructureAndContent(tableEditorWidget.getValueCtrl());

        writer.write("</div>");
        jsonWriter.endObject();

        WriteWork work = tableEditorWidget.getWriteWork();
        work.set(TableEditorWidget.WORK_CONTENT, jsonWriter.toString());
    }

    @Override
    protected void doWriteBehavior(ResponseWriter writer, Widget widget) throws UnifyException {
        super.doWriteBehavior(writer, widget);

        final TableEditorWidget tableEditorWidget = (TableEditorWidget) widget;
        writer.writeBehavior(tableEditorWidget.getValueCtrl());

        writer.beginFunction("fuxstudio.rigTableEditor");
        writer.writeParam("pId", tableEditorWidget.getId());
        writer.writeCommandURLParam("pCmdURL");
        writer.writeParam("pContId", tableEditorWidget.getContainerId());
        writer.writeParam("pFieldBaseId", tableEditorWidget.getFieldBaseId());
        writer.writeParam("pDsnBaseId", tableEditorWidget.getDesignBaseId());
        writer.writeParam("pChoiceId", tableEditorWidget.getChoiceId());
        writer.writeParam("pStateId", tableEditorWidget.getValueCtrl().getId());
        writer.writeParam("pEditColId", tableEditorWidget.getTableEditor().getEditColumnId());
        writer.writeResolvedParam("pContent",
                (String) tableEditorWidget.getWriteWork().get(TableEditorWidget.WORK_CONTENT));
        writer.endFunction();
    }
}
