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
import com.flowcentraltech.flowcentral.studio.web.panels.applet.StudioAppFormApplet;
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
 * Studio application form applet controller.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("/studioappformapplet")
@UplBinding("web/studio/upl/studioappformappletpage.upl")
public class StudioAppFormAppletController
        extends AbstractEntityFormAppletController<StudioAppFormApplet, StudioAppFormAppletPageBean> {

    @Configurable
    private StudioModuleService studioModuleService;

    public StudioAppFormAppletController() {
        super(StudioAppFormAppletPageBean.class, Secured.TRUE, ReadOnly.FALSE, ResetOnWrite.FALSE);
    }

    public void setStudioModuleService(StudioModuleService studioModuleService) {
        this.studioModuleService = studioModuleService;
    }

    @Action
    public String designChildItem() throws UnifyException {
        StudioAppFormAppletPageBean pageBean = getPageBean();
        StudioAppFormApplet applet = pageBean.getApplet();
        int childTabIndex = getRequestTarget(int.class);
        applet.designChildItem(childTabIndex);
        return "refreshapplet";
    }

    @Override
    protected void onOpenPage() throws UnifyException {
        super.onOpenPage();

        StudioAppFormAppletPageBean pageBean = getPageBean();
        if (pageBean.getApplet() == null) {
            EventHandler[] formSwitchOnChangeHandlers = getPageWidgetByShortName(Widget.class,
                    "appletPanel.formPanel.switchOnChangeHolder").getUplAttribute(EventHandler[].class, "eventHandler");
            EventHandler[] assnSwitchOnChangeHandlers = getPageWidgetByShortName(Widget.class,
                    "appletPanel.assignmentPanel.switchOnChangeHolder").getUplAttribute(EventHandler[].class,
                            "eventHandler");
            StudioAppFormApplet applet = new StudioAppFormApplet(studioModuleService, getAu(), getPathVariable(),
                    (String) getSessionAttribute(StudioSessionAttributeConstants.CURRENT_APPLICATION_NAME),
                    formSwitchOnChangeHandlers, assnSwitchOnChangeHandlers);
            pageBean.setApplet(applet);
        }
    }

}
