/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.business;

import com.flowcentraltech.flowcentral.configuration.business.ConfigurationLoader;
import com.tcdng.unify.core.AbstractUnifyComponent;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Configurable;

/**
 * Convenient abstract base class for application artifact installer.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractApplicationArtifactInstaller extends AbstractUnifyComponent
        implements ApplicationArtifactInstaller {

    @Configurable
    private ApplicationPrivilegeManager applicationPrivilegeManager;

    @Configurable
    private ConfigurationLoader configurationLoader;

    @Configurable
    private EnvironmentService environmentService;

    public void setApplicationPrivilegeManager(ApplicationPrivilegeManager applicationPrivilegeManager) {
        this.applicationPrivilegeManager = applicationPrivilegeManager;
    }

    public void setConfigurationLoader(ConfigurationLoader configurationLoader) {
        this.configurationLoader = configurationLoader;
    }

    public void setEnvironmentService(EnvironmentService environmentService) {
        this.environmentService = environmentService;
    }

    @Override
    protected void onInitialize() throws UnifyException {

    }

    @Override
    protected void onTerminate() throws UnifyException {

    }

    protected void registerPrivilege(Long applicationId, String privilegeCategoryCode, String privilegeCode,
            String privilegeDesc) throws UnifyException {
        applicationPrivilegeManager.registerPrivilege(applicationId, privilegeCategoryCode, privilegeCode,
                privilegeDesc);
    }

    protected ConfigurationLoader getConfigurationLoader() {
        return configurationLoader;
    }

    protected EnvironmentService environment() {
        return environmentService;
    }

}
