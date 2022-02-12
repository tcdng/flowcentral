/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.panels.applet;

import com.flowcentraltech.flowcentral.application.business.ApplicationModuleService;
import com.flowcentraltech.flowcentral.application.constants.AppletPropertyConstants;
import com.flowcentraltech.flowcentral.application.constants.ApplicationImportDataTaskConstants;
import com.flowcentraltech.flowcentral.application.data.AppletDef;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.annotation.UplBinding;
import com.tcdng.unify.core.task.TaskSetup;
import com.tcdng.unify.web.annotation.Action;
import com.tcdng.unify.web.ui.widget.data.Hint.MODE;

/**
 * Data import applet panel.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-dataimportappletpanel")
@UplBinding("web/application/upl/dataimportappletpanel.upl")
public class DataImportAppletPanel extends AbstractAppletPanel {

    @Configurable
    private ApplicationModuleService applicationModuleService;

    public void setApplicationModuleService(ApplicationModuleService applicationModuleService) {
        this.applicationModuleService = applicationModuleService;
    }

    @Action
    public void executeImport() throws UnifyException {
        DataImportApplet applet = getDataImportApplet();
        if (applet.getUploadFile() == null) {
            hintUser(MODE.ERROR, "$m{dataimportappletpanel.dataimport.error}");
            return;
        }

        AppletDef appletDef = applicationModuleService.getAppletDef(applet.getAppletName());
        TaskSetup taskSetup = TaskSetup.newBuilder().addTask(ApplicationImportDataTaskConstants.IMPORTDATA_TASK_NAME)
                .setParam(ApplicationImportDataTaskConstants.IMPORTDATA_ENTITY, appletDef.getEntity())
                .setParam(ApplicationImportDataTaskConstants.IMPORTDATA_UPLOADCONFIG,
                        appletDef.getPropDef(AppletPropertyConstants.IMPORTDATA_CONFIGNAME).getValue(String.class))
                .setParam(ApplicationImportDataTaskConstants.IMPORTDATA_UPLOAD_FILE, applet.getUploadFile())
                .setParam(ApplicationImportDataTaskConstants.IMPORTDATA_WITH_HEADER_FLAG, applet.isHasHeader()).logMessages()
                .build();
        String routeToAppletName = appletDef.isProp(AppletPropertyConstants.IMPORTDATA_ROUTETO_APPLETNAME)
                ? appletDef.getPropDef(AppletPropertyConstants.IMPORTDATA_ROUTETO_APPLETNAME).getValue(String.class)
                : null;
        String onSuccessPath = routeToAppletName != null
                ? applicationModuleService.getAppletDef(routeToAppletName).getOpenPath()
                : null;
        launchTaskWithMonitorBox(taskSetup, appletDef.getDescription(), onSuccessPath, null);
    }

    protected DataImportApplet getDataImportApplet() throws UnifyException {
        return getValue(DataImportApplet.class);
    }
}
