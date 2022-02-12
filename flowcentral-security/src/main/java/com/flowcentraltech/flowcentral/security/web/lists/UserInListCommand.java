/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.security.web.lists;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

import com.flowcentraltech.flowcentral.security.entities.UserQuery;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.web.data.AssignParams;

/**
 * User in list command.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("userinlist")
public class UserInListCommand extends AbstractSecurityListCommand<AssignParams> {

    public UserInListCommand() {
        super(AssignParams.class);
    }

    @Override
    public List<? extends Listable> execute(Locale locale, AssignParams params) throws UnifyException {
        if (params.isAssignedIdList()) {
            UserQuery query = new UserQuery();
            query.idIn(params.getAssignedIdList(Long.class));
            query.addSelect("id", "fullName").addOrder("fullName");
            return getSecurityModuleService().findUsers(query);
        }

        return Collections.emptyList();
    }

}
