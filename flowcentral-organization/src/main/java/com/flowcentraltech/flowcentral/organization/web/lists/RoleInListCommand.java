/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.organization.web.lists;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

import com.flowcentraltech.flowcentral.organization.entities.RoleQuery;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.web.data.AssignParams;

/**
 * Role in list command.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("roleinlist")
public class RoleInListCommand extends AbstractOrganizationListCommand<AssignParams> {

    public RoleInListCommand() {
        super(AssignParams.class);
    }

    @Override
    public List<? extends Listable> execute(Locale locale, AssignParams params) throws UnifyException {
        if (params.isAssignedIdList()) {
            RoleQuery query = new RoleQuery();
            query.idIn(params.getAssignedIdList(Long.class));
            query.addSelect("id", "description").addOrder("description");
            return getOrganizationModuleService().findRoles(query);
        }

        return Collections.emptyList();
    }

}
