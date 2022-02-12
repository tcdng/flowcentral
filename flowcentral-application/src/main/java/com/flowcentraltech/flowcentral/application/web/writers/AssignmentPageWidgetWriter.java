/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.web.writers;

import com.flowcentraltech.flowcentral.application.web.widgets.AssignmentPageWidget;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Writes;
import com.tcdng.unify.web.ui.widget.Control;
import com.tcdng.unify.web.ui.widget.ResponseWriter;
import com.tcdng.unify.web.ui.widget.Widget;
import com.tcdng.unify.web.ui.widget.writer.AbstractControlWriter;

/**
 * Assignment page widget writer.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Writes(AssignmentPageWidget.class)
@Component("fc-assignmentpage-writer")
public class AssignmentPageWidgetWriter extends AbstractControlWriter {

    @Override
    protected void doWriteStructureAndContent(ResponseWriter writer, Widget widget) throws UnifyException {
        AssignmentPageWidget assignmentPageWidget = (AssignmentPageWidget) widget;
        assignmentPageWidget.getAssignmentBoxCtrl().setEditable( assignmentPageWidget.isContainerEditable());
        writer.write("<div");
        writeTagAttributes(writer, assignmentPageWidget);
        writer.write(">");
        writer.writeStructureAndContent(assignmentPageWidget.getAssignmentBoxCtrl());
        writer.write("</div>");
    }

    @Override
    protected void doWriteBehavior(ResponseWriter writer, Widget widget) throws UnifyException {
        super.doWriteBehavior(writer, widget);
        AssignmentPageWidget assignmentPageWidget = (AssignmentPageWidget) widget;
        Control control = assignmentPageWidget.getAssignmentBoxCtrl();
        control.setEditable( assignmentPageWidget.isContainerEditable());
        writer.writeBehavior(control);
        addPageAlias(assignmentPageWidget.getId(), control);
    }

}
