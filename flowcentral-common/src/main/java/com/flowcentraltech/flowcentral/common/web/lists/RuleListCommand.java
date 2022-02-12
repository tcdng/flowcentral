/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.web.lists;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

import com.flowcentraltech.flowcentral.common.business.RuleListComponent;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.list.StringParam;

/**
 * Rule list command.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("rulelist")
public class RuleListCommand extends AbstractFlowCentralListCommand<StringParam> {

    public RuleListCommand() {
        super(StringParam.class);
    }

    @Override
    public List<? extends Listable> execute(Locale locale, StringParam params) throws UnifyException {
        if (params.isPresent()) {
            return ((RuleListComponent) getComponent(params.getValue())).getRuleList(locale);
        }

        return Collections.emptyList();
    }

}
