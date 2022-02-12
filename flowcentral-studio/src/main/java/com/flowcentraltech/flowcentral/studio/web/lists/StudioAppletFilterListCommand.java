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

import com.flowcentraltech.flowcentral.application.entities.AppAppletFilter;
import com.flowcentraltech.flowcentral.application.web.lists.AbstractApplicationListCommand;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.ListData;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.list.LongParam;
import com.tcdng.unify.core.util.DataUtils;

/**
 * Studio applet filter list command
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("studioappletfilterlist")
public class StudioAppletFilterListCommand extends AbstractApplicationListCommand<LongParam> {

    public StudioAppletFilterListCommand() {
        super(LongParam.class);
    }

    @Override
    public List<? extends Listable> execute(Locale locale, LongParam longParam) throws UnifyException {
        if (longParam.isPresent()) {
            List<AppAppletFilter> filterList = applicationService().findAppAppletFilters(longParam.getValue());
            if (!DataUtils.isBlank(filterList)) {
                List<ListData> list = new ArrayList<ListData>();
                for (AppAppletFilter filter : filterList) {
                    list.add(new ListData(filter.getName(), filter.getDescription()));
                }
                return list;
            }
        }

        return Collections.emptyList();
    }

}
