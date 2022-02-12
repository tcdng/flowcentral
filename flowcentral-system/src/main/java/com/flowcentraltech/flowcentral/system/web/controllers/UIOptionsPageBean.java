/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.system.web.controllers;

import java.util.Arrays;

import com.tcdng.unify.web.ui.AbstractPageBean;

/**
 * User interface options page bean.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class UIOptionsPageBean extends AbstractPageBean {

    private String loginPageTitle;

    private String loginPageSubtitle;

    private byte[] loginHeaderImage;

    private byte[] loginBackImage;
    
    public String getLoginPageTitle() {
        return loginPageTitle;
    }

    public void setLoginPageTitle(String loginPageTitle) {
        this.loginPageTitle = loginPageTitle;
    }

    public String getLoginPageSubtitle() {
        return loginPageSubtitle;
    }

    public void setLoginPageSubtitle(String loginPageSubtitle) {
        this.loginPageSubtitle = loginPageSubtitle;
    }

    public byte[] getLoginHeaderImage() {
        return loginHeaderImage;
    }

    public void setLoginHeaderImage(byte[] loginHeaderImage) {
        this.loginHeaderImage = loginHeaderImage;
    }

    public byte[] getLoginBackImage() {
        return loginBackImage;
    }

    public void setLoginBackImage(byte[] loginBackImage) {
        this.loginBackImage = loginBackImage;
    }

    @Override
    public String toString() {
        return "UIOptionsPageBean [loginPageTitle=" + loginPageTitle + ", loginPageSubtitle=" + loginPageSubtitle
                + ", loginHeaderImage=" + Arrays.toString(loginHeaderImage) + ", loginBackImage="
                + Arrays.toString(loginBackImage) + "]";
    }
    
}
