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

import com.flowcentraltech.flowcentral.organization.entities.PrivilegeQuery;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.util.QueryUtils;
import com.tcdng.unify.web.data.AssignParams;

/**
 * Privilege not in list command.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("privilegenotinlist")
public class PrivilegeNotInListCommand extends AbstractOrganizationListCommand<AssignParams> {

    public PrivilegeNotInListCommand() {
        super(AssignParams.class);
    }

    @Override
    public List<? extends Listable> execute(Locale locale, AssignParams params) throws UnifyException {
        if (QueryUtils.isValidStringCriteria(params.getFilterId1())) {
            PrivilegeQuery query = new PrivilegeQuery();
            query.privilegeCategoryId(params.getFilterId1(Long.class));
            if (QueryUtils.isValidStringCriteria(params.getFilterId2())) {
                query.applicationId(params.getFilterId2(Long.class));
            }

            if (params.isAssignedIdList()) {
                query.idNotIn(params.getAssignedIdList(Long.class));
            }

            query.addSelect("id", "description").addOrder("description").ignoreEmptyCriteria(true);
            return getOrganizationModuleService().findPrivileges(query);
        }

        return Collections.emptyList();
    }

}