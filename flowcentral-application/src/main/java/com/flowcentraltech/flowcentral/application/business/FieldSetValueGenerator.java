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
 * Field set value generator.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface FieldSetValueGenerator extends UnifyComponent {

    /**
     * Generates a value.
     * 
     * @param entityDef
     *                   the entity definition.
     * @param valueStore
     *                   the entity value store
     * @param rule
     *                   optional generator rule
     * @return the generated value
     * @throws UnifyException
     *                        if an error occurs
     */
    Object generate(EntityDef entityDef, ValueStore valueStore, String rule) throws UnifyException;
}
