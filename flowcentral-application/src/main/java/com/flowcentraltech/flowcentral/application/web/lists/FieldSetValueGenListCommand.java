/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.flowcentraltech.flowcentral.application.business.FieldSetValueGenerator;
import com.flowcentraltech.flowcentral.application.data.EntityDef;
import com.flowcentraltech.flowcentral.common.web.lists.AbstractEntityTypeListCommand;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.Listable;

/**
 * Field set value generator list command.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fieldsetvaluegenlist")
public class FieldSetValueGenListCommand
        extends AbstractEntityTypeListCommand<FieldSetValueGenerator, EntityDefListParams> {

    public FieldSetValueGenListCommand() {
        super(FieldSetValueGenerator.class, EntityDefListParams.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<? extends Listable> execute(Locale locale, EntityDefListParams params) throws UnifyException {
        List<Listable> list = (List<Listable>) super.execute(locale, params);
        if (params.isPresent()) {
            EntityDef entityDef = params.getEntityDef();
            if (entityDef.isWithExpressions()) {
                if (list.isEmpty()) {
                    return entityDef.getExpressionsListables();
                }

                list = new ArrayList<Listable>(list);
                list.addAll(entityDef.getExpressionsListables());
            }
        }

        return list;
    }

    @Override
    protected String getEntityName(EntityDefListParams param) throws UnifyException {
        if (param.isPresent()) {
            return param.getEntityDef().getLongName();
        }

        return null;
    }

}
