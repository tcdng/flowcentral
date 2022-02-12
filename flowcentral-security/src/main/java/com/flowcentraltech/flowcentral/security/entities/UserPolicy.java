/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.security.entities;

import java.util.Calendar;
import java.util.Date;

import com.flowcentraltech.flowcentral.common.entities.BaseStatusWorkEntityPolicy;
import com.flowcentraltech.flowcentral.security.constants.SecurityModuleSysParamConstants;
import com.flowcentraltech.flowcentral.security.constants.UserWorkflowStatus;
import com.flowcentraltech.flowcentral.system.business.SystemModuleService;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.UserToken;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.database.Entity;

/**
 * User data entity policy.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("userpolicy")
public class UserPolicy extends BaseStatusWorkEntityPolicy {

    @Configurable
    private SystemModuleService systemModuleService;

    public void setSystemModuleService(SystemModuleService systemModuleService) {
        this.systemModuleService = systemModuleService;
    }

    @Override
    public Object preCreate(Entity record, Date now) throws UnifyException {
        User user = (User) record;
        user.setChangePassword(Boolean.TRUE);

        if (user.getPasswordExpires() == null) {
            user.setPasswordExpires(Boolean.TRUE);
        }

        if (user.getLoginLocked() == null) {
            user.setLoginLocked(Boolean.FALSE);
        }

        if (user.getAllowMultipleLogin() == null) {
            user.setAllowMultipleLogin(Boolean.FALSE);
        }

        if (user.getWorkflowStatus() == null) {
            user.setWorkflowStatus(UserWorkflowStatus.NEW);
        }
        
        calcPasswordExpiryDate(user, now);

        user.setLoginAttempts(Integer.valueOf(0));
        user.setLastLoginDt(null);
        return super.preCreate(record, now);
    }

    @Override
    public void preUpdate(Entity record, Date now) throws UnifyException {
        calcPasswordExpiryDate((User) record, now);
        super.preUpdate(record, now);
    }

    private void calcPasswordExpiryDate(User user, Date now) throws UnifyException {
        UserToken userToken = getUserToken();
        if (userToken != null) {
            if (user.getPasswordExpires() && user.getPasswordExpiryDt() == null && systemModuleService
                    .getSysParameterValue(boolean.class, SecurityModuleSysParamConstants.ENABLE_PASSWORD_EXPIRY)) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(now);
                cal.add(Calendar.DAY_OF_YEAR, systemModuleService.getSysParameterValue(int.class,
                        SecurityModuleSysParamConstants.PASSWORD_EXPIRY_DAYS));
                user.setPasswordExpiryDt(cal.getTime());
                return;
            }
        }

        user.setPasswordExpiryDt(null);
    }
}
