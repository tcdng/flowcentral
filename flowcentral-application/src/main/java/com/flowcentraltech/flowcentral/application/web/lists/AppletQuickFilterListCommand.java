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

import com.flowcentraltech.flowcentral.application.entities.AppAppletFilterQuery;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.list.LongParam;

/**
 * Applet quick filter list command.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("appletquickfilterlist")
public class AppletQuickFilterListCommand extends AbstractApplicationListCommand<LongParam> {

    public AppletQuickFilterListCommand() {
        super(LongParam.class);
    }

    @Override
    public List<? extends Listable> execute(Locale locale, LongParam longParams) throws UnifyException {
        if (longParams.isPresent()) {
            return applicationService().findAppAppletFilters(
                    (AppAppletFilterQuery) new AppAppletFilterQuery().appAppletId(longParams.getValue())
                            .byOwner(getUserToken().getUserLoginId()).quickFilter(true).orderById());
        }

        return Collections.emptyList();
    }

}
