/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.dashboard.web.writers;

import java.util.List;

import com.flowcentraltech.flowcentral.dashboard.web.widgets.DashboardSlateWidget;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Writes;
import com.tcdng.unify.web.ui.widget.ResponseWriter;
import com.tcdng.unify.web.ui.widget.Widget;
import com.tcdng.unify.web.ui.widget.writer.AbstractControlWriter;

/**
 * Dashboard slate writer.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Writes(DashboardSlateWidget.class)
@Component("fc-dashboardslate-writer")
public class DashboardSlateWriter extends AbstractControlWriter {

    @Override
    protected void doWriteStructureAndContent(ResponseWriter writer, Widget widget) throws UnifyException {
        DashboardSlateWidget dashboardSlateWidget = (DashboardSlateWidget) widget;
        writer.write("<div");
        writeTagAttributes(writer, dashboardSlateWidget);
        writer.write(">");

        int sections = dashboardSlateWidget.getTileList().size();
        for (int i = 0; i < sections; i++) {
            writer.write("<div class=\"section\"><div class=\"sectionrow\">");
            List<Widget> list = dashboardSlateWidget.getTileList().get(i);
            int tiles = list.size();
            int tileWidth = tiles > 0 ? 100 / tiles : 100;
            for (int j = 0; j < tiles; j++) {
                writer.write("<div class=\"sectioncell\" style=\"width:").write(tileWidth)
                        .write("%;\"><div class=\"tile\">");
                writer.writeStructureAndContent(list.get(j));
                writer.write("</div></div>");
            }

            writer.write("</div></div>");
        }

        writer.write("</div>");
    }

    @Override
    protected void doWriteBehavior(ResponseWriter writer, Widget widget) throws UnifyException {
        super.doWriteBehavior(writer, widget);
        DashboardSlateWidget dashboardSlateWidget = (DashboardSlateWidget) widget;
        for (List<Widget> list : dashboardSlateWidget.getTileList()) {
            for (Widget tileWidget : list) {
                writer.writeBehavior(tileWidget);
            }
        }
    }
}
