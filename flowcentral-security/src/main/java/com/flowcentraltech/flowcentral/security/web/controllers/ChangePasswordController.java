/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.security.web.controllers;

import com.flowcentraltech.flowcentral.security.business.SecurityModuleService;
import com.flowcentraltech.flowcentral.security.constants.SecurityModuleAuditConstants;
import com.tcdng.unify.core.UnifyError;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.annotation.UplBinding;
import com.tcdng.unify.core.util.StringUtils;
import com.tcdng.unify.web.annotation.Action;
import com.tcdng.unify.web.annotation.ResultMapping;
import com.tcdng.unify.web.annotation.ResultMappings;
import com.tcdng.unify.web.constant.ReadOnly;
import com.tcdng.unify.web.constant.ResetOnWrite;
import com.tcdng.unify.web.constant.Secured;
import com.tcdng.unify.web.ui.widget.data.Hint.MODE;

/**
 * Change password controller.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("/security/changepassword")
@UplBinding("web/security/upl/changepassword.upl")
@ResultMappings({
    @ResultMapping(name = "refresh", response = { "!refreshpanelresponse panels:$l{changePasswordPanel}" })})
public class ChangePasswordController extends AbstractSecurityPageController<ChangePasswordPageBean> {

    @Configurable
    private SecurityModuleService securityModuleService;

    public ChangePasswordController() {
        super(ChangePasswordPageBean.class, Secured.TRUE, ReadOnly.FALSE, ResetOnWrite.FALSE);
    }

    public void setSecurityModuleService(SecurityModuleService securityModuleService) {
        this.securityModuleService = securityModuleService;
    }

    @Override
    protected void onInitPage() throws UnifyException {
        super.onInitPage();
        setPageTitle(resolveSessionMessage("$m{security.changepassword}"));
    }

    @Action
    public String changePassword() throws UnifyException {
        ChangePasswordPageBean pageBean = getPageBean();
        if (StringUtils.isBlank(pageBean.getOldPassword()) || StringUtils.isBlank(pageBean.getNewPassword())
                || StringUtils.isBlank(pageBean.getConfirmPassword())) {
            hintUser(MODE.ERROR, "$m{security.application.allpasswordfields.required}");
        } else if (pageBean.getOldPassword().equals(pageBean.getNewPassword())) {
            hintUser(MODE.ERROR, "$m{security.application.newandoldpassword.same}");
        } else if (!pageBean.getConfirmPassword().equals(pageBean.getNewPassword())) {
            hintUser(MODE.ERROR, "$m{security.application.newandconfirmpassword.notsame}");
        } else {
            try {
                securityModuleService.changeUserPassword(pageBean.getOldPassword(), pageBean.getNewPassword());
                logUserEvent(SecurityModuleAuditConstants.CHANGE_PASSWORD);
                pageBean.setOldPassword(null);
                pageBean.setNewPassword(null);
                pageBean.setConfirmPassword(null);
                hintUser("$m{security.changepassword.hint.success}");
            } catch (UnifyException e) {
                UnifyError err = e.getUnifyError();
                hintUser(MODE.ERROR, getSessionMessage(err.getErrorCode(), err.getErrorParams()));
            }
        }

        return "refresh";
    }
}
