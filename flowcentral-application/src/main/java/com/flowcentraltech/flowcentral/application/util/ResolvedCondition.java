/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.util;

import com.tcdng.unify.core.criterion.FilterConditionType;

/**
 * Resolve condition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ResolvedCondition {

    private FilterConditionType type;
    
    private Object paramA;
    
    private Object paramB;

    public ResolvedCondition(FilterConditionType type, Object paramA, Object paramB) {
        this.type = type;
        this.paramA = paramA;
        this.paramB = paramB;
    }

    public FilterConditionType getType() {
        return type;
    }

    public Object getParamA() {
        return paramA;
    }

    public Object getParamB() {
        return paramB;
    }
   
}
