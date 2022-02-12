/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.web.lists;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.ListData;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.list.AbstractListCommand;
import com.tcdng.unify.core.list.ZeroParams;

/**
 * Link action type list command.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("linkacttypelist")
public class LinkActTypeListCommand extends AbstractListCommand<ZeroParams> {

    private static List<ListData> list;

    public LinkActTypeListCommand() {
        super(ZeroParams.class);
    }

    @Override
    public List<? extends Listable> execute(Locale locale, ZeroParams zeroParams) throws UnifyException {
        if (list == null) {
            synchronized (LinkActTypeListCommand.class) {
                if (list == null) {
                    list = Collections.unmodifiableList(Arrays.asList(
                            new ListData("maintainAct", getApplicationMessage("application.maintain.action")),
                            new ListData("listingAct", getApplicationMessage("application.listing.action")),
                            new ListData("decisionAct", getApplicationMessage("application.decision.action"))));
                }
            }
        }

        return list;
    }

}
