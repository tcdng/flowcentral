/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.business;

import com.flowcentraltech.flowcentral.configuration.data.ApplicationInstall;
import com.tcdng.unify.core.UnifyComponent;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.task.TaskMonitor;

/**
 * Application artifact installer.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface ApplicationArtifactInstaller extends UnifyComponent {

    /**
     * Install application artifact.
     * 
     * @param taskMonitor
     *                           the task monitor
     * @param applicationInstall
     *                           the application install object
     * @throws UnifyException
     *                        if an error occurs
     */
    void installApplicationArtifacts(TaskMonitor taskMonitor, ApplicationInstall applicationInstall)
            throws UnifyException;
}
