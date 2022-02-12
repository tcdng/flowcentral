/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.business.policies;

import com.flowcentraltech.flowcentral.common.data.AbstractContext;
import com.flowcentraltech.flowcentral.configuration.constants.RecordActionType;
import com.tcdng.unify.core.database.Entity;

/**
 * Entity action context object.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class EntityActionContext extends AbstractContext {

    private Entity inst;

    private String actionPolicyName;

    private SweepingCommitPolicy sweepingCommitPolicy;

    private RecordActionType actionType;

    private Object entityDef;
    
    private Object result;

    public EntityActionContext(Object entityDef, Entity inst, String actionPolicyName) {
        this.entityDef = entityDef;
        this.inst = inst;
        this.actionPolicyName = actionPolicyName;
    }

    public EntityActionContext(Object entityDef, Entity inst, RecordActionType actionType, SweepingCommitPolicy sweepingCommitPolicy,
            String actionPolicyName) {
        this.entityDef = entityDef;
        this.inst = inst;
        this.actionType = actionType;
        this.sweepingCommitPolicy = sweepingCommitPolicy;
        this.actionPolicyName = actionPolicyName;
    }

    public Object getEntityDef() {
        return entityDef;
    }

    public Entity getInst() {
        return inst;
    }

    public RecordActionType getActionType() {
        return actionType;
    }

    public String getActionPolicyName() {
        return actionPolicyName;
    }

    public boolean isWithActionPolicy() {
        return actionPolicyName != null;
    }

    public SweepingCommitPolicy getSweepingCommitPolicy() {
        return sweepingCommitPolicy;
    }

    public boolean isWithSweepingCommitPolicy() {
        return sweepingCommitPolicy != null;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
