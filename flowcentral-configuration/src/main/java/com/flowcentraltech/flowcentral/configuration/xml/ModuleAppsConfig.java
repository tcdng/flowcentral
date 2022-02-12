/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * Module applications configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ModuleAppsConfig {

    private List<ModuleAppConfig> moduleAppList;

    public List<ModuleAppConfig> getModuleAppList() {
        return moduleAppList;
    }

    @XmlElement(name = "application", required = true)
    public void setModuleAppList(List<ModuleAppConfig> moduleAppList) {
        this.moduleAppList = moduleAppList;
    }

    @Override
    public String toString() {
        return "ModuleAppsConfig [moduleAppList=" + moduleAppList + "]";
    }

}
