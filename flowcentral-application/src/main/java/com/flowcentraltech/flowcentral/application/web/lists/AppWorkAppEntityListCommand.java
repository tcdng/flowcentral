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

import com.flowcentraltech.flowcentral.application.entities.AppEntityQuery;
import com.flowcentraltech.flowcentral.application.util.ApplicationNameUtils;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.list.LongParam;

/**
 * Application work application list command.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("appworkappentitylist")
public class AppWorkAppEntityListCommand extends AbstractApplicationListCommand<LongParam> {

    public AppWorkAppEntityListCommand() {
        super(LongParam.class);
    }

    @Override
    public List<? extends Listable> execute(Locale locale, LongParam params) throws UnifyException {
        if (params.isPresent()) {
            return ApplicationNameUtils.getListableList(
                    applicationService().findAppEntities((AppEntityQuery) new AppEntityQuery().isWorkEntity()
                            .applicationId(params.getValue()).addSelect("applicationName", "name", "description")));
        }

        return Collections.emptyList();
    }

}
