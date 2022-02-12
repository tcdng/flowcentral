/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.panels.applet;

import com.flowcentraltech.flowcentral.common.constants.FlowCentralSessionAttributeConstants;
import com.flowcentraltech.flowcentral.common.data.ReportOptions;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.task.TaskLauncher;
import com.tcdng.unify.core.task.TaskMonitor;
import com.tcdng.unify.core.task.TaskSetup;
import com.tcdng.unify.web.UnifyWebSessionAttributeConstants;
import com.tcdng.unify.web.ui.widget.data.TaskMonitorInfo;
import com.tcdng.unify.web.ui.widget.panel.SwitchPanel;

/**
 * Convenient abstract base panel for applet panels.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractAppletPanel extends SwitchPanel {

    @Configurable
    private TaskLauncher taskLauncher;

    public void setTaskLauncher(TaskLauncher taskLauncher) {
        this.taskLauncher = taskLauncher;
    }

    protected void launchTaskWithMonitorBox(TaskSetup taskSetup, String caption) throws UnifyException {
        launchTaskWithMonitorBox(taskSetup, caption, null, null);
    }

    protected void launchTaskWithMonitorBox(TaskSetup taskSetup, String caption, String onSuccessPath,
            String onFailurePath) throws UnifyException {
        TaskMonitor taskMonitor = taskLauncher.launchTask(taskSetup);
        TaskMonitorInfo taskMonitorInfo = new TaskMonitorInfo(taskMonitor, resolveSessionMessage(caption),
                onSuccessPath, onFailurePath);
        setSessionAttribute(UnifyWebSessionAttributeConstants.TASKMONITORINFO, taskMonitorInfo);
        setCommandResultMapping("showapplicationtaskmonitor");
    }

    protected void showReportOptionsBox(ReportOptions reportOptions) throws UnifyException {
        setSessionAttribute(FlowCentralSessionAttributeConstants.REPORTOPTIONS, reportOptions);
        setCommandResultMapping("showapplicationreportoptions");
    }

}
