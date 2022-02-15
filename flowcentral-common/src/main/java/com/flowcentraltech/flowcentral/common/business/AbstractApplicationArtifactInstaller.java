/*
 * Copyright 2021-2022 FlowCentral Technologies Limited.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.flowcentraltech.flowcentral.common.business;

import com.flowcentraltech.flowcentral.configuration.business.ConfigurationLoader;
import com.tcdng.unify.core.AbstractUnifyComponent;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Configurable;

/**
 * Convenient abstract base class for application artifact installer.
 * 
 * @author FlowCentral Technologies Limited
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
