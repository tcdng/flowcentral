/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.web.lists;

import java.util.List;
import java.util.Locale;

import com.flowcentraltech.flowcentral.application.entities.ApplicationQuery;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.list.ZeroParams;

/**
 * Application list command.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("applicationlist")
public class ApplicationListCommand extends AbstractApplicationListCommand<ZeroParams> {

    public ApplicationListCommand() {
        super(ZeroParams.class);
    }

    @Override
    public List<? extends Listable> execute(Locale locale, ZeroParams zeroParams) throws UnifyException {
        return applicationService()
                .findApplications((ApplicationQuery) new ApplicationQuery().ignoreEmptyCriteria(true));
    }

}
