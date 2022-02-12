/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.security.business.policies;

import com.flowcentraltech.flowcentral.common.annotation.EntityReferences;
import com.flowcentraltech.flowcentral.common.business.policies.AbstractEntityActionPolicy;
import com.flowcentraltech.flowcentral.common.business.policies.EntityActionContext;
import com.flowcentraltech.flowcentral.common.business.policies.EntityActionResult;
import com.flowcentraltech.flowcentral.security.constants.SecurityModuleSysParamConstants;
import com.flowcentraltech.flowcentral.security.entities.User;
import com.flowcentraltech.flowcentral.system.business.SystemModuleService;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.database.Entity;
import com.tcdng.unify.core.security.OneWayStringCryptograph;
import com.tcdng.unify.core.security.PasswordGenerator;

/**
 * User new action policy.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@EntityReferences({ "security.user" })
@Component(name = "user-newactionpolicy", description = "$m{security.entityactionpolicy.newuser}")
public class UserNewActionPolicy extends AbstractEntityActionPolicy {

    private static final String USER_PASSWORD = "USER_PASSWORD";

    @Configurable
    private SystemModuleService systemModuleService;

    @Configurable("oneway-stringcryptograph")
    private OneWayStringCryptograph passwordCryptograph;

    public void setSystemModuleService(SystemModuleService systemModuleService) {
        this.systemModuleService = systemModuleService;
    }

    public void setPasswordCryptograph(OneWayStringCryptograph passwordCryptograph) {
        this.passwordCryptograph = passwordCryptograph;
    }

    @Override
    public boolean checkAppliesTo(Entity inst) throws UnifyException {
        return true;
    }

    @Override
    protected void doExecutePreAction(EntityActionContext ctx) throws UnifyException {
        User user = (User) ctx.getInst();
        logDebug("Executing new user pre-action policy for user [{0}] ...", user.getFullName());
        PasswordGenerator passwordGenerator = (PasswordGenerator) getComponent(systemModuleService
                .getSysParameterValue(String.class, SecurityModuleSysParamConstants.USER_PASSWORD_GENERATOR));
        int passwordLength = systemModuleService.getSysParameterValue(int.class,
                SecurityModuleSysParamConstants.USER_PASSWORD_LENGTH);

        String password = passwordGenerator.generatePassword(user.getLoginId(), passwordLength);
        user.setPassword(passwordCryptograph.encrypt(password));
        ctx.setAttribute(USER_PASSWORD, password);
    }

    @Override
    protected EntityActionResult doExecutePostAction(EntityActionContext ctx) throws UnifyException {
        User user = (User) ctx.getInst();
        logDebug("Executing new user post-action policy for user [{0}] ...", user.getFullName());
        // TODO Send new password notification
        // String password = (String) ctx.getAttribute(USER_PASSWORD);

        return null;
    }

}
