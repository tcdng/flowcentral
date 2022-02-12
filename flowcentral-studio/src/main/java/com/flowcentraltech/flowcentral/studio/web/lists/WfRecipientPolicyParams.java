/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.lists;

import com.tcdng.unify.core.list.AbstractListParam;

/**
 * Workflow recipient policy parameters.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class WfRecipientPolicyParams extends AbstractListParam {

    private String recipientPolicy;

    private Long propertyOwnerId;

    public WfRecipientPolicyParams(String recipientPolicy, Long propertyOwnerId) {
        this.recipientPolicy = recipientPolicy;
        this.propertyOwnerId = propertyOwnerId;
    }

    public String getRecipientPolicy() {
        return recipientPolicy;
    }

    public Long getPropertyOwnerId() {
        return propertyOwnerId;
    }

    @Override
    public boolean isPresent() {
        return recipientPolicy != null && propertyOwnerId != null;
    }

    @Override
    public String toString() {
        return "WfRecipientPolicyParams [recipientPolicy=" + recipientPolicy + ", propertyOwnerId=" + propertyOwnerId
                + "]";
    }

}
