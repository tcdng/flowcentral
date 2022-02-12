/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.panels.applet;

import com.flowcentraltech.flowcentral.application.constants.AppletPropertyConstants;
import com.flowcentraltech.flowcentral.application.web.widgets.ParamValueEntries;
import com.flowcentraltech.flowcentral.application.web.widgets.ParamValueEntry;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.UplBinding;
import com.tcdng.unify.core.task.TaskSetup;
import com.tcdng.unify.web.annotation.Action;

/**
 * Task execution applet panel.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-taskexecutionappletpanel")
@UplBinding("web/application/upl/taskexecutionappletpanel.upl")
public class TaskExecutionAppletPanel extends AbstractAppletPanel {

    @Action
    public void executeTask() throws UnifyException {
        TaskExecutionApplet applet = getTaskExecutionApplet();
        TaskSetup.Builder tsb = TaskSetup.newBuilder()
                .addTask(applet.getRootAppletProp(String.class, AppletPropertyConstants.TASKEXECUTION_TASKNAME));
        ParamValueEntries paramValueEntries = applet.getParamValueEntries();
        for (ParamValueEntry entry : paramValueEntries.getEntryList()) {
            tsb.setParam(entry.getParamConfig().getParamName(), entry.getParamInput().getValue());
        }

        tsb.logMessages();
        launchTaskWithMonitorBox(tsb.build(), applet.getTaskTitle());
    }

    protected TaskExecutionApplet getTaskExecutionApplet() throws UnifyException {
        return getValue(TaskExecutionApplet.class);
    }
}
