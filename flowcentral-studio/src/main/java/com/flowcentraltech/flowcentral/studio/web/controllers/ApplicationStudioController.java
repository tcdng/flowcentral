/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.controllers;

import com.flowcentraltech.flowcentral.application.constants.ApplicationModuleAuditConstants;
import com.flowcentraltech.flowcentral.common.business.LoginUserPhotoGenerator;
import com.flowcentraltech.flowcentral.common.business.UserLoginActivityProvider;
import com.flowcentraltech.flowcentral.common.web.controllers.AbstractFlowCentralPageController;
import com.flowcentraltech.flowcentral.studio.constants.StudioSessionAttributeConstants;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.annotation.UplBinding;
import com.tcdng.unify.core.util.QueryUtils;
import com.tcdng.unify.web.annotation.Action;
import com.tcdng.unify.web.annotation.ResultMapping;
import com.tcdng.unify.web.annotation.ResultMappings;
import com.tcdng.unify.web.constant.ReadOnly;
import com.tcdng.unify.web.constant.ResetOnWrite;
import com.tcdng.unify.web.constant.Secured;
import com.tcdng.unify.web.ui.widget.ContentPanel;

/**
 * Application studio controller.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("/applicationstudio")
@UplBinding("web/studio/upl/applicationstudio.upl")
@ResultMappings({
    @ResultMapping(name = "showuserdetails", response = { "!showpopupresponse popup:$s{userDetailsPopup}" }),
    @ResultMapping(name = "forwardtohome", response = { "!forwardresponse path:$x{application.web.home}" })})
public class ApplicationStudioController extends AbstractFlowCentralPageController<ApplicationStudioPageBean> {

    @Configurable
    private LoginUserPhotoGenerator userPhotoGenerator;

    @Configurable
    private UserLoginActivityProvider userLoginActivityProvider;

    public ApplicationStudioController() {
        super(ApplicationStudioPageBean.class, Secured.TRUE, ReadOnly.FALSE, ResetOnWrite.FALSE);
    }

    public void setUserPhotoGenerator(LoginUserPhotoGenerator userPhotoGenerator) {
        this.userPhotoGenerator = userPhotoGenerator;
    }

    public void setUserLoginActivityProvider(UserLoginActivityProvider userLoginActivityProvider) {
        this.userLoginActivityProvider = userLoginActivityProvider;
    }

    @Action
    public String showUserDetails() throws UnifyException {
        return "showuserdetails";
    }

    @Action
    public String logOut() throws UnifyException {
        logUserEvent(ApplicationModuleAuditConstants.LOGOUT);
        userLoginActivityProvider.logoutUser(true);
        return "forwardtohome";
    }

    @Override
    protected void onInitPage() throws UnifyException {
        super.onInitPage();
        ApplicationStudioPageBean pageBean = getPageBean();
        pageBean.setUserPhotoGenerator(userPhotoGenerator);
    }

    @Override
    protected void onIndexPage() throws UnifyException {
        super.onIndexPage();

        Long applicationId = (Long) getSessionAttribute(StudioSessionAttributeConstants.CURRENT_APPLICATION_ID);
        if (!QueryUtils.isValidLongCriteria(applicationId)
                || Boolean.TRUE.equals(removeSessionAttribute(StudioSessionAttributeConstants.CLEAR_PAGES))) {
            ContentPanel contentPanel = getPageWidgetByShortName(ContentPanel.class, "content");
            contentPanel.clearPages();
        }
    }

}
