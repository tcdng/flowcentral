/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.business;

import com.flowcentraltech.flowcentral.application.data.EntityDef;
import com.tcdng.unify.core.UnifyComponent;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.data.ValueStore;

/**
 * Entity set values generator.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface EntitySetValuesGenerator extends UnifyComponent {

    /**
     * Generates entity value.
     * 
     * @param entityDef
     *                   the entity definition.
     * @param valueStore
     *                   the entity value store
     * @param trigger
     *                   triggering field name
     * @throws UnifyException
     *                        if an error occurs
     */
    void generate(EntityDef entityDef, ValueStore valueStore, String trigger) throws UnifyException;
}
