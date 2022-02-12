/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.business;

import com.flowcentraltech.flowcentral.application.data.EntityDef;
import com.flowcentraltech.flowcentral.common.business.policies.EntityActionResult;
import com.flowcentraltech.flowcentral.common.entities.WorkEntity;
import com.tcdng.unify.core.UnifyComponent;
import com.tcdng.unify.core.UnifyException;

/**
 * Application work item utilities.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface ApplicationWorkItemUtilities extends UnifyComponent {

    /**
     * Submit entity instance to workflow channel.
     * 
     * @param entityDef
     *                            the entity definition
     * @param workflowChannelName
     *                            the application workflow channel name
     * @param inst
     *                            the entity instance to submit to workflow
     * @param policyName
     *                            an optional entity action policy name
     * @throws UnifyException
     *                        if workflow is unknown. If instance type does not
     *                        match workflow entity definition. If an error occurs
     */
    EntityActionResult submitToWorkflowChannel(EntityDef entityDef, String workflowChannelName, WorkEntity inst,
            String policyName) throws UnifyException;
}
