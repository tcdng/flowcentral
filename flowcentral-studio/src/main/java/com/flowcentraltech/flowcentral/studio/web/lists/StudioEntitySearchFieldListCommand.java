/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.lists;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

import com.flowcentraltech.flowcentral.application.data.EntityDef;
import com.flowcentraltech.flowcentral.application.web.lists.AbstractApplicationListCommand;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.list.StringParam;

/**
 * Studio entity search field list command
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("studioentitysearchfieldlist")
public class StudioEntitySearchFieldListCommand extends AbstractApplicationListCommand<StringParam> {

    public StudioEntitySearchFieldListCommand() {
        super(StringParam.class);
    }

    @Override
    public List<? extends Listable> execute(Locale locale, StringParam stringParams) throws UnifyException {
        if (stringParams.isPresent()) {
            EntityDef entityDef = applicationService().getEntityDef(stringParams.getValue());
            return entityDef.getFilterStringFieldDefList();
        }

        return Collections.emptyList();
    }

}
