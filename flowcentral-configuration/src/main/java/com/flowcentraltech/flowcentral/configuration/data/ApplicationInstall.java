/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.data;

import com.flowcentraltech.flowcentral.configuration.xml.AppConfig;
import com.tcdng.unify.core.application.FeatureDefinition;

/**
 * Application installation configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ApplicationInstall implements FeatureDefinition {

    private AppConfig applicationConfig;

    private Long applicationId;

    public ApplicationInstall(AppConfig applicationConfig) {
        this.applicationConfig = applicationConfig;
    }

    public AppConfig getApplicationConfig() {
        return applicationConfig;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }
}
