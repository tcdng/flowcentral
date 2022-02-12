/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.web.writers;

import java.util.List;

import com.flowcentraltech.flowcentral.application.web.widgets.FormMessagesWidget;
import com.flowcentraltech.flowcentral.common.data.FormMessage;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Writes;
import com.tcdng.unify.web.ui.widget.ResponseWriter;
import com.tcdng.unify.web.ui.widget.Widget;
import com.tcdng.unify.web.ui.widget.writer.AbstractControlWriter;

/**
 * Form messages writer.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Writes(FormMessagesWidget.class)
@Component("formmessages-writer")
public class FormMessagesWriter extends AbstractControlWriter {

    @Override
    protected void doWriteStructureAndContent(ResponseWriter writer, Widget widget) throws UnifyException {
        FormMessagesWidget frmMessagesWidget = (FormMessagesWidget) widget;
        writer.write("<div");
        writeTagAttributes(writer, frmMessagesWidget);
        writer.write(">");
        List<FormMessage> messagesList = frmMessagesWidget.getMessages();
        if (messagesList != null) {
            writer.write("<ul class=\"bdy\">");
            for (FormMessage message : messagesList) {
                writer.write("<li class=\"").write(message.getType().styleClass()).write("\">")
                        .writeWithHtmlEscape(resolveSessionMessage(message.getMessage())).write("</li>");
            }
            writer.write("</ul>");
        }
        writer.write("</div>");
    }

}
