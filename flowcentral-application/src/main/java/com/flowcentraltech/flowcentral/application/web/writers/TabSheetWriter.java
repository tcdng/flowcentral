/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.writers;

import java.util.List;

import com.flowcentraltech.flowcentral.application.data.TabDef;
import com.flowcentraltech.flowcentral.application.web.widgets.TabSheet;
import com.flowcentraltech.flowcentral.application.web.widgets.TabSheetWidget;
import com.flowcentraltech.flowcentral.common.web.util.WidgetWriterUtils;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Writes;
import com.tcdng.unify.web.ui.constant.MessageType;
import com.tcdng.unify.web.ui.widget.ResponseWriter;
import com.tcdng.unify.web.ui.widget.Widget;
import com.tcdng.unify.web.ui.widget.writer.AbstractControlWriter;

/**
 * Tab sheet widget writer.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Writes(TabSheetWidget.class)
@Component("fc-tabsheet-writer")
public class TabSheetWriter extends AbstractControlWriter {

    @Override
    protected void doWriteStructureAndContent(ResponseWriter writer, Widget widget) throws UnifyException {
        TabSheetWidget tabSheetWidget = (TabSheetWidget) widget;
        writer.write("<div");
        writeTagAttributes(writer, tabSheetWidget);
        writer.write(">");
        writer.write("<div>");
        TabSheet tabSheet = tabSheetWidget.getTabSheet();
        if (tabSheet != null && tabSheet.isInStateForDisplay()) {
            writer.write("<ul class=\"ttab\">");
            final String tabPrefix = tabSheetWidget.getPrefixedId("tab_");
            List<TabDef> tabDefList = tabSheet.getTabDefList();
            int currentIndex = tabSheet.getCurrentTabIndex();
            int len = tabDefList.size();
            for (int i = 0; i < len; i++) {
                if (tabSheet.getTabSheetItem(i).isVisible()) {
                    TabDef tabDef = tabDefList.get(i);
                    MessageType messageType = tabSheet.getReviewMessageType(tabDef.getTabName());
                    writer.write("<li id=\"").write(tabPrefix).write(i).write("\" class=\"");
                    writer.write(WidgetWriterUtils.getTabClass(i, currentIndex));
                    writer.write("\">");
                    if (messageType != null) {
                        writer.write("<img src=\"");
                        writer.writeFileImageContextURL(messageType.image());
                        writer.write("\">");
                        writer.write("<span class=\"msg\">").writeWithHtmlEscape(tabDef.getTabLabel()).write("</span>");
                    } else if (tabDef.isErrors()) {
                        writer.write("<span class=\"err\">").writeWithHtmlEscape(tabDef.getTabLabel()).write("</span>");
                    } else {
                        writer.writeWithHtmlEscape(tabDef.getTabLabel());
                    }

                    writer.write("</li>");
                }
            }
            writer.write("</ul>");
            writer.write("</div><div class=\"tbody\">");
            Widget tabWidget = tabSheetWidget.getCurrentTabWidget();
            if (tabWidget != null) {
                tabWidget.setValueStore(tabSheetWidget.getValueList().get(tabSheet.getCurrentTabIndex()));
                writer.writeStructureAndContent(tabWidget);
            }
        }

        writer.write("</div>");
        writer.write("</div>");
    }

    @Override
    protected void doWriteBehavior(ResponseWriter writer, Widget widget) throws UnifyException {
        super.doWriteBehavior(writer, widget);
        TabSheetWidget tabSheetWidget = (TabSheetWidget) widget;

        TabSheet tabSheet = tabSheetWidget.getTabSheet();
        if (tabSheet != null && tabSheet.isInStateForDisplay()) {
            Widget tabWidget = tabSheetWidget.getCurrentTabWidget();
            if (tabWidget != null) {
                tabWidget.setValueStore(tabSheetWidget.getValueList().get(tabSheet.getCurrentTabIndex()));
                writer.writeBehavior(tabWidget);
                addPageAlias(tabSheetWidget.getId(), tabWidget);
            }

            // Append tab sheet rigging
            writer.beginFunction("fux.rigTabSheet");
            writer.writeParam("pId", tabSheetWidget.getId());
            writer.writeParam("pContId", tabSheetWidget.getContainerId());
            writer.writeCommandURLParam("pCmdURL");
            writer.writeParam("pTabId", tabSheetWidget.getPrefixedId("tab_"));
            writer.writeParam("pTabCount", tabSheet.getTabCount());
            writer.writeParam("pCurrSel", tabSheet.getCurrentTabIndex());
            writer.endFunction();
        }
    }
}
