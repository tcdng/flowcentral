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
 * Workflow binary policy.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface WfBinaryPolicy extends RuleListComponent {

    /**
     * Executes a process using data from supplied value store reader.
     * 
     * @param entity the work item entity.
     * 
     * @param wfItemReader
     *                           workflow item reader
     * @param rule
     *                           the binary rule to use (optional)
     * @throws UnifyException
     *                        if an error occurs
     */
    boolean evaluate(ValueStoreReader wfItemReader, String entity, String rule) throws UnifyException;
}
