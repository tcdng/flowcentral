/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.security.web.lists;

import java.util.List;
import java.util.Locale;

import com.flowcentraltech.flowcentral.security.entities.UserQuery;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.web.data.AssignParams;

/**
 * User not in list command.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("usernotinlist")
public class UserNotInListCommand extends AbstractSecurityListCommand<AssignParams> {

    public UserNotInListCommand() {
        super(AssignParams.class);
    }

    @Override
    public List<? extends Listable> execute(Locale locale, AssignParams params) throws UnifyException {
        UserQuery query = new UserQuery();
        if (params.isAssignedIdList()) {
            query.idNotIn(params.getAssignedIdList(Long.class));
        }

        query.addSelect("id", "fullName").addOrder("fullName").ignoreEmptyCriteria(true);
        return getSecurityModuleService().findUsers(query);
    }

}
