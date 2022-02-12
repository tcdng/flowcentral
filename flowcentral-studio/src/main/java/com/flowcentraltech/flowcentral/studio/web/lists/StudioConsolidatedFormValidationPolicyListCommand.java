/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.lists;

import com.flowcentraltech.flowcentral.common.business.policies.ConsolidatedFormValidationPolicy;
import com.flowcentraltech.flowcentral.common.web.lists.AbstractEntityTypeListCommand;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.list.StringParam;

/**
 * Studio consolidated form validation policy list command
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("studioconsolidatedformvalidationpolicylist")
public class StudioConsolidatedFormValidationPolicyListCommand
        extends AbstractEntityTypeListCommand<ConsolidatedFormValidationPolicy, StringParam> {

    public StudioConsolidatedFormValidationPolicyListCommand() {
        super(ConsolidatedFormValidationPolicy.class, StringParam.class);
    }

    @Override
    protected String getEntityName(StringParam param) throws UnifyException {
        if (param.isPresent()) {
            return param.getValue();
        }

        return null;
    }

}
