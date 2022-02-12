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
 * Entity matcher.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface EntityMatcher extends UnifyComponent {

    /**
     * Matches an entity.
     * 
     * @param entityDef
     *                   the entity definition.
     * @param valueStore
     *                   the entity value store
     * @return true if matched, otherwise false
     * @throws UnifyException
     *                        if an error occurs
     */
    boolean match(EntityDef entityDef, ValueStore valueStore) throws UnifyException;
}
