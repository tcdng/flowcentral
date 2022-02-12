/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.controllers;

import com.flowcentraltech.flowcentral.common.business.LoginUserPhotoGenerator;
import com.flowcentraltech.flowcentral.common.web.controllers.AbstractForwarderPageBean;

/**
 * Application page bean.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ApplicationPageBean extends AbstractForwarderPageBean {

    private LoginUserPhotoGenerator userPhotoGenerator;

    private String workspaceCode;

    private boolean enableMultipleTabs;
    
    public LoginUserPhotoGenerator getUserPhotoGenerator() {
        return userPhotoGenerator;
    }

    public void setUserPhotoGenerator(LoginUserPhotoGenerator userPhotoGenerator) {
        this.userPhotoGenerator = userPhotoGenerator;
    }

    public String getWorkspaceCode() {
        return workspaceCode;
    }

    public void setWorkspaceCode(String workspaceCode) {
        this.workspaceCode = workspaceCode;
    }

    public boolean isEnableMultipleTabs() {
        return enableMultipleTabs;
    }

    public void setEnableMultipleTabs(boolean enableMultipleTabs) {
        this.enableMultipleTabs = enableMultipleTabs;
    }

}
