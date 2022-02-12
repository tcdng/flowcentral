/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.controllers;

import com.flowcentraltech.flowcentral.application.web.panels.applet.CreateEntityApplet;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
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
 * Create entity applet controller.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("/createentityapplet")
@UplBinding("web/application/upl/createentityappletpage.upl")
@ResultMappings({ @ResultMapping(name = "showfileattachments",
        response = { "!validationerrorresponse", "!showpopupresponse popup:$s{fileAttachmentsPopup}" }) })
public class CreateEntityAppletController
        extends AbstractEntityFormAppletController<CreateEntityApplet, CreateEntityAppletPageBean> {

    public CreateEntityAppletController() {
        super(CreateEntityAppletPageBean.class, Secured.TRUE, ReadOnly.FALSE, ResetOnWrite.FALSE);
    }

    @Action
    public String closeFileAttachments() throws UnifyException {
        return "refreshapplet";
    }

    @Override
    protected void onOpenPage() throws UnifyException {
        super.onOpenPage();

        CreateEntityAppletPageBean pageBean = getPageBean();
        if (pageBean.getApplet() == null) {
            EventHandler[] formSwitchOnChangeHandlers = getPageWidgetByShortName(Widget.class,
                    "appletPanel.formPanel.switchOnChangeHolder").getUplAttribute(EventHandler[].class, "eventHandler");
            EventHandler[] assnSwitchOnChangeHandlers = getPageWidgetByShortName(Widget.class,
                    "appletPanel.assignmentPanel.switchOnChangeHolder").getUplAttribute(EventHandler[].class,
                            "eventHandler");
            CreateEntityApplet applet = new CreateEntityApplet(getAu(), getPathVariable(), formSwitchOnChangeHandlers,
                    assnSwitchOnChangeHandlers);
            pageBean.setApplet(applet);
            if (pageBean.getAltCaption() == null) {
                setPageTitle(applet);
            }
        }
    }

}
