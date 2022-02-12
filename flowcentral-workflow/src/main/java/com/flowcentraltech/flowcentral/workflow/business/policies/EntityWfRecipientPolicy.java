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
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.ValueStoreReader;

/**
 * Entity workflow recipient policy
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component(name = "entity-wfrecipientpolicy", description = "$m{workflow.recipientpolicy.entity}")
public class EntityWfRecipientPolicy extends AbstractWfRecipientPolicy {

    @Override
    public List<Recipient> getRecipients(ValueStoreReader wfItemReader, String recipientNameRule,
            String recipientContactRule) throws UnifyException {
        return Arrays.asList(new Recipient(wfItemReader.read(String.class, recipientNameRule),
                wfItemReader.read(String.class, recipientContactRule)));
    }

}
