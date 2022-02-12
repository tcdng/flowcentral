/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.data;

import java.util.List;

/**
 * Flow central installation configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class FlowCentralInstall {

    private List<String> installerList;

    private List<ModuleInstall> moduleInstallList;

    public FlowCentralInstall(List<String> installerList, List<ModuleInstall> moduleInstallList) {
        this.installerList = installerList;
        this.moduleInstallList = moduleInstallList;
    }

    public List<String> getInstallerList() {
        return installerList;
    }

    public List<ModuleInstall> getModuleInstallList() {
        return moduleInstallList;
    }

}
