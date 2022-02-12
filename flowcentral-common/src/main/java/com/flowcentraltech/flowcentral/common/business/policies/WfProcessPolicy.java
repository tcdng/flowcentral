/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.business.policies;

import com.flowcentraltech.flowcentral.common.business.RuleListComponent;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.data.ValueStoreReader;

/**
 * Workflow process policy.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface WfProcessPolicy extends RuleListComponent {

    /**
     * Executes a process using data from supplied workflow entity instance reader.
     * 
     * @param wfItemReader
     *                           workflow item reader
     * @param rule
     *                           the process rule to use (optional)
     * @throws UnifyException
     *                        if an error occurs
     */
    void execute(ValueStoreReader wfItemReader, String rule) throws UnifyException;
}
