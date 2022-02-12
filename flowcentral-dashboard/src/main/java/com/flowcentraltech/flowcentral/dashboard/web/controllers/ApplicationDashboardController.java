/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.dashboard.web.controllers;

import java.util.List;

import com.flowcentraltech.flowcentral.application.constants.ApplicationPrivilegeConstants;
import com.flowcentraltech.flowcentral.application.util.PrivilegeNameParts;
import com.flowcentraltech.flowcentral.application.util.PrivilegeNameUtils;
import com.flowcentraltech.flowcentral.common.business.ApplicationPrivilegeManager;
import com.flowcentraltech.flowcentral.dashboard.business.DashboardModuleService;
import com.flowcentraltech.flowcentral.dashboard.data.DashboardDef;
import com.flowcentraltech.flowcentral.dashboard.web.widgets.DashboardSlate;
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
import com.tcdng.unify.web.ui.AbstractPageController;

/**
 * Application dashboard controller.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("/application/dashboard")
@UplBinding("web/dashboard/upl/applicationdashboard.upl")
@ResultMappings({ @ResultMapping(name = "refreshSlate",
        response = { "!hidepopupresponse", "!refreshpanelresponse panels:$l{dashboardSlatePanel}" }) })
public class ApplicationDashboardController extends AbstractPageController<ApplicationDashboardPageBean> {

    @Configurable
    private ApplicationPrivilegeManager applicationPrivilegeManager;

    @Configurable
    private DashboardModuleService dashboardModuleService;

    public ApplicationDashboardController() {
        super(ApplicationDashboardPageBean.class, Secured.TRUE, ReadOnly.FALSE, ResetOnWrite.FALSE);
    }

    public void setApplicationPrivilegeManager(ApplicationPrivilegeManager applicationPrivilegeManager) {
        this.applicationPrivilegeManager = applicationPrivilegeManager;
    }

    public void setDashboardModuleService(DashboardModuleService dashboardModuleService) {
        this.dashboardModuleService = dashboardModuleService;
    }

    @Action
    public String refreshSlate() throws UnifyException {
        return "refreshSlate";
    }

    @Action
    public String loadDashboardSlate() throws UnifyException {
        ApplicationDashboardPageBean pageBean = getPageBean();
        DashboardDef dashboardDef = dashboardModuleService.getDashboardDef(pageBean.getSelDashboard());
        pageBean.setDashboardSlate(new DashboardSlate(dashboardDef));
        return refreshSlate();
    }

    @Override
    protected void onInitPage() throws UnifyException {
        super.onInitPage();
        setPageTitle(resolveSessionMessage("$m{applicationdashboard.dashboard}"));
    }

    @Override
    protected void onOpenPage() throws UnifyException {
        super.onOpenPage();
        getPageRequestContextUtil().considerDefaultFocusOnWidget();
        ApplicationDashboardPageBean pageBean = getPageBean();
        if (pageBean.getDashboardSlate() == null) {
            UserToken userToken = getUserToken();
            List<String> roleDashboardList = applicationPrivilegeManager.findRolePrivileges(
                    ApplicationPrivilegeConstants.APPLICATION_DASHBOARD_CATEGORY_CODE, userToken.getRoleCode());
            if (!roleDashboardList.isEmpty()) {
                PrivilegeNameParts pnp = PrivilegeNameUtils.getPrivilegeNameParts(roleDashboardList.get(0));
                pageBean.setSelDashboard(pnp.getEntityName());
                loadDashboardSlate();
            }
        }
    }

}
