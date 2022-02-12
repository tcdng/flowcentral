/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Module application configuration
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ModuleAppConfig {

    private String name;

    private String shortDescription;

    private String longDescription;

    private String configFile;

    private boolean autoInstall;

    public String getName() {
        return name;
    }

    @XmlAttribute(required = true)
    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    @XmlAttribute(required = true)
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    @XmlAttribute(required = true)
    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getConfigFile() {
        return configFile;
    }

    @XmlAttribute(required = true)
    public void setConfigFile(String configFile) {
        this.configFile = configFile;
    }

    public boolean isAutoInstall() {
        return autoInstall;
    }

    @XmlAttribute
    public void setAutoInstall(boolean autoInstall) {
        this.autoInstall = autoInstall;
    }

    @Override
    public String toString() {
        return "ModuleAppConfig [name=" + name + ", shortDescription=" + shortDescription + ", longDescription="
                + longDescription + ", configFile=" + configFile + ", autoInstall=" + autoInstall + "]";
    }
}
