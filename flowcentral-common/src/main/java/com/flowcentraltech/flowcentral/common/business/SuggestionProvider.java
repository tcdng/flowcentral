/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.business;

import com.tcdng.unify.core.UnifyComponent;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.database.Entity;

/**
 * Suggestion provider implementation.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface SuggestionProvider extends UnifyComponent {

    /**
     * Save suggestions.
     * 
     * @param entityDef
     *                       the entity definition object
     * @param inst
     *                       the entity instance
     * @throws UnifyException
     *                        if an error occurs
     */
    void saveSuggestions(Object entityDef, Entity inst) throws UnifyException;
}
