/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.writers;

import com.flowcentraltech.flowcentral.application.web.widgets.ProgressBar;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Writes;
import com.tcdng.unify.web.ui.widget.ResponseWriter;
import com.tcdng.unify.web.ui.widget.Widget;
import com.tcdng.unify.web.ui.widget.writer.AbstractControlWriter;

/**
 * Progress bar writer.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Writes(ProgressBar.class)
@Component("fc-progressbar-writer")
public class ProgressBarWriter extends AbstractControlWriter {

    @Override
    protected void doWriteStructureAndContent(ResponseWriter writer, Widget widget) throws UnifyException {
        ProgressBar progressBarWidget = (ProgressBar) widget;
        writer.write("<div");
        writeTagAttributes(writer, progressBarWidget);
        writer.write(">");
        int percent = progressBarWidget.getValue(int.class);
        percent = percent < 0 ? 0 : percent;
        percent = percent > 100 ? 100 : percent;
        writer.write("<div class=\"prog\" style=\"width:").write(percent).write("%;\"></div>");
        writer.write("</div>");
    }
}
