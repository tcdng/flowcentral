/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.web.controllers;

import com.flowcentraltech.flowcentral.application.constants.ApplicationModuleSysParamConstants;
import com.flowcentraltech.flowcentral.common.constants.FlowCentralSessionAttributeConstants;
import com.flowcentraltech.flowcentral.common.data.UserRoleInfo;
import com.flowcentraltech.flowcentral.common.web.controllers.AbstractForwarderController;
import com.flowcentraltech.flowcentral.common.web.controllers.AbstractForwarderPageBean;
import com.flowcentraltech.flowcentral.system.business.SystemModuleService;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.UserToken;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.web.constant.ReadOnly;
import com.tcdng.unify.web.constant.ResetOnWrite;
import com.tcdng.unify.web.constant.Secured;
import com.tcdng.unify.web.ui.constant.PageRequestParameterConstants;

/**
 * Convenient abstract base class for application forwarder controllers.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractApplicationForwarderController<T extends AbstractForwarderPageBean>
        extends AbstractForwarderController<T> {

    private static final String LAUNCH_STUDIO_WINDOW = "launchStudio";

    @Configurable
    private SystemModuleService systemModuleService;

    public AbstractApplicationForwarderController(Class<T> pageBeanClass, Secured secured, ReadOnly readOnly,
            ResetOnWrite resetOnWrite) {
        super(pageBeanClass, secured, readOnly, resetOnWrite);
    }

    public void setSystemModuleService(SystemModuleService systemModuleService) {
        this.systemModuleService = systemModuleService;
    }

    protected final String forwardToApplication(UserRoleInfo userRoleInfo) throws UnifyException {
        UserToken userToken = getUserToken();
        if (userRoleInfo != null) {
            userToken.setRoleCode(userRoleInfo.getRoleCode());
            userToken.setDepartmentCode(userRoleInfo.getDepartmentCode());
            setSessionAttribute(FlowCentralSessionAttributeConstants.ROLEDESCRIPTION, userRoleInfo.getRoleDesc());
        } else {
            setSessionAttribute(FlowCentralSessionAttributeConstants.ROLEDESCRIPTION, getUserToken().getUserName());
        }

        boolean inStudioWindow = LAUNCH_STUDIO_WINDOW
                .equals(getRequestAttribute(PageRequestParameterConstants.WINDOW_NAME)); // TODO Check if role has
                                                                                         // developer privilege
        String applicationPath = inStudioWindow
                ? systemModuleService.getSysParameterValue(String.class,
                        ApplicationModuleSysParamConstants.STUDIO_APPLICATION)
                : systemModuleService.getSysParameterValue(String.class,
                        ApplicationModuleSysParamConstants.DEFAULT_APPLICATION);
        return forwardToPath(applicationPath);
    }

    protected SystemModuleService getSystemModuleService() {
        return systemModuleService;
    }

}
