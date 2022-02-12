/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.workflow.web.lists;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

import com.flowcentraltech.flowcentral.common.business.policies.WfBinaryPolicy;
import com.flowcentraltech.flowcentral.common.business.policies.WfEnrichmentPolicy;
import com.flowcentraltech.flowcentral.common.business.policies.WfProcessPolicy;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.list.AbstractListCommand;
import com.tcdng.unify.core.list.TypeListFactory;

/**
 * Workflow step policy list command.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("wfsteppolicylist")
public class WfStepPolicyListCommand extends AbstractListCommand<WfStepPolicyParams> {

    @Configurable
    private TypeListFactory typeListFactory;

    public WfStepPolicyListCommand() {
        super(WfStepPolicyParams.class);
    }

    public void setTypeListFactory(TypeListFactory typeListFactory) {
        this.typeListFactory = typeListFactory;
    }

    @Override
    public List<? extends Listable> execute(Locale locale, WfStepPolicyParams params) throws UnifyException {
        if (params.isPresent()) {
            switch (params.getType()) {
                case ENRICHMENT:
                    return typeListFactory.getTypeList(locale, WfEnrichmentPolicy.class);
                case PROCEDURE:
                    return typeListFactory.getTypeList(locale, WfProcessPolicy.class);
                case POLICY_ROUTING:
                    return typeListFactory.getTypeList(locale, WfBinaryPolicy.class);
                case END:
                case ERROR:
                case RECORD_ACTION:
                case BINARY_ROUTING:
                case MULTI_ROUTING:
                case SET_VALUES:
                case START:
                case USER_ACTION:
                default:
                    break;
            }
        }

        return Collections.emptyList();
    }

}
