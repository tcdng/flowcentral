/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.business.policies;

import java.util.List;

import com.flowcentraltech.flowcentral.common.data.Recipient;
import com.tcdng.unify.core.UnifyComponent;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.data.ValueStoreReader;

/**
 * Workflow item recipient policy.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface WfRecipientPolicy extends UnifyComponent {

    /**
     * Gets a list of recipient based on workflow entity instance.
     * 
     * @param wfItemReader
     *                             the workflow item reader
     * @param recipientNameRule
     *                             recipient name rule
     * @param recipientContactRule
     *                             recipient contact rule
     * @return a list of recipients
     * @throws UnifyException
     *                        if an error occurs
     */
    List<Recipient> getRecipients(ValueStoreReader wfItemReader, String recipientNameRule,
            String recipientContactRule) throws UnifyException;
}
