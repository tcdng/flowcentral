/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.security.web.controllers;

import com.tcdng.unify.web.ui.AbstractPageBean;

/**
 * Change password page bean.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ChangePasswordPageBean extends AbstractPageBean {

    private String oldPassword;

    private String newPassword;

    private String confirmPassword;
    
    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

}
