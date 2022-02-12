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

import com.flowcentraltech.flowcentral.application.entities.AppFormAnnotationQuery;
import com.flowcentraltech.flowcentral.application.web.lists.AbstractApplicationListCommand;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.list.LongParam;

/**
 * Studio form annotation list command
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("studioformannotationlist")
public class StudioFormAnnotationListCommand extends AbstractApplicationListCommand<LongParam> {

    public StudioFormAnnotationListCommand() {
        super(LongParam.class);
    }

    @Override
    public List<? extends Listable> execute(Locale locale, LongParam longParams) throws UnifyException {
        if (longParams.isPresent()) {
            return applicationService()
                    .findAppFormAnnotations((AppFormAnnotationQuery) new AppFormAnnotationQuery()
                            .appFormId(longParams.getValue()).addSelect("name", "description"));
        }

        return Collections.emptyList();
    }

}
