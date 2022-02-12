/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.workflow.web.lists;

import com.tcdng.unify.core.list.AbstractListParam;

/**
 * Workflow recipient policy parameters.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class WfRecipientPolicyParams extends AbstractListParam {

    private String entity;

    private String recipientPolicy;

    public WfRecipientPolicyParams(String entity, String recipientPolicy) {
        this.entity = entity;
        this.recipientPolicy = recipientPolicy;
    }

    public String getRecipientPolicy() {
        return recipientPolicy;
    }

    public String getEntity() {
        return entity;
    }

    @Override
    public boolean isPresent() {
        return recipientPolicy != null && entity != null;
    }

    @Override
    public String toString() {
        return "WfRecipientPolicyParams [entity=" + entity + ", recipientPolicy=" + recipientPolicy + "]";
    }

}
