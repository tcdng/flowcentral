/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.system.business.policies;

import java.util.Collections;
import java.util.List;

import com.flowcentraltech.flowcentral.common.business.policies.AbstractParamConfigListProvider;
import com.flowcentraltech.flowcentral.system.constants.SystemModuleNameConstants;
import com.flowcentraltech.flowcentral.system.entities.ScheduledTask;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.data.ParamConfig;
import com.tcdng.unify.core.database.Entity;
import com.tcdng.unify.core.task.TaskManager;
import com.tcdng.unify.core.util.StringUtils;

/**
 * Scheduled task parameter configuration list provider.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component(SystemModuleNameConstants.SCHEDULEDTASK_PARAMCONFIGPROVIDER)
public class ScheduledTaskParamConfigListProvider extends AbstractParamConfigListProvider {

    @Configurable
    private TaskManager taskManager;

    public void setTaskManager(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    @Override
    public String getCategory(Entity entityInst) throws UnifyException {
        return "scheduledtask";
    }

    @Override
    public List<ParamConfig> getParamConfigList(Entity entityInst) throws UnifyException {
        String taskName = entityInst != null ? ((ScheduledTask) entityInst).getTaskName() : null;
        if (!StringUtils.isBlank(taskName)) {
            return taskManager.getTaskParameters(taskName);
        }

        return Collections.emptyList();
    }

}
