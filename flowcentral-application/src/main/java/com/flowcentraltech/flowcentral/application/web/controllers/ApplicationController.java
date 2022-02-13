/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.controllers;

import java.util.List;

import com.flowcentraltech.flowcentral.application.constants.ApplicationModuleAuditConstants;
import com.flowcentraltech.flowcentral.application.constants.ApplicationModuleSysParamConstants;
import com.flowcentraltech.flowcentral.application.constants.ApplicationResultMappingConstants;
import com.flowcentraltech.flowcentral.common.business.LicenseProvider;
import com.flowcentraltech.flowcentral.common.business.LoginUserPhotoGenerator;
import com.flowcentraltech.flowcentral.common.business.UserLoginActivityProvider;
import com.flowcentraltech.flowcentral.common.business.WorkspacePrivilegeManager;
import com.flowcentraltech.flowcentral.common.constants.FlowCentralSessionAttributeConstants;
import com.flowcentraltech.flowcentral.common.constants.LicenseFeatureCodeConstants;
import com.flowcentraltech.flowcentral.common.data.UserRoleInfo;
import com.flowcentraltech.flowcentral.common.data.UserRoleOptions;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.UserToken;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.annotation.UplBinding;
import com.tcdng.unify.web.annotation.Action;
import com.tcdng.unify.web.annotation.ResultMapping;
import com.tcdng.unify.web.annotation.ResultMappings;
import com.tcdng.unify.web.constant.ReadOnly;
import com.tcdng.unify.web.constant.ResetOnWrite;
import com.tcdng.unify.web.constant.Secured;
import com.tcdng.unify.web.ui.widget.ContentPanel;
import com.tcdng.unify.web.ui.widget.control.Table;

