/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.dashboard.web.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import com.flowcentraltech.flowcentral.application.constants.ApplicationPrivilegeConstants;
import com.flowcentraltech.flowcentral.application.util.PrivilegeNameUtils;
import com.flowcentraltech.flowcentral.common.business.ApplicationPrivilegeManager;
import com.flowcentraltech.flowcentral.common.business.LicenseProvider;
import com.flowcentraltech.flowcentral.common.business.WorkspacePrivilegeManager;
import com.flowcentraltech.flowcentral.common.constants.FlowCentralSessionAttributeConstants;
import com.flowcentraltech.flowcentral.common.constants.LicenseFeatureCodeConstants;
import com.flowcentraltech.flowcentral.dashboard.data.DashboardDef;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.list.ZeroParams;
import com.tcdng.unify.core.util.DataUtils;

/**
 * Role dashboards list command.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("roledashboardslist")
public class RoleDashboardsListCommand extends AbstractDashboardListCommand<ZeroParams> {

    @Configurable
    private ApplicationPrivilegeManager appPrivilegeManager;

    @Configurable
    private WorkspacePrivilegeManager wkspPrivilegeManager;

    @Configurable
    private LicenseProvider licenseProvider;

    public RoleDashboardsListCommand() {
        super(ZeroParams.class);
    }

    public void setAppPrivilegeManager(ApplicationPrivilegeManager appPrivilegeManager) {
        this.appPrivilegeManager = appPrivilegeManager;
    }

    public void setWkspPrivilegeManager(WorkspacePrivilegeManager wkspPrivilegeManager) {
        this.wkspPrivilegeManager = wkspPrivilegeManager;
    }

    public void setLicenseProvider(LicenseProvider licenseProvider) {
        this.licenseProvider = licenseProvider;
    }

    @Override
    public List<? extends Listable> execute(Locale locale, ZeroParams params) throws UnifyException {
        final boolean isWorkspaceLicensed = licenseProvider != null
                && licenseProvider.isLicensed(LicenseFeatureCodeConstants.APPLICATION_WORKSPACES);
        final String workspaceCode = (String) getSessionAttribute(FlowCentralSessionAttributeConstants.WORKSPACE_CODE);
        List<String> roleDashboardList = appPrivilegeManager.findRolePrivileges(
                ApplicationPrivilegeConstants.APPLICATION_DASHBOARD_CATEGORY_CODE, getUserToken().getRoleCode());
        if (!DataUtils.isBlank(roleDashboardList)) {
            List<Listable> resultList = new ArrayList<Listable>();
            for (String dashboardPrivName : roleDashboardList) {
                if (!isWorkspaceLicensed
                        || wkspPrivilegeManager.isWorkspaceWithPrivilege(workspaceCode, dashboardPrivName)) {
                    DashboardDef dashboardDef = getDashboardModuleService().getDashboardDef(
                            PrivilegeNameUtils.getPrivilegeNameParts(dashboardPrivName).getEntityName());
                    resultList.add(dashboardDef);
                }
            }

            return resultList;
        }

        return Collections.emptyList();
    }

}
