/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import com.flowcentraltech.flowcentral.application.web.lists.AbstractApplicationListCommand;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.ListData;
import com.tcdng.unify.core.data.Listable;

/**
 * Studio entity reference description list command
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("studioentityrefdesclist")
public class StudioEntityRefDescListCommand extends AbstractApplicationListCommand<RefDescriptionParams> {

    public StudioEntityRefDescListCommand() {
        super(RefDescriptionParams.class);
    }

    @Override
    public List<? extends Listable> execute(Locale locale, RefDescriptionParams params) throws UnifyException {
        if (params.isPresent()) {
            List<Listable> resultList = new ArrayList<Listable>();
            for (String fieldName : applicationService().findForeignEntityStringFields(params.getEntity(),
                    params.getRefField())) {
                resultList.add(new ListData(fieldName, fieldName));
            }

            return resultList;
        }

        return Collections.emptyList();
    }

}
