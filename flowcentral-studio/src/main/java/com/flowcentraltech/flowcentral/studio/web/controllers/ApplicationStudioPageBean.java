/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.controllers;

import com.flowcentraltech.flowcentral.common.business.LoginUserPhotoGenerator;
import com.tcdng.unify.web.ui.AbstractPageBean;

/**
 * Application studio page bean.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ApplicationStudioPageBean extends AbstractPageBean {

    private LoginUserPhotoGenerator userPhotoGenerator;

    public LoginUserPhotoGenerator getUserPhotoGenerator() {
        return userPhotoGenerator;
    }

    public void setUserPhotoGenerator(LoginUserPhotoGenerator userPhotoGenerator) {
        this.userPhotoGenerator = userPhotoGenerator;
    }

}
