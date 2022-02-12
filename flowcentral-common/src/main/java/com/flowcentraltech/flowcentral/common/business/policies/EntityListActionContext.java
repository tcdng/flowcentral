/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.business.policies;

import java.util.List;

import com.flowcentraltech.flowcentral.common.data.AbstractContext;
import com.tcdng.unify.core.database.Entity;

/**
 * Entity list action context object.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class EntityListActionContext extends AbstractContext {

    private List<? extends Entity> instList;

    private String policyName;

    private Object result;

    public EntityListActionContext(List<? extends Entity> instList, String policyName) {
        this.instList = instList;
        this.policyName = policyName;
    }

    public List<? extends Entity> getInstList() {
        return instList;
    }

    public String getPolicyName() {
        return policyName;
    }

    public boolean isWithPolicy() {
        return policyName != null;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
