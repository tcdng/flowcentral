/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.lists;

import com.flowcentraltech.flowcentral.common.business.policies.WfEnrichmentPolicy;
import com.flowcentraltech.flowcentral.common.web.lists.AbstractEntityParamTypeListCommand;
import com.tcdng.unify.core.annotation.Component;

/**
 * Workflow editor enrichment policy list command.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("wfeditenrichmentpolicylist")
public class WfEditEnrichmentPolicyListCommand extends AbstractEntityParamTypeListCommand<WfEnrichmentPolicy> {

    public WfEditEnrichmentPolicyListCommand() {
        super(WfEnrichmentPolicy.class);
    }

}
