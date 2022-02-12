/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.panels;

import com.flowcentraltech.flowcentral.application.web.data.AppletContext;
import com.flowcentraltech.flowcentral.application.web.widgets.AssignmentPage;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.UplBinding;
import com.tcdng.unify.web.annotation.Action;
import com.tcdng.unify.web.ui.widget.AbstractPanel;

/**
 * Assignment page panel.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-assignmentpagepanel")
@UplBinding("web/application/upl/assignmentpagepanel.upl")
public class AssignmentPagePanel extends AbstractPanel {

    @Override
    public void switchState() throws UnifyException {
        super.switchState();
        AssignmentPage assignmentPage = getValue(AssignmentPage.class);
        assignmentPage.clearDisplayItem();
        AppletContext appCtx = assignmentPage.getCtx();
        if (appCtx.isInWorkflow() && !appCtx.isReview()) {
            assignmentPage.setDisplayItemCounterClass("fc-dispcounterorange");
            assignmentPage.setDisplayItemCounter(
                    resolveSessionMessage("$m{assignmentpage.parentinworkflow.viewonly}"));
        } else {
            assignmentPage.setDisplayItemCounter(
                    resolveSessionMessage("$m{assignmentpage.viewing}"));
        }
    }

    @Action
    public void saveAssignment() throws UnifyException {
        AssignmentPage assignmentPage = getValue(AssignmentPage.class);
        assignmentPage.commitAssignedList(true);
        hintUser("$m{entityformapplet.assignment.success.hint}", assignmentPage.getSubTitle());
    }
}
