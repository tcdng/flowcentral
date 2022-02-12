/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.system.business.policies;

import com.flowcentraltech.flowcentral.common.annotation.EntityReferences;
import com.flowcentraltech.flowcentral.common.business.policies.AbstractEntityActionPolicy;
import com.flowcentraltech.flowcentral.common.business.policies.EntityActionContext;
import com.flowcentraltech.flowcentral.common.business.policies.EntityActionResult;
import com.flowcentraltech.flowcentral.system.entities.SystemParameter;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.database.Entity;

/**
 * System parameter update action policy.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@EntityReferences({ "system.sysParam" })
@Component(name = "sysparam-updateactionpolicy", description = "$m{system.entityactionpolicy.sysparamupdate}")
public class SysParamUpdateActionPolicy extends AbstractEntityActionPolicy {

    @Override
    public boolean checkAppliesTo(Entity inst) throws UnifyException {
        return true;
    }

    @Override
    protected void doExecutePreAction(EntityActionContext ctx) throws UnifyException {

    }

    @Override
    protected EntityActionResult doExecutePostAction(EntityActionContext ctx) throws UnifyException {
        SystemParameter systemParameter = (SystemParameter) ctx.getInst();
        EntityActionResult result = new EntityActionResult(ctx);
        // TODO This system parameter code should fetched
        boolean refreshMenu = "APP-0005".equals(systemParameter.getCode());
        result.setRefreshMenu(refreshMenu);
        return result;
    }

}
