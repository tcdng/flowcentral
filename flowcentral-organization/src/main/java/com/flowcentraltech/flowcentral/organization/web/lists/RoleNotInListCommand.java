/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.organization.web.lists;

import java.util.List;
import java.util.Locale;

import com.flowcentraltech.flowcentral.organization.entities.RoleQuery;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.web.data.AssignParams;

/**
 * Role not in list command.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("rolenotinlist")
public class RoleNotInListCommand extends AbstractOrganizationListCommand<AssignParams> {

    public RoleNotInListCommand() {
        super(AssignParams.class);
    }

    @Override
    public List<? extends Listable> execute(Locale locale, AssignParams params) throws UnifyException {
        RoleQuery query = new RoleQuery();
        if (params.isAssignedIdList()) {
            query.idNotIn(params.getAssignedIdList(Long.class));
        }

        query.addSelect("id", "description").addOrder("description").ignoreEmptyCriteria(true);
        return getOrganizationModuleService().findRoles(query);
    }

}
