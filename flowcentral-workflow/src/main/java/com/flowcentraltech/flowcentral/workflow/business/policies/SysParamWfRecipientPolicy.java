/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.workflow.business.policies;

import java.util.Arrays;
import java.util.List;

import com.flowcentraltech.flowcentral.common.business.policies.AbstractWfRecipientPolicy;
import com.flowcentraltech.flowcentral.common.data.Recipient;
import com.flowcentraltech.flowcentral.system.business.SystemModuleService;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.data.ValueStoreReader;

/**
 * System parameter workflow recipient policy
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component(name = "sysparam-wfrecipientpolicy", description = "$m{workflow.recipientpolicy.systemparameter}")
public class SysParamWfRecipientPolicy extends AbstractWfRecipientPolicy {

    @Configurable
    private SystemModuleService systemModuleService;

    public void setSystemModuleService(SystemModuleService systemModuleService) {
        this.systemModuleService = systemModuleService;
    }

    @Override
    public List<Recipient> getRecipients(ValueStoreReader wfItemReader, String recipientNameRule,
            String recipientContactRule) throws UnifyException {
        final String name = systemModuleService.getSysParameterValue(String.class, recipientNameRule);
        final String contact = systemModuleService.getSysParameterValue(String.class, recipientContactRule);
        return Arrays.asList(new Recipient(name, contact));
    }

}
