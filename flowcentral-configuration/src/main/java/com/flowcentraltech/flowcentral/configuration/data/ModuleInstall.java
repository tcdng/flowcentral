/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.data;

import com.flowcentraltech.flowcentral.configuration.xml.ModuleConfig;
import com.tcdng.unify.core.application.FeatureDefinition;
import com.tcdng.unify.core.task.TaskMonitor;

/**
 * Module installation configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ModuleInstall implements FeatureDefinition {

    private ModuleConfig moduleConfig;

    private TaskMonitor taskMonitor;

    public ModuleInstall(ModuleConfig moduleConfig) {
        this.moduleConfig = moduleConfig;
    }

    public ModuleConfig getModuleConfig() {
        return moduleConfig;
    }

    public TaskMonitor getTaskMonitor() {
        return taskMonitor;
    }

    public void setTaskMonitor(TaskMonitor taskMonitor) {
        this.taskMonitor = taskMonitor;
    }
}
