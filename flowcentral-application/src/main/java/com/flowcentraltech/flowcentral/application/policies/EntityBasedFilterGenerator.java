/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.policies;

import com.flowcentraltech.flowcentral.common.business.RuleListComponent;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.criterion.Restriction;
import com.tcdng.unify.core.data.ValueStoreReader;

/**
 * Entity based filter generator.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface EntityBasedFilterGenerator extends RuleListComponent {

    /**
     * Generates restriction base on supplied entity instance.
     * 
     * @param entityInstReader
     *                         entity instance reader
     * @param rule
     *                         the process rule to use (optional)
     * @throws UnifyException
     *                        if an error occurs
     */
    Restriction generate(ValueStoreReader entityInstReader, String rule) throws UnifyException;
}
