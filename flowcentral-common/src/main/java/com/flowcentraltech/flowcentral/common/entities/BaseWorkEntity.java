/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.common.entities;

import java.util.List;

import com.tcdng.unify.core.annotation.ChildList;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.Policy;

/**
 * Base class for all work entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Policy("basework-entitypolicy")
public abstract class BaseWorkEntity extends BaseAuditEntity implements WorkEntity {

    @Column(name = "WORK_BRANCH_CD", length = 32, nullable = true)
    private String workBranchCode;

    @Column(name = "WORK_DEPARTMENT_CD", length = 32, nullable = true)
    private String workDepartmentCode;

    @Column
    private boolean inWorkflow;

    @ChildList(category = "work")
    private List<FileAttachment> attachmentList;

    @Override
    public String getWorkflowItemDesc() {
        return getDescription();
    }

    @Override
    public final String getWorkBranchCode() {
        return workBranchCode;
    }

    @Override
    public final void setWorkBranchCode(String workBranchCode) {
        this.workBranchCode = workBranchCode;
    }

    @Override
    public final String getWorkDepartmentCode() {
        return workDepartmentCode;
    }

    @Override
    public final void setWorkDepartmentCode(String workDepartmentCode) {
        this.workDepartmentCode = workDepartmentCode;
    }

    @Override
    public final boolean isInWorkflow() {
        return inWorkflow;
    }

    @Override
    public final void setInWorkflow(boolean inWorkflow) {
        this.inWorkflow = inWorkflow;
    }

    public final List<FileAttachment> getAttachmentList() {
        return attachmentList;
    }

    public final void setAttachmentList(List<FileAttachment> attachmentList) {
        this.attachmentList = attachmentList;
    }

}
