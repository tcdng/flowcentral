/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Module configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@XmlRootElement(name = "module")
public class ModuleConfig extends BaseNameConfig {

    private String shortCode;

    private boolean principal;
    
    private ModuleAppsConfig moduleAppsConfig;

    private SysParamsConfig sysParamsConfig;

    public ModuleConfig() {
        this.principal = true;
    }
    
    public String getShortCode() {
        return shortCode;
    }

    @XmlAttribute(required = true)
    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public boolean isPrincipal() {
        return principal;
    }

    @XmlAttribute
    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }

    public ModuleAppsConfig getModuleAppsConfig() {
        return moduleAppsConfig;
    }

    @XmlElement(name = "applications")
    public void setModuleAppsConfig(ModuleAppsConfig moduleAppsConfig) {
        this.moduleAppsConfig = moduleAppsConfig;
    }

    public SysParamsConfig getSysParamsConfig() {
        return sysParamsConfig;
    }

    @XmlElement(name = "sysParameters")
    public void setSysParamsConfig(SysParamsConfig sysParamsConfig) {
        this.sysParamsConfig = sysParamsConfig;
    }

    @Override
    public String toString() {
        return "ModuleConfig [shortCode=" + shortCode + ", principal=" + principal + ", moduleAppsConfig="
                + moduleAppsConfig + ", sysParamsConfig=" + sysParamsConfig + "]";
    }

}
