/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.web.panels.applet;

import java.util.List;

import com.flowcentraltech.flowcentral.application.business.AppletUtilities;
import com.flowcentraltech.flowcentral.application.constants.AppletPropertyConstants;
import com.flowcentraltech.flowcentral.application.web.widgets.ParamValueEntries;
import com.flowcentraltech.flowcentral.common.data.ParamValuesDef;
import com.flowcentraltech.flowcentral.common.util.CommonInputUtils;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.data.ParamConfig;
import com.tcdng.unify.core.task.TaskManager;

/**
 * Task execution applet.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class TaskExecutionApplet extends AbstractApplet {

    private final String taskTitle;

    private final ParamValueEntries paramValueEntries;

    public TaskExecutionApplet(AppletUtilities au, TaskManager tm, String appletName) throws UnifyException {
        super(au, appletName);
        List<ParamConfig> paramConfigList = tm
                .getTaskParameters(getRootAppletProp(String.class, AppletPropertyConstants.TASKEXECUTION_TASKNAME));
        ParamValuesDef paramValuesDef = CommonInputUtils.getParamValuesDef(paramConfigList);
        paramValueEntries = new ParamValueEntries(paramValuesDef);
        taskTitle = getRootAppletDef().getLabel();
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public ParamValueEntries getParamValueEntries() {
        return paramValueEntries;
    }

}
