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
 * Entity action policy.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface EntityActionPolicy extends UnifyComponent {

    /**
     * Checks if entity action applies to instance.
     * 
     * @param inst
     *             the entity instance
     * @return true if action applies otherwise false
     * @throws UnifyException
     *                        if an error occurs
     */
    boolean checkAppliesTo(Entity inst) throws UnifyException;

    /**
     * Executes a pre-action operation.
     * 
     * @param ctx
     *            the entity action context
     * @throws UnifyException
     *                        if an error occurs
     */
    void executePreAction(EntityActionContext ctx) throws UnifyException;

    /**
     * Executes a post-action operation.
     * 
     * @param ctx
     *            the entity action context
     * @return the result object
     * @throws UnifyException
     *                        if an error occurs
     */
    EntityActionResult executePostAction(EntityActionContext ctx) throws UnifyException;
}
