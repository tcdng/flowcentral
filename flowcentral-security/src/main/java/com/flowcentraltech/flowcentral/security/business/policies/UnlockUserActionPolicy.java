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
 * Unlock user action policy.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@EntityReferences({ "security.user" })
@Component(name = "unlockuser-actionpolicy", description = "$m{security.entityactionpolicy.unlockuser}")
public class UnlockUserActionPolicy extends AbstractEntityActionPolicy {

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
        logDebug("Executing unlock user pre-action policy for user [{0}] ...", user.getFullName());
        securityModuleService.unlockUser(user.getId());
    }

    @Override
    protected EntityActionResult doExecutePostAction(EntityActionContext ctx) throws UnifyException {
        User user = (User) ctx.getInst();
        logDebug("Executing unlock user post-action policy for user [{0}] ...", user.getFullName());
        EntityActionResult entityActionResult = new EntityActionResult(ctx);
        entityActionResult.setSuccessHint("$m{security.userresetunlock.unlock.success.hint}");
        return entityActionResult;
    }

}
