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

package com.flowcentraltech.flowcentral.security.web.controllers;

import java.util.List;
import java.util.Locale;

import com.flowcentraltech.flowcentral.application.web.controllers.AbstractApplicationForwarderController;
import com.flowcentraltech.flowcentral.common.business.LicenseProvider;
import com.flowcentraltech.flowcentral.common.business.WorkspacePrivilegeManager;
import com.flowcentraltech.flowcentral.common.constants.LicenseFeatureCodeConstants;
import com.flowcentraltech.flowcentral.common.data.UserRoleInfo;
import com.flowcentraltech.flowcentral.security.business.SecurityModuleService;
import com.flowcentraltech.flowcentral.security.constants.SecurityModuleAuditConstants;
import com.flowcentraltech.flowcentral.security.constants.SecurityModuleErrorConstants;
import com.flowcentraltech.flowcentral.security.entities.User;
import com.flowcentraltech.flowcentral.system.constants.SystemModuleSysParamConstants;
import com.tcdng.unify.core.ApplicationComponents;
import com.tcdng.unify.core.UnifyError;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.UserToken;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.annotation.UplBinding;
import com.tcdng.unify.core.security.TwoFactorAutenticationService;
import com.tcdng.unify.core.util.StringUtils;
import com.tcdng.unify.web.annotation.Action;
import com.tcdng.unify.web.annotation.ResultMapping;
import com.tcdng.unify.web.annotation.ResultMappings;
import com.tcdng.unify.web.constant.ReadOnly;
import com.tcdng.unify.web.constant.ResetOnWrite;
import com.tcdng.unify.web.constant.Secured;
import com.tcdng.unify.web.ui.widget.control.Table;
import com.tcdng.unify.web.ui.widget.panel.SwitchPanel;

/**
 * User login controller.
 * 
 * @author FlowCentral Technologies Limited
 * @since 1.0
 */
@Component("/security/loginpage")
@UplBinding("web/security/upl/login.upl")
@ResultMappings({
        @ResultMapping(name = "refreshlogin", response = { "!refreshpanelresponse panels:$l{loginSequencePanel}" }),
        @ResultMapping(name = "switchlogin",
                response = { "!hidepopupresponse", "!switchpanelresponse panels:$l{loginSequencePanel.loginPanel}" }),
        @ResultMapping(name = "switchchangepassword",
                response = { "!switchpanelresponse panels:$l{loginSequencePanel.changePasswordPanel}" }),
        @ResultMapping(name = "switchrolepanel", response = { "!showpopupresponse popup:$s{selectRolePanel}" }) })
public class UserLoginController extends AbstractApplicationForwarderController<UserLoginPageBean> {

    @Configurable
    private SecurityModuleService securityModuleService;

    @Configurable
    private LicenseProvider licenseProvider;

    @Configurable
    private WorkspacePrivilegeManager workspacePrivilegeManager;
    
    public UserLoginController() {
        super(UserLoginPageBean.class, Secured.FALSE, ReadOnly.FALSE, ResetOnWrite.FALSE);
    }

    public void setSecurityModuleService(SecurityModuleService securityModuleService) {
        this.securityModuleService = securityModuleService;
    }

    public void setLicenseProvider(LicenseProvider licenseProvider) {
        this.licenseProvider = licenseProvider;
    }

    public void setWorkspacePrivilegeManager(WorkspacePrivilegeManager workspacePrivilegeManager) {
        this.workspacePrivilegeManager = workspacePrivilegeManager;
    }

