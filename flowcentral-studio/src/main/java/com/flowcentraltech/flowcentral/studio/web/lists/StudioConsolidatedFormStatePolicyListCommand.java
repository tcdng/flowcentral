/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.lists;

import com.flowcentraltech.flowcentral.common.business.policies.ConsolidatedFormStatePolicy;
import com.flowcentraltech.flowcentral.common.web.lists.AbstractEntityTypeListCommand;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.list.StringParam;

/**
 * Studio consolidated form state policy list command
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("studioconsolidatedformstatepolicylist")
public class StudioConsolidatedFormStatePolicyListCommand
        extends AbstractEntityTypeListCommand<ConsolidatedFormStatePolicy, StringParam> {

    public StudioConsolidatedFormStatePolicyListCommand() {
        super(ConsolidatedFormStatePolicy.class, StringParam.class);
    }

    @Override
    protected String getEntityName(StringParam param) throws UnifyException {
        if (param.isPresent()) {
            return param.getValue();
        }

        return null;
    }

}
