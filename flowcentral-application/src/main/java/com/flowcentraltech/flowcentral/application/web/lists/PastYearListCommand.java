/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.web.lists;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.ListNumberData;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.list.IntegerParam;

/**
 * Past year list.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("pastyearlist")
public class PastYearListCommand extends AbstractApplicationListCommand<IntegerParam> {

    public PastYearListCommand() {
        super(IntegerParam.class);
    }

    @Override
    public List<? extends Listable> execute(Locale locale, IntegerParam param) throws UnifyException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(applicationService().getNow());
        final int currentYear = cal.get(Calendar.YEAR);
        int start = currentYear;
        if (param.isPresent()) {
            start = param.getValue();
            start = start > currentYear ? currentYear : start;
        }

        List<ListNumberData> list = new ArrayList<ListNumberData>();
        for (int i = currentYear; i >= start; i--) {
            list.add(new ListNumberData(i));
        }

        return list;
    }

}
