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
import com.tcdng.unify.core.data.ValueStoreWriter;

/**
 * Workflow enrichment policy.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface WfEnrichmentPolicy extends RuleListComponent {

    /**
     * Enriches workflow entity instance using supplied reader and writer.
     * 
     * @param wfItemWriter
     *                           workflow item writer
     * @param wfItemReader
     *                           workflow item reader
     * @param rule
     *                           the enrichment rule to use (optional)
     * @throws UnifyException
     *                        if an error occurs
     */
    void enrich(ValueStoreWriter wfItemWriter, ValueStoreReader wfItemReader, String rule) throws UnifyException;
}
