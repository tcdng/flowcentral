/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.business;

import com.flowcentraltech.flowcentral.configuration.data.ApplicationInstall;
import com.flowcentraltech.flowcentral.configuration.data.FlowCentralInstall;
import com.flowcentraltech.flowcentral.configuration.data.NotifTemplateInstall;
import com.flowcentraltech.flowcentral.configuration.data.ReportInstall;
import com.flowcentraltech.flowcentral.configuration.data.WorkflowInstall;
import com.flowcentraltech.flowcentral.configuration.data.WorkflowWizardInstall;
import com.tcdng.unify.core.UnifyComponent;
import com.tcdng.unify.core.UnifyException;

/**
 * Configuration loader component.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface ConfigurationLoader extends UnifyComponent {

    /**
     * Loads master module installation configuration.
     * 
     * @return the master installation configuration
     * @throws UnifyException
     *                        if an error occurs
     */
    FlowCentralInstall loadMasterModuleInstallation() throws UnifyException;

    /**
     * Loads application installation configuration.
     * 
     * @param configFile
     *                   the configuration file
     * @return the application install object
     * @throws UnifyException
     *                        if an error occurs
     */
    ApplicationInstall loadApplicationInstallation(String configFile) throws UnifyException;

    /**
     * Loads report installation configuration.
     * 
     * @param configFile
     *                   the configuration file
     * @return the report installation
     * @throws UnifyException
     *                        if an error occurs
     */
    ReportInstall loadReportInstallation(String configFile) throws UnifyException;

    /**
     * Loads notification template installation configuration.
     * 
     * @param configFile
     *                   the configuration file
     * @return the notification template installation
     * @throws UnifyException
     *                        if an error occurs
     */
    NotifTemplateInstall loadNotifTemplateInstallation(String configFile) throws UnifyException;

    /**
     * Loads workflow installation configuration.
     * 
     * @param configFile
     *                   the configuration file
     * @return the workflow installation
     * @throws UnifyException
     *                        if an error occurs
     */
    WorkflowInstall loadWorkflowInstallation(String configFile) throws UnifyException;

    /**
     * Loads workflow wizard installation configuration.
     * 
     * @param configFile
     *                   the configuration file
     * @return the workflow wizard installation
     * @throws UnifyException
     *                        if an error occurs
     */
    WorkflowWizardInstall loadWorkflowWizardInstallation(String configFile) throws UnifyException;

}
