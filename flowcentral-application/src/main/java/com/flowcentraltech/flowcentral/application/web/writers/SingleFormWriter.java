/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.writers;

import com.flowcentraltech.flowcentral.application.web.panels.SingleFormPanel;
import com.flowcentraltech.flowcentral.application.web.widgets.SingleFormWidget;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Writes;
import com.tcdng.unify.web.ui.widget.ResponseWriter;
import com.tcdng.unify.web.ui.widget.Widget;
import com.tcdng.unify.web.ui.widget.writer.AbstractControlWriter;

/**
 * Single for widget writer.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Writes(SingleFormWidget.class)
@Component("fc-singleform-writer")
public class SingleFormWriter extends AbstractControlWriter {

    @Override
    protected void doWriteStructureAndContent(ResponseWriter writer, Widget widget) throws UnifyException {
        SingleFormWidget singleFormWidget = (SingleFormWidget) widget;
        writer.write("<div");
        writeTagAttributes(writer, singleFormWidget);
        writer.write(">");
        writer.write("<div>");
        writer.write("<div class=\"sfbody\">");
        SingleFormPanel panel = singleFormWidget.getSingleFormPanel();
        writer.writeStructureAndContent(panel);
        writer.write("</div>");
        writer.write("</div>");
        writer.write("</div>");
        
        
    }

    @Override
    protected void doWriteBehavior(ResponseWriter writer, Widget widget) throws UnifyException {
        super.doWriteBehavior(writer, widget);
        SingleFormWidget singleFormWidget = (SingleFormWidget) widget;
        SingleFormPanel singleFormPanel = singleFormWidget.getSingleFormPanel();
        writer.writeBehavior(singleFormPanel);
        addPageAlias(singleFormWidget.getId(), singleFormPanel);
    }
}
