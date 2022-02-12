/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.workflow.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseAuditEntity;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.Index;
import com.tcdng.unify.core.annotation.Table;

/**
 * Workflow item history entity.
 * 
 * @author Lateef Ojulari
 * @version 1.0
 */
@Table(name = "FC_WORKITEMHISTORY",
        indexes = { @Index("applicationName"), @Index("workflowName"), @Index("entity"), @Index("branchCode") })
public class WfItemHist extends BaseAuditEntity {

    @Column(name = "APPLICATION_NM", length = 64)
    private String applicationName;

    @Column(name = "WORKFLOW_NM", length = 128)
    private String workflowName;

    @Column(name = "ENTITY_NM", length = 128)
    private String entity;

    @Column(nullable = true)
    private Long originWorkRecId;

    @Column(name = "BRANCH_CD", nullable = true)
    private String branchCode;

    @Column(name = "DEPARTMENT_CD", nullable = true)
    private String departmentCode;

    @Column(length = 196)
    private String itemDesc;

    @Column(length = 96)
    private String initiatedBy;

    @Override
    public String getDescription() {
        return itemDesc;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getWorkflowName() {
        return workflowName;
    }

    public void setWorkflowName(String workflowName) {
        this.workflowName = workflowName;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public Long getOriginWorkRecId() {
        return originWorkRecId;
    }

    public void setOriginWorkRecId(Long originWorkRecId) {
        this.originWorkRecId = originWorkRecId;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getInitiatedBy() {
        return initiatedBy;
    }

    public void setInitiatedBy(String initiatedBy) {
        this.initiatedBy = initiatedBy;
    }

}
