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
import com.flowcentraltech.flowcentral.application.policies.EntityBasedFilterGenerator;
import com.flowcentraltech.flowcentral.application.util.ApplicationNameUtils;
import com.flowcentraltech.flowcentral.application.util.EntityAssignRuleNameParts;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.criterion.Restriction;
import com.tcdng.unify.core.data.BeanValueStore;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.database.Entity;
import com.tcdng.unify.core.database.Query;
import com.tcdng.unify.web.data.AssignParams;

/**
 * Entity not in list command.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("entitynotinlist")
public class EntityNotInListCommand extends AbstractApplicationListCommand<AssignParams> {

    public EntityNotInListCommand() {
        super(AssignParams.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<? extends Listable> execute(Locale locale, AssignParams params) throws UnifyException {
        if (params.isWithRule()) {
            EntityAssignRuleNameParts parts = ApplicationNameUtils.getEntityAssignRuleNameParts(params.getRule());
            EntityDef _rootEntityDef = applicationService().getEntityDef(parts.getEntityLongName());
            RefDef _assignRefDef = _rootEntityDef.getFieldDef(parts.getAssignFieldName()).getRefDef();

            EntityClassDef _assignEntityClassDef = applicationService().getEntityClassDef(_assignRefDef.getEntity());
            Query<?> query = Query.of((Class<? extends Entity>) _assignEntityClassDef.getEntityClass());
            if (_assignRefDef.isWithFilterGenerator()) {
                RefDef _baseRefDef = _rootEntityDef.getFieldDef(parts.getBaseFieldName()).getRefDef();
                EntityClassDef _baseEntityClassDef = applicationService().getEntityClassDef(_baseRefDef.getEntity());
                Entity baseInst = environment().listLean(
                        (Class<? extends Entity>) _baseEntityClassDef.getEntityClass(), params.getAssignBaseId());
                Restriction br = ((EntityBasedFilterGenerator) getComponent(_assignRefDef.getFilterGenerator()))
                        .generate(new BeanValueStore(baseInst).getReader(), _assignRefDef.getFilterGeneratorRule());
                query.addRestriction(br);
            } else if (_assignRefDef.isWithFilter()) {
                Restriction br = _assignRefDef.getFilter().getRestriction(_assignEntityClassDef.getEntityDef(), null,
                        applicationService().getNow());
                query.addRestriction(br);
            }

            if (params.isAssignedIdList()) {
                query.addNotAmongst("id", params.getAssignedIdList(Long.class));
            }
            
            if (parts.isWithDescField()) {
                query.addSelect("id", parts.getDescField()).addOrder(parts.getDescField());
            }

            query.ignoreEmptyCriteria(true);

            return environment().listAll(query);
        }

        return Collections.emptyList();
    }

}
