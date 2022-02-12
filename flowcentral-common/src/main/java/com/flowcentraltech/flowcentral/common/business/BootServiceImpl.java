/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.common.business;

import java.util.List;

import com.flowcentraltech.flowcentral.common.constants.CommonModuleNameConstants;
import com.flowcentraltech.flowcentral.configuration.business.ConfigurationLoader;
import com.flowcentraltech.flowcentral.configuration.data.FlowCentralInstall;
import com.flowcentraltech.flowcentral.configuration.data.ModuleInstall;
import com.tcdng.unify.core.UnifyComponentConfig;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.application.AbstractBootService;
import com.tcdng.unify.core.application.BootInstallationInfo;
import com.tcdng.unify.core.application.StartupShutdownHook;

/**
 * Application boot service implementation.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component(CommonModuleNameConstants.APPLICATION_BOOTSERVICE)
public class BootServiceImpl extends AbstractBootService<ModuleInstall> {

    @Configurable
    private ConfigurationLoader configurationLoader;

    public void setConfigurationLoader(ConfigurationLoader configurationLoader) {
        this.configurationLoader = configurationLoader;
    }

    @Override
    protected BootInstallationInfo<ModuleInstall> prepareBootInstallation() throws UnifyException {
        FlowCentralInstall flowCentralInstall = configurationLoader.loadMasterModuleInstallation();
        return new BootInstallationInfo<ModuleInstall>(flowCentralInstall.getInstallerList(),
                flowCentralInstall.getModuleInstallList());
    }

    @Override
    protected List<StartupShutdownHook> getStartupShutdownHooks() throws UnifyException {
        return null;
    }

    @Override
    protected void onStartup() throws UnifyException {
        for (UnifyComponentConfig config : getComponentConfigs(PostBootSetup.class)) {
            PostBootSetup postBootSetup = (PostBootSetup) getComponent(config.getName());
            postBootSetup.performPostBootSetup();
        }
    }

    @Override
    protected void onShutdown() throws UnifyException {

    }
}
