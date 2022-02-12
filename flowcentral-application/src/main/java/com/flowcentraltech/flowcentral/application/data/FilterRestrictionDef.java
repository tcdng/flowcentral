/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.data;

import com.tcdng.unify.core.criterion.FilterConditionType;

/**
 * Filter restriction definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class FilterRestrictionDef {

    private FilterConditionType type;

    private String fieldName;

    private String paramA;

    private String paramB;

    private int depth;

    public FilterRestrictionDef(FilterConditionType type, String fieldName, String paramA, String paramB, int depth) {
        this.type = type;
        this.fieldName = fieldName;
        this.paramA = paramA;
        this.paramB = paramB;
        this.depth = depth;
    }

    public FilterRestrictionDef(FilterConditionType type, int depth) {
        this.type = type;
        this.depth = depth;
    }

    public FilterConditionType getType() {
        return type;
    }

    public boolean isFieldVal() {
        return type.isFieldVal();
    }

    public boolean isParameterVal() {
        return type.isParameterVal();
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getParamA() {
        return paramA;
    }

    public String getParamB() {
        return paramB;
    }

    public int getDepth() {
        return depth;
    }

    public boolean isCompound() {
        return type.isCompound();
    }

    @Override
    public String toString() {
        return "FilterRestrictionDef [type=" + type + ", fieldName=" + fieldName + ", paramA=" + paramA + ", paramB="
                + paramB + ", depth=" + depth + "]";
    }

}
