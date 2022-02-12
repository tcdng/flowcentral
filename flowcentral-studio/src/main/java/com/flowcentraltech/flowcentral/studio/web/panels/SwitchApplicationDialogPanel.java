/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.studio.web.panels;

import com.flowcentraltech.flowcentral.common.web.panels.BaseDialogPanel;
import com.flowcentraltech.flowcentral.studio.web.data.CreateAppForm;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.UplBinding;
import com.tcdng.unify.core.data.ValueStore;
import com.tcdng.unify.web.ui.widget.panel.SwitchPanel;
import com.tcdng.unify.web.ui.widget.panel.SwitchPanelHandler;

/**
 * Switch application dialog panel.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-switchapplicationdialogpanel")
@UplBinding("web/studio/upl/switchapplicationdialogpanel.upl")
public class SwitchApplicationDialogPanel extends BaseDialogPanel implements SwitchPanelHandler {

    @Override
    public void onPageConstruct() throws UnifyException {
        super.onPageConstruct();
        SwitchPanel switchPanel = getWidgetByShortName(SwitchPanel.class, "searchBaseBodyPanel");
        switchPanel.setSwitchPanelHandler(this);
        setVisible("createAppBtn", false);
        setVisible("entitySearchPanel.reportBtn", false);
    }

    @Override
    public void switchState() throws UnifyException {
        super.switchState();
        setModuleState();
    }

    @Override
    public void handleSwitchContent(SwitchPanel switchPanel, String compShortName, ValueStore valueStore,
            boolean isNewSwitch) throws UnifyException {
        if ("createApplicationBasePanel".equals(compShortName)) {
            setVisible("createAppBtn", true);
            setModuleState();
        } else {
            setVisible("createAppBtn", false);
        }
    }

    private void setModuleState() throws UnifyException {
        CreateAppForm createAppForm = getValue(CreateAppForm.class, "createAppForm");
        if (createAppForm == null || !createAppForm.isCreateModule()) {
            setWidgetVisible("frmModuleId", true);
            setWidgetVisible("frmModuleName", false);
            setWidgetVisible("frmModuleDesc", false);
            setWidgetVisible("frmModuleLabel", false);
            setWidgetVisible("frmModuleShortCode", false);
        } else {
            setWidgetVisible("frmModuleId", false);
            setWidgetVisible("frmModuleName", true);
            setWidgetVisible("frmModuleDesc", true);
            setWidgetVisible("frmModuleLabel", true);
            setWidgetVisible("frmModuleShortCode", true);
        }
    }
}
