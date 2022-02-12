/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Application report configuration
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppReportConfig {

    private String configFile;

    public String getConfigFile() {
        return configFile;
    }

    @XmlAttribute(required = true)
    public void setConfigFile(String configFile) {
        this.configFile = configFile;
    }
}