    @Action
    public String login() throws UnifyException {
        UserLoginPageBean pageBean = getPageBean();
        try {
            Locale loginLocale = null;
            if (pageBean.isLanguage() && StringUtils.isNotBlank(pageBean.getLanguageTag())) {
                loginLocale = Locale.forLanguageTag(pageBean.getLanguageTag());
            }

            User user = securityModuleService.loginUser(pageBean.getUserName(), pageBean.getPassword(), loginLocale);
            pageBean.setUserName(null);
            pageBean.setPassword(null);

            if (!user.isReserved() && pageBean.isIs2FA()) {
                TwoFactorAutenticationService twoFactorAuthService = (TwoFactorAutenticationService) this
                        .getComponent(ApplicationComponents.APPLICATION_TWOFACTORAUTHENTICATIONSERVICE);
                if (!twoFactorAuthService.authenticate(pageBean.getUserName(), pageBean.getToken())) {
                    throw new UnifyException(SecurityModuleErrorConstants.INVALID_ONETIME_PASSWORD);
                }
            }

            logUserEvent(SecurityModuleAuditConstants.LOGIN);
            setLoginMessage(null);

            if (user.isChangeUserPassword()) {
                pageBean.setOldPassword(null);
                pageBean.setNewPassword(null);
                pageBean.setConfirmPassword(null);
                setChgPwdMessage(null);
                return "switchchangepassword";
            }

            return selectRole();
        } catch (UnifyException e) {
            logError(e);
            UnifyError err = e.getUnifyError();
            setLoginMessage(getSessionMessage(err.getErrorCode(), err.getErrorParams()));
        }
        return "refreshlogin";
    }

    @Action
    public String changeUserPassword() throws UnifyException {
        UserLoginPageBean pageBean = getPageBean();
        try {
            setChgPwdMessage(null);
            if (StringUtils.isBlank(pageBean.getOldPassword()) || StringUtils.isBlank(pageBean.getNewPassword())
                    || StringUtils.isBlank(pageBean.getConfirmPassword())) {
                setChgPwdMessage(getSessionMessage("security.application.allpasswordfields.required"));
            } else if (pageBean.getOldPassword().equals(pageBean.getNewPassword())) {
                setChgPwdMessage(getSessionMessage("security.application.newandoldpassword.same"));
            } else if (!pageBean.getConfirmPassword().equals(pageBean.getNewPassword())) {
                setChgPwdMessage(getSessionMessage("security.application.newandconfirmpassword.notsame"));
            } else {
                securityModuleService.changeUserPassword(pageBean.getOldPassword(), pageBean.getNewPassword());
                logUserEvent(SecurityModuleAuditConstants.CHANGE_PASSWORD);
                return selectRole();
            }
        } catch (UnifyException e) {
            UnifyError err = e.getUnifyError();
            if (SecurityModuleErrorConstants.USER_ROLE_NOT_ACTIVE_AT_CURRENTTIME.equals(err.getErrorCode())) {
                setLoginMessage(getSessionMessage(err.getErrorCode(), err.getErrorParams()));
                return "switchlogin";
            }

            setChgPwdMessage(getSessionMessage(err.getErrorCode(), err.getErrorParams()));
        }
        return "switchchangepassword";
    }

    @Action
    public String cancelChangeUserPassword() throws UnifyException {
        UserLoginPageBean pageBean = getPageBean();
        pageBean.setUserName(null);
        pageBean.setPassword(null);
        setLoginMessage(null);
        setChgPwdMessage(null);
        securityModuleService.logoutUser(false);
        return "switchlogin";
    }

    @Action
    public String selectUserRole() throws UnifyException {
        UserLoginPageBean pageBean = getPageBean();
        UserRoleInfo userRoleInfo = pageBean.getUserRoleList().get(getRoleTable().getViewIndex());
        pageBean.setUserRoleList(null);
        try {
            return openApplication(userRoleInfo);
        } catch (UnifyException e) {
            logError(e);
            UnifyError err = e.getUnifyError();
            setLoginMessage(getSessionMessage(err.getErrorCode(), err.getErrorParams()));
        }

        return "switchlogin";
    }

    @Action
    public String cancelSelectUserRole() throws UnifyException {
        return cancelChangeUserPassword();
    }

    @Action
    public String changeLanguage() throws UnifyException {
        UserLoginPageBean pageBean = getPageBean();
        if (StringUtils.isNotBlank(pageBean.getLanguageTag())) {
            getSessionContext().setLocale(Locale.forLanguageTag(pageBean.getLanguageTag()));
        } else {
            getSessionContext().setLocale(pageBean.getOrigLocale());
        }

        return "refreshlogin";
    }

