/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.workflow.web.controllers;

import com.flowcentraltech.flowcentral.application.web.controllers.AbstractEntityFormAppletController;
import com.flowcentraltech.flowcentral.workflow.business.WorkflowModuleService;
import com.flowcentraltech.flowcentral.workflow.web.panels.applet.ReviewWizardWorkItemsApplet;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.annotation.UplBinding;
import com.tcdng.unify.web.annotation.Action;
import com.tcdng.unify.web.annotation.ResultMapping;
import com.tcdng.unify.web.annotation.ResultMappings;
import com.tcdng.unify.web.constant.ReadOnly;
import com.tcdng.unify.web.constant.ResetOnWrite;
import com.tcdng.unify.web.constant.Secured;
import com.tcdng.unify.web.ui.widget.EventHandler;
import com.tcdng.unify.web.ui.widget.Widget;

/**
 * Review wizard work items applet controller.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("/reviewwizardworkitemsapplet")
@UplBinding("web/workflow/upl/reviewwizardworkitemsappletpage.upl")
@ResultMappings({ @ResultMapping(name = "showfileattachments",
        response = { "!validationerrorresponse", "!showpopupresponse popup:$s{fileAttachmentsPopup}" }) })
public class ReviewWizardWorkItemsAppletController
        extends AbstractEntityFormAppletController<ReviewWizardWorkItemsApplet, ReviewWizardWorkItemsAppletPageBean> {

    @Configurable
    private WorkflowModuleService workflowModuleService;

    public ReviewWizardWorkItemsAppletController() {
        super(ReviewWizardWorkItemsAppletPageBean.class, Secured.TRUE, ReadOnly.FALSE, ResetOnWrite.FALSE);
    }

    public void setWorkflowModuleService(WorkflowModuleService workflowModuleService) {
        this.workflowModuleService = workflowModuleService;
    }

    @Action
    public String closeFileAttachments() throws UnifyException {
        return "refreshapplet";
    }

    @Override
    protected void onOpenPage() throws UnifyException {
        super.onOpenPage();

        ReviewWizardWorkItemsAppletPageBean pageBean = getPageBean();
        if (pageBean.getApplet() == null) {
            EventHandler[] formSwitchOnChangeHandlers = getPageWidgetByShortName(Widget.class,
                    "appletPanel.formPanel.switchOnChangeHolder").getUplAttribute(EventHandler[].class, "eventHandler");
            EventHandler[] assnSwitchOnChangeHandlers = getPageWidgetByShortName(Widget.class,
                    "appletPanel.assignmentPanel.switchOnChangeHolder").getUplAttribute(EventHandler[].class,
                            "eventHandler");
            ReviewWizardWorkItemsApplet applet = new ReviewWizardWorkItemsApplet(getAu(), workflowModuleService,
                    getPathVariable(), getUserToken().getUserLoginId(), formSwitchOnChangeHandlers,
                    assnSwitchOnChangeHandlers);
            pageBean.setApplet(applet);
        }
    }

}
