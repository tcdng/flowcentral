/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.controllers;

import com.flowcentraltech.flowcentral.application.web.panels.applet.TaskExecutionApplet;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.annotation.UplBinding;
import com.tcdng.unify.core.task.TaskManager;
import com.tcdng.unify.web.constant.ReadOnly;
import com.tcdng.unify.web.constant.ResetOnWrite;
import com.tcdng.unify.web.constant.Secured;

/**
 * Task execution applet controller.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("/taskexecutionapplet")
@UplBinding("web/application/upl/taskexecutionappletpage.upl")
public class TaskExecutionAppletController extends AbstractAppletController<TaskExecutionPageBean> {

    @Configurable
    private TaskManager taskManager;

    public TaskExecutionAppletController() {
        super(TaskExecutionPageBean.class, Secured.TRUE, ReadOnly.FALSE, ResetOnWrite.FALSE);
    }

    public void setTaskManager(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    @Override
    protected void onOpenPage() throws UnifyException {
        super.onOpenPage();

        TaskExecutionPageBean pageBean = getPageBean();
        if (pageBean.getApplet() == null) {
            TaskExecutionApplet applet = new TaskExecutionApplet(getAu(), taskManager, getPathVariable());
            pageBean.setApplet(applet);
            setPageTitle(applet);
        }
    }

}
