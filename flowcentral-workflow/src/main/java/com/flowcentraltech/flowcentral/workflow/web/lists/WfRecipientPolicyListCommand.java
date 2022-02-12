/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.workflow.web.lists;

import com.flowcentraltech.flowcentral.common.business.policies.WfRecipientPolicy;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.list.AbstractTypeListCommand;

/**
 * Workflow recipient policy list command.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("wfrecipientpolicylist")
public class WfRecipientPolicyListCommand extends AbstractTypeListCommand<WfRecipientPolicy> {

    public WfRecipientPolicyListCommand() {
        super(WfRecipientPolicy.class);
    }

}
