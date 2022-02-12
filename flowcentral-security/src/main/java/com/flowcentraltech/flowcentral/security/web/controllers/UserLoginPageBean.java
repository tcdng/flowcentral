/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.security.web.controllers;

import java.util.List;
import java.util.Locale;

import com.flowcentraltech.flowcentral.common.data.UserRoleInfo;
import com.flowcentraltech.flowcentral.common.web.controllers.AbstractForwarderPageBean;

/**
 * User login page bean.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class UserLoginPageBean extends AbstractForwarderPageBean {

    private String userName;

    private String password;

    private String token;

    private String oldPassword;

    private String newPassword;

    private String confirmPassword;

    private String loginMessage;

    private String chgPwdMessage;
    
    private String languageTag;

    private String loginTitle;
    
    private String loginSubtitle;
    
    private List<UserRoleInfo> userRoleList;

    private Locale origLocale;

    private boolean isLanguage;

    private boolean is2FA;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

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

    public String getLoginMessage() {
        return loginMessage;
    }

    public void setLoginMessage(String loginMessage) {
        this.loginMessage = loginMessage;
    }

    public String getChgPwdMessage() {
        return chgPwdMessage;
    }

    public void setChgPwdMessage(String chgPwdMessage) {
        this.chgPwdMessage = chgPwdMessage;
    }

    public String getLanguageTag() {
        return languageTag;
    }

    public void setLanguageTag(String languageTag) {
        this.languageTag = languageTag;
    }

    public String getLoginTitle() {
        return loginTitle;
    }

    public void setLoginTitle(String loginTitle) {
        this.loginTitle = loginTitle;
    }

    public String getLoginSubtitle() {
        return loginSubtitle;
    }

    public void setLoginSubtitle(String loginSubtitle) {
        this.loginSubtitle = loginSubtitle;
    }

    public List<UserRoleInfo> getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(List<UserRoleInfo> userRoleList) {
        this.userRoleList = userRoleList;
    }

    public Locale getOrigLocale() {
        return origLocale;
    }

    public void setOrigLocale(Locale origLocale) {
        this.origLocale = origLocale;
    }

    public boolean isLanguage() {
        return isLanguage;
    }

    public void setLanguage(boolean isLanguage) {
        this.isLanguage = isLanguage;
    }

    public boolean isIs2FA() {
        return is2FA;
    }

    public void setIs2FA(boolean is2fa) {
        is2FA = is2fa;
    }

}
