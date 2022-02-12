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

import com.flowcentraltech.flowcentral.application.web.lists.AbstractApplicationListCommand;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.list.StringParam;

/**
 * Studio applet create form state policy list command
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("studioappletcreateformstatepolicylist")
public class StudioAppletCreateFormStatePolicyListCommand extends AbstractApplicationListCommand<StringParam> {
    
    public StudioAppletCreateFormStatePolicyListCommand() {
        super(StringParam.class);
    }

    @Override
    public List<? extends Listable> execute(Locale locale, StringParam stringParam) throws UnifyException {
        if (stringParam.isPresent()) {
            return applicationService().getFormDef(stringParam.getValue()).getOnCreateFormStatePolicyDefList();
        }

        return Collections.emptyList();
    }

}
