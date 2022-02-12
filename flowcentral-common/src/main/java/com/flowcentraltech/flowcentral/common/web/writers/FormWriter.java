/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.common.web.writers;

import java.util.List;

import com.flowcentraltech.flowcentral.common.data.ErrorContext;
import com.flowcentraltech.flowcentral.common.web.util.WidgetWriterUtils;
import com.flowcentraltech.flowcentral.common.web.util.WidgetWriterUtils.ColumnRenderInfo;
import com.flowcentraltech.flowcentral.common.web.widgets.Form;
import com.flowcentraltech.flowcentral.common.web.widgets.Form.FormSection;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Writes;
import com.tcdng.unify.core.data.ValueStore;
import com.tcdng.unify.core.util.StringUtils;
import com.tcdng.unify.web.ui.widget.Container;
import com.tcdng.unify.web.ui.widget.PushType;
import com.tcdng.unify.web.ui.widget.ResponseWriter;
import com.tcdng.unify.web.ui.widget.Widget;
import com.tcdng.unify.web.ui.widget.writer.AbstractContainerWriter;

/**
 * Form writer.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Writes(Form.class)
@Component("fc-form-writer")
public class FormWriter extends AbstractContainerWriter {

    @Override
    protected void writeLayoutContent(ResponseWriter writer, Container container) throws UnifyException {
        Form form = (Form) container;
        form.cascadeValueStore();
        String groupId = null;
        if (form.isContainerEditable()) {
            groupId = form.getDataGroupId();
        }

        boolean isFormDisabled = form.isDisabled();
        boolean isFormEditable = form.isEditable();
        for (FormSection formSection : form.getSections()) {
            if (formSection.isVisible()) {
                form.setDisabled(isFormDisabled || formSection.isDisabled());
                form.setEditable(isFormEditable && formSection.isEditable());

                if (formSection.isBinding()) {
                    if (formSection.isBindingValueList()) {
                        for (ValueStore valueStore : formSection.getValueStoreList()) {
                            writeSectionStructureAndContent(writer, form, formSection, valueStore, groupId);
                        }
                    } else {
                        writeSectionStructureAndContent(writer, form, formSection, formSection.getValueStore(), null);
                    }
                } else {
                    writeSectionStructureAndContent(writer, form, formSection, null, null);
                }

                form.setEditable(isFormEditable);
                form.setDisabled(isFormDisabled);
            }
        }

        if (form.isContainerEditable()) {
            writeHiddenPush(writer, form.getDataGroupId(), PushType.GROUP);
        }
    }

    @Override
    protected void writeContainedWidgetsBehavior(ResponseWriter writer, Container container) throws UnifyException {
        Form form = (Form) container;
        for (FormSection formSection : form.getSections()) {
            if (formSection.isVisible()) {
                if (formSection.isBinding()) {
                    if (formSection.isBindingValueList()) {
                        for (ValueStore valueStore : formSection.getValueStoreList()) {
                            writeSectionBehavior(writer, form, formSection, valueStore);
                        }
                    } else {
                        writeSectionBehavior(writer, form, formSection, formSection.getValueStore());
                    }
                } else {
                    writeSectionBehavior(writer, form, formSection, null);
                }
            }
        }
    }

    private void writeSectionBehavior(ResponseWriter writer, Form form, FormSection formSection, ValueStore valueStore)
            throws UnifyException {
        final int columns = form.getColumns();
        for (int i = 0; i < columns; i++) {
            for (Widget widget : formSection.getWidgetList(i)) {
                if (widget.isVisible() || widget.isHidden()) {
                    if (valueStore != null) {
                        widget.setValueStore(valueStore);
                    }

                    writer.writeBehavior(widget);
                }
            }
        }
    }

    private void writeSectionStructureAndContent(ResponseWriter writer, Form form, FormSection formSection,
            ValueStore valueStore, String groupId) throws UnifyException {
        ErrorContext eCtx = null; // TODO
        writer.write("<div class=\"ftable\">");
        writer.write("<div class=\"frow\">");
        final int columns = form.getColumns();
        List<ColumnRenderInfo> columnInfos = WidgetWriterUtils.getColumnRenderInfoList(columns);
        for (int i = 0; i < columns; i++) {
            writer.write("<div class=\"fcol\" ").write(columnInfos.get(i).getColumnStyle()).write(">");
            for (Widget widget : formSection.getWidgetList(i)) {
                writeFieldCell(writer, eCtx, widget);
            }
            writer.write("</div>");
        }
        writer.write("</div>");
        writer.write("</div>");
    }

    private void writeFieldCell(ResponseWriter writer, ErrorContext eCtx, Widget widget) throws UnifyException {
        if (widget.isVisible()) {
            writer.write("<div class=\"ffield\">");
            writer.write("<div class=\"ffieldrow\">");

            writer.write("<div class=\"fpre\">");
            writer.write("<div class=\"flabel\">");
            writer.write("<span>");
            if (widget.isUplAttribute("required") && widget.getUplAttribute(boolean.class, "required")) {
                writer.write("<img class=\"freq\"src=\"");
                if (StringUtils.isBlank(widget.getValue(String.class))) {
                    writer.writeFileImageContextURL("$t{images/red_asterix.png}");
                } else {
                    writer.writeFileImageContextURL("$t{images/gray_asterix.png}");
                }
                writer.write("\"/>");
            }
            writer.writeWithHtmlEscape(widget.getCaption());
            writer.write("</span>");
            writer.write("</div>");
            writer.write("</div>");

            writer.write("<div class=\"fmid\">");
            writer.write("<div class=\"fcon\">");
            writer.write("<div class=\"fcontent\">");
            writer.writeStructureAndContent(widget);
            if (eCtx != null && eCtx.isWithFieldError(widget.getBinding())) {
                writer.write("<span class=\"errmsg\">")
                        .write(resolveSessionMessage(eCtx.getFieldError(widget.getBinding()))).write("</span>");
            }

            writer.write("</div>");
            writer.write("</div>");
            writer.write("</div>");

            writer.write("<div class=\"fpost").write("\">");
            writer.write("</div>");

            writer.write("</div>");
            writer.write("</div>");
        }
    }
}
