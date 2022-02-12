/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.studio.web.controllers;

import com.flowcentraltech.flowcentral.application.web.controllers.AbstractEntityFormAppletController;
import com.flowcentraltech.flowcentral.studio.business.StudioModuleService;
import com.flowcentraltech.flowcentral.studio.constants.StudioSessionAttributeConstants;
import com.flowcentraltech.flowcentral.studio.web.panels.applet.StudioAppTableApplet;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.annotation.UplBinding;
import com.tcdng.unify.web.annotation.Action;
import com.tcdng.unify.web.constant.ReadOnly;
import com.tcdng.unify.web.constant.ResetOnWrite;
import com.tcdng.unify.web.constant.Secured;
import com.tcdng.unify.web.ui.widget.EventHandler;
import com.tcdng.unify.web.ui.widget.Widget;

/**
 * Studio application table applet controller.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("/studioapptableapplet")
@UplBinding("web/studio/upl/studioapptableappletpage.upl")
public class StudioAppTableAppletController
        extends AbstractEntityFormAppletController<StudioAppTableApplet, StudioAppTableAppletPageBean> {

    @Configurable
    private StudioModuleService studioModuleService;

    public StudioAppTableAppletController() {
        super(StudioAppTableAppletPageBean.class, Secured.TRUE, ReadOnly.FALSE, ResetOnWrite.FALSE);
    }

    public void setStudioModuleService(StudioModuleService studioModuleService) {
        this.studioModuleService = studioModuleService;
    }

    @Action
    public String designChildItem() throws UnifyException {
        StudioAppTableAppletPageBean pageBean = getPageBean();
        StudioAppTableApplet applet = pageBean.getApplet();
        int childTabIndex = getRequestTarget(int.class);
        applet.designChildItem(childTabIndex);
        return "refreshapplet";
    }

    @Override
    protected void onOpenPage() throws UnifyException {
        super.onOpenPage();

        StudioAppTableAppletPageBean pageBean = getPageBean();
        if (pageBean.getApplet() == null) {
            EventHandler[] formSwitchOnChangeHandlers = getPageWidgetByShortName(Widget.class,
                    "appletPanel.formPanel.switchOnChangeHolder").getUplAttribute(EventHandler[].class, "eventHandler");
            EventHandler[] assnSwitchOnChangeHandlers = getPageWidgetByShortName(Widget.class,
                    "appletPanel.assignmentPanel.switchOnChangeHolder").getUplAttribute(EventHandler[].class,
                            "eventHandler");
            StudioAppTableApplet applet = new StudioAppTableApplet(studioModuleService, getAu(), getPathVariable(),
                    (String) getSessionAttribute(StudioSessionAttributeConstants.CURRENT_APPLICATION_NAME),
                    formSwitchOnChangeHandlers, assnSwitchOnChangeHandlers);
            pageBean.setApplet(applet);
        }
    }

}
