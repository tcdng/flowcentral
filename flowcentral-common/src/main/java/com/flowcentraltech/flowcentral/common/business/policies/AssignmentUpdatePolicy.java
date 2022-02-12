/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.business.policies;

import com.tcdng.unify.core.UnifyComponent;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.database.Entity;

/**
 * Assignment update policy.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface AssignmentUpdatePolicy extends UnifyComponent {

    /**
     * Executes at the end of an assignment update.
     * 
     * @param entityClass
     *                      the entity class
     * @param baseFieldName
     *                      the base field name
     * @param baseId
     *                      the base (parent) object ID
     * @throws UnifyException
     *                        if an error occurs
     */
    void postUpdate(Class<? extends Entity> entityClass, String baseFieldName, Object baseId) throws UnifyException;

}
