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
import com.flowcentraltech.flowcentral.security.business.SecurityModuleService;
import com.flowcentraltech.flowcentral.security.entities.User;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.database.Entity;

/**
 * Reset password action policy.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@EntityReferences({ "security.user" })
@Component(name = "resetpassword-actionpolicy", description = "$m{security.entityactionpolicy.resetpassword}")
public class ResetPasswordActionPolicy extends AbstractEntityActionPolicy {

    @Configurable
    private SecurityModuleService securityModuleService;

    public void setSecurityModuleService(SecurityModuleService securityModuleService) {
        this.securityModuleService = securityModuleService;
    }

    @Override
    public boolean checkAppliesTo(Entity inst) throws UnifyException {
        return true;
    }

    @Override
    protected void doExecutePreAction(EntityActionContext ctx) throws UnifyException {
        User user = (User) ctx.getInst();
        logDebug("Executing reset password pre-action policy for user [{0}] ...", user.getFullName());
        securityModuleService.resetUserPassword(user.getId());
    }

    @Override
    protected EntityActionResult doExecutePostAction(EntityActionContext ctx) throws UnifyException {
        User user = (User) ctx.getInst();
        logDebug("Executing reset password post-action policy for user [{0}] ...", user.getFullName());
        EntityActionResult entityActionResult = new EntityActionResult(ctx);
        entityActionResult.setSuccessHint("$m{security.userresetunlock.reset.success.hint}");
        return entityActionResult;
    }

}
