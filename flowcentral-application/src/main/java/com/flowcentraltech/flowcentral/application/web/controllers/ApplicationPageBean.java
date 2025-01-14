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
package com.flowcentraltech.flowcentral.application.web.controllers;

import com.flowcentraltech.flowcentral.common.business.LoginUserPhotoGenerator;
import com.flowcentraltech.flowcentral.common.web.controllers.AbstractForwarderPageBean;

/**
 * Application page bean.
 * 
 * @author FlowCentral Technologies Limited
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
