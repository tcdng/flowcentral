/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.lists;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

import com.flowcentraltech.flowcentral.application.data.EntityClassDef;
import com.flowcentraltech.flowcentral.application.data.EntityDef;
import com.flowcentraltech.flowcentral.application.data.RefDef;
import com.flowcentraltech.flowcentral.application.util.ApplicationNameUtils;
import com.flowcentraltech.flowcentral.application.util.EntityAssignRuleNameParts;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.database.Entity;
import com.tcdng.unify.core.database.Query;
import com.tcdng.unify.web.data.AssignParams;

/**
 * Role in list command.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("entityinlist")
public class EntityInListCommand extends AbstractApplicationListCommand<AssignParams> {
    
    public EntityInListCommand() {
        super(AssignParams.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<? extends Listable> execute(Locale locale, AssignParams params) throws UnifyException {
        if (params.isAssignedIdList() && params.isWithRule()) {
            EntityAssignRuleNameParts parts = ApplicationNameUtils.getEntityAssignRuleNameParts(params.getRule());
            EntityDef _rootEntityDef = applicationService().getEntityDef(parts.getEntityLongName());
            RefDef _assignRefDef = _rootEntityDef.getFieldDef(parts.getAssignFieldName()).getRefDef();

            EntityClassDef _assignEntityClassDef = applicationService().getEntityClassDef(_assignRefDef.getEntity());
            Query<?> query = Query.of((Class<? extends Entity>) _assignEntityClassDef.getEntityClass());
            query.addAmongst("id", params.getAssignedIdList(Long.class));
            if (parts.isWithDescField()) {
                query.addSelect("id", parts.getDescField()).addOrder(parts.getDescField());
            }

            return environment().listAll(query);
        }

        return Collections.emptyList();
    }

}
