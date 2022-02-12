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

import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.list.AbstractListCommand;

/**
 * Entity filter field definition list command.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("entityfilterfielddeflist")
public class EntityFilterFieldDefListCommand extends AbstractListCommand<EntityLabelSuggestionDefListParams> {

    public EntityFilterFieldDefListCommand() {
        super(EntityLabelSuggestionDefListParams.class);
    }

    @Override
    public List<? extends Listable> execute(Locale locale, EntityLabelSuggestionDefListParams params)
            throws UnifyException {
        if (params.isPresent()) {
            return params.getEntityDef().getFilterFieldListables(params.getLabelSuggestionDef());
        }

        return Collections.emptyList();
    }

}
