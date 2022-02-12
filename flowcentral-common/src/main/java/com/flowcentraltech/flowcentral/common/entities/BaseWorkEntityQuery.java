/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.common.entities;

/**
 * Base query object for base work entity sub-classes.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class BaseWorkEntityQuery<T extends BaseWorkEntity> extends BaseAuditEntityQuery<T> {

    public BaseWorkEntityQuery(Class<T> entityClass) {
        super(entityClass);
    }

    public BaseWorkEntityQuery(Class<T> entityClass, boolean applyAppQueryLimit) {
        super(entityClass, applyAppQueryLimit);
    }

    public final BaseWorkEntityQuery<T> workBranchCode(String workBranchCode) {
        return (BaseWorkEntityQuery<T>) addEquals("workBranchCode", workBranchCode);
    }

    public final BaseWorkEntityQuery<T> workBranchCodeIsNull() {
        return (BaseWorkEntityQuery<T>) addIsNull("workBranchCode");
    }

    public final BaseWorkEntityQuery<T> workDepartmentCode(String workDepartmentCode) {
        return (BaseWorkEntityQuery<T>) addEquals("workDepartmentCode", workDepartmentCode);
    }

    public final BaseWorkEntityQuery<T> workDepartmentCodeIsNull() {
        return (BaseWorkEntityQuery<T>) addIsNull("workDepartmentCode");
    }

    public final BaseWorkEntityQuery<T> inWorkflow(boolean inWorkflow) {
        return (BaseWorkEntityQuery<T>) addEquals("inWorkflow", inWorkflow);
    }
}
