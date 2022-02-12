/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.system.business;

import java.util.Map;

import com.flowcentraltech.flowcentral.common.constants.SystemSchedTaskConstants;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.constant.LocaleType;
import com.tcdng.unify.core.task.AbstractTaskStatusLogger;
import com.tcdng.unify.core.task.TaskMonitor;

/**
 * Logs the status of a scheduled task.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("scheduledtaskstatuslogger")
public class ScheduledTaskStatusLogger extends AbstractTaskStatusLogger {

    @Configurable
    private SystemModuleService systemService;

    public void setSystemService(SystemModuleService systemService) {
        this.systemService = systemService;
    }

    @Override
    public void logTaskStatus(TaskMonitor taskMonitor, Map<String, Object> parameters) {
        if (taskMonitor.isDone()) {
            Long scheduledTaskId = (Long) parameters.get(SystemSchedTaskConstants.SCHEDULEDTASK_ID);
            Long scheduledTaskHistId = (Long) parameters.get(SystemSchedTaskConstants.SCHEDULEDTASKHIST_ID);
            String errorMsgs = null;
            try {
                Exception[] exceptions = taskMonitor.getExceptions();
                if (exceptions != null && exceptions.length > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (Exception exception : exceptions) {
                        sb.append(getExceptionMessage(LocaleType.APPLICATION, exception));
                        sb.append(getLineSeparator());
                    }
                    errorMsgs = sb.toString();
                }
            } catch (UnifyException e) {
                logError(e);
            }

            try {
                systemService.releaseScheduledTask(scheduledTaskId, scheduledTaskHistId, taskMonitor.getTaskStatus(0),
                        errorMsgs);
            } catch (UnifyException e) {
                logError(e);
            }
        }
    }
}