    @Override
    protected void onInitPage() throws UnifyException {
//        UserLoginPageBean pageBean = getPageBean();
//        boolean isLanguage = getSystemModuleService().getSysParameterValue(boolean.class,
//                SecurityModuleSysParamConstants.USE_LOGIN_LOCALE);
//        setPageWidgetVisible("loginPanel.languageField", isLanguage);
//        if (isLanguage) {
//            pageBean.setOrigLocale(getSessionLocale());
//        }
//
//        pageBean.setLanguage(isLanguage);
//
//        boolean is2FA = getSystemModuleService().getSysParameterValue(boolean.class,
//                SecurityModuleSysParamConstants.ENABLE_TWOFACTOR_AUTHENTICATION);
//        setPageWidgetVisible("loginPanel.tokenField", is2FA);
//        pageBean.setIs2FA(is2FA);
        setLoginMessage(null);
        setChgPwdMessage(null);
    }

    @Override
    protected void onIndexPage() throws UnifyException {
        loadUIOptions();
    }

    @Override
    protected void onOpenPage() throws UnifyException {
        UserLoginPageBean pageBean = getPageBean();
        pageBean.setUserName(null);
        pageBean.setPassword(null);
        pageBean.setToken(null);
        pageBean.setNewPassword(null);
        pageBean.setOldPassword(null);
        pageBean.setConfirmPassword(null);
        SwitchPanel switchPanel = (SwitchPanel) getPage().getPanelByShortName("loginSequencePanel");
        switchPanel.switchContent("loginPanel");
        loadUIOptions();
    }

    private void loadUIOptions() throws UnifyException {
        UserLoginPageBean pageBean = getPageBean();
        pageBean.setLoginTitle(getSystemModuleService().getSysParameterValue(String.class,
                SystemModuleSysParamConstants.SYSTEM_LOGINPAGE_TITLE));
        pageBean.setLoginSubtitle(getSystemModuleService().getSysParameterValue(String.class,
                SystemModuleSysParamConstants.SYSTEM_LOGINPAGE_SUBTITLE));
    }

    private String selectRole() throws UnifyException {
        UserLoginPageBean pageBean = getPageBean();
        setLoginMessage(null);
        setChgPwdMessage(null);

        // Get user roles that are active based on current time
        UserToken userToken = getUserToken();
        List<UserRoleInfo> userRoleList = securityModuleService.findConsolidatedUserRoles(userToken.getUserLoginId(),
                securityModuleService.getNow());

        UserRoleInfo userRole = null;
        if (userRoleList.isEmpty()) {
            if (!userToken.isReservedUser()) {
                throw new UnifyException(SecurityModuleErrorConstants.USER_ROLE_NOT_ACTIVE_AT_CURRENTTIME);
            }
        } else {
            if (userRoleList.size() > 1) {
                pageBean.setUserRoleList(userRoleList);
                getRoleTable().reset();
                return "switchrolepanel";
            }
            userRole = userRoleList.get(0);
        }

        return openApplication(userRole);
    }

    private String openApplication(UserRoleInfo userRole) throws UnifyException {
        getSessionContext().removeAllAttributes();

        boolean isWorkspaceLicensed = licenseProvider != null
                && licenseProvider.isLicensed(LicenseFeatureCodeConstants.APPLICATION_WORKSPACES);
        if (userRole != null && isWorkspaceLicensed
                && workspacePrivilegeManager.countRoleWorkspaces(userRole.getRoleCode()) <= 0) {
            throw new UnifyException(SecurityModuleErrorConstants.USER_ROLE_HAS_NO_WORKSPACE, userRole.getRoleDesc());
        }

        return forwardToApplication(userRole);
    }
    
    private Table getRoleTable() throws UnifyException {
        return getPageWidgetByShortName(Table.class, "selectRolePanel.roleTablePanel.contentTbl");
    }

    private void setLoginMessage(String msg) throws UnifyException {
        getPageBean().setLoginMessage(msg);
        setPageWidgetVisible("frmLoginMsg", !StringUtils.isBlank(msg));
    }

    private void setChgPwdMessage(String msg) throws UnifyException {
        getPageBean().setChgPwdMessage(msg);
        setPageWidgetVisible("pwdChangeMsg", !StringUtils.isBlank(msg));
    }
}
