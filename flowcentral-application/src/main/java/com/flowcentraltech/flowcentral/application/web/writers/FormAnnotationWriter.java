/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.web.writers;

import java.util.List;

import com.flowcentraltech.flowcentral.application.data.FormAnnotationDef;
import com.flowcentraltech.flowcentral.application.web.widgets.FormAnnotationWidget;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Writes;
import com.tcdng.unify.core.util.DataUtils;
import com.tcdng.unify.web.ui.widget.ResponseWriter;
import com.tcdng.unify.web.ui.widget.Widget;
import com.tcdng.unify.web.ui.widget.writer.AbstractControlWriter;

/**
 * Form annotation writer.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Writes(FormAnnotationWidget.class)
@Component("formannotation-writer")
public class FormAnnotationWriter extends AbstractControlWriter {

    @Override
    protected void doWriteStructureAndContent(ResponseWriter writer, Widget widget) throws UnifyException {
        FormAnnotationWidget frmAnnotationWidget = (FormAnnotationWidget) widget;
        writer.write("<div");
        writeTagAttributes(writer, frmAnnotationWidget);
        writer.write(">");
        List<FormAnnotationDef> formAnnotationDefList = frmAnnotationWidget.getFormAnnotationDef();
        if (!DataUtils.isBlank(formAnnotationDefList)) {
            for (FormAnnotationDef frmAnnotationDef : formAnnotationDefList) {
                writer.write("<span class=\"");
                writer.write(frmAnnotationDef.getType().styleClass());
                writer.write("\">");
                if (frmAnnotationDef.isHtml()) {
                    writer.write(frmAnnotationDef.getMessage());
                } else {
                    writer.writeWithHtmlEscape(frmAnnotationDef.getMessage());
                }
                writer.write("</span>");
            }
        }
        writer.write("</div>");
    }

}
