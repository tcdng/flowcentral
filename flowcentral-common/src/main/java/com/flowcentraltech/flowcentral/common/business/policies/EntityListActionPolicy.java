/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.business.policies;

import com.tcdng.unify.core.UnifyComponent;
import com.tcdng.unify.core.UnifyException;

/**
 * Entity list action policy.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface EntityListActionPolicy extends UnifyComponent {

    /**
     * Executes action operation on list.
     * 
     * @param ctx
     *            the entity list action context
     * @return the result object
     * @throws UnifyException
     *                        if an error occurs
     */
    EntityListActionResult executeAction(EntityListActionContext ctx) throws UnifyException;

}