/**
 * Application controller.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("/application")
@UplBinding("web/application/upl/application.upl")
@ResultMappings({
        @ResultMapping(name = ApplicationResultMappingConstants.SHOW_USERROLE_OPTIONS,
                response = { "!showpopupresponse popup:$s{userRoleOptionsPopup}" }),
        @ResultMapping(name = ApplicationResultMappingConstants.SHOW_USER_DETAILS,
                response = { "!showpopupresponse popup:$s{userDetailsPopup}" }),
        @ResultMapping(name = ApplicationResultMappingConstants.SHOW_ENTITY_SELECT,
                response = { "!showpopupresponse popup:$s{entitySelectPopup}" }),
        @ResultMapping(name = ApplicationResultMappingConstants.FORWARD_TO_HOME,
                response = { "!forwardresponse path:$x{application.web.home}" }),
        @ResultMapping(name = ApplicationResultMappingConstants.REFRESH_WORKSPACE,
                response = { "!hidepopupresponse", "!refreshpanelresponse panels:$l{menuPanel content}" }),
        @ResultMapping(name = ApplicationResultMappingConstants.REFRESH_CONTENT,
                response = { "!hidepopupresponse", "!refreshpanelresponse panels:$l{content}" }) })
public class ApplicationController extends AbstractApplicationForwarderController<ApplicationPageBean> {

    @Configurable
    private WorkspacePrivilegeManager wkspPrivilegeManager;

    @Configurable
    private UserLoginActivityProvider userLoginActivityProvider;

    @Configurable
    private LoginUserPhotoGenerator userPhotoGenerator;

    @Configurable
    private LicenseProvider licenseProvider;

    public ApplicationController() {
        super(ApplicationPageBean.class, Secured.TRUE, ReadOnly.FALSE, ResetOnWrite.FALSE);
    }

    public void setWkspPrivilegeManager(WorkspacePrivilegeManager wkspPrivilegeManager) {
        this.wkspPrivilegeManager = wkspPrivilegeManager;
    }

    public void setUserLoginActivityProvider(UserLoginActivityProvider userLoginActivityProvider) {
        this.userLoginActivityProvider = userLoginActivityProvider;
    }

    public void setUserPhotoGenerator(LoginUserPhotoGenerator userPhotoGenerator) {
        this.userPhotoGenerator = userPhotoGenerator;
    }

    public void setLicenseProvider(LicenseProvider licenseProvider) {
        this.licenseProvider = licenseProvider;
    }

    @Action
    public String changeWorkspace() throws UnifyException {
        ContentPanel contentPanel = getPageWidgetByShortName(ContentPanel.class, "content");
        contentPanel.clearPages();
        setSessionWorkspace();
        return ApplicationResultMappingConstants.REFRESH_WORKSPACE;
    }

    @Action
    public String resolveUserNotification() throws UnifyException {
        // TODO
        return "resolveusernotification";
    }

    @Action
    public String dismissUserNotification() throws UnifyException {
        // TODO
        return hidePopup();
    }

    @Action
    public String dismissUserNotifications() throws UnifyException {
        // TODO
        return cancelUserNotifications();
    }

    @Action
    public String cancelUserNotifications() throws UnifyException {
        // TODO
        return hidePopup();
    }

    @Action
    public String logOut() throws UnifyException {
        logUserEvent(ApplicationModuleAuditConstants.LOGOUT);
        userLoginActivityProvider.logoutUser(true);
        return ApplicationResultMappingConstants.FORWARD_TO_HOME;
    }

    @Action
    public String showUserNotifications() throws UnifyException {
        // TODO
        return noResult();
    }

    @Action
    public String refreshContent() throws UnifyException {
        return ApplicationResultMappingConstants.REFRESH_CONTENT;
    }

    @Action
    public String prepareUserRoleOptions() throws UnifyException {
        UserToken userToken = getUserToken();
        setSessionAttribute(FlowCentralSessionAttributeConstants.USERROLEOPTIONS,
                new UserRoleOptions(userLoginActivityProvider.getAvailableUserRolesActiveNow(userToken.getUserLoginId(),
                        userToken.getRoleCode())));
        return ApplicationResultMappingConstants.SHOW_USERROLE_OPTIONS;
    }

    @Action
    public String showUserDetails() throws UnifyException {
        return ApplicationResultMappingConstants.SHOW_USER_DETAILS;
    }

    @Action
    public String switchUserRole() throws UnifyException {
        UserRoleOptions userRoleOptions = (UserRoleOptions) getSessionAttribute(
                FlowCentralSessionAttributeConstants.USERROLEOPTIONS);
        UserRoleInfo userRoleInfo = userRoleOptions.getUserRoleList().get(
                getPageWidgetByShortName(Table.class, "userRoleOptionsPopup.roleTablePanel.contentTbl").getViewIndex());
        return forwardToApplication(userRoleInfo);
    }

    @Override
    protected void onInitPage() throws UnifyException {
        super.onInitPage();
        ApplicationPageBean pageBean = getPageBean();
        pageBean.setUserPhotoGenerator(userPhotoGenerator);

        final boolean enableMultipleTabs = getSystemModuleService().getSysParameterValue(boolean.class,
                ApplicationModuleSysParamConstants.ENABLE_MULTIPLE_TABS);
        pageBean.setEnableMultipleTabs(enableMultipleTabs);
    }

    @Override
    protected void onIndexPage() throws UnifyException {
        super.onIndexPage();

        final boolean isWorkspaceEnabled = wkspPrivilegeManager != null && licenseProvider != null
                && licenseProvider.isLicensed(LicenseFeatureCodeConstants.APPLICATION_WORKSPACES);
        setPageWidgetVisible("wkspSelPanel", isWorkspaceEnabled);
        if (isWorkspaceEnabled) {
            List<String> workspaceCodes = wkspPrivilegeManager.findRoleWorkspaceCodes(getUserToken().getRoleCode());
            String workspaceCode = workspaceCodes.size() > 0 ? workspaceCodes.get(0) : null;
            getPageBean().setWorkspaceCode(workspaceCode);
            setSessionWorkspace();
        }
    }

    private void setSessionWorkspace() throws UnifyException {
        setSessionAttribute(FlowCentralSessionAttributeConstants.WORKSPACE_CODE, getPageBean().getWorkspaceCode());
    }
}