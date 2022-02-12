/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.workflow.entities;

import java.util.Date;

import com.flowcentraltech.flowcentral.common.entities.BaseEntity;
import com.flowcentraltech.flowcentral.configuration.constants.WorkflowStepPriority;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ColumnType;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.ListOnly;
import com.tcdng.unify.core.annotation.Table;

/**
 * Workflow item event entity.
 * 
 * @author Lateef Ojulari
 * @version 1.0
 */
@Table(name = "FC_WORKITEMEVENT")
public class WfItemEvent extends BaseEntity {

    @ForeignKey(WfItemHist.class)
    private Long wfItemHistId;

    @ForeignKey
    private WorkflowStepPriority priority;

    @Column(length = 64)
    private String wfStepName;

    @Column(type = ColumnType.TIMESTAMP_UTC)
    private Date stepDt;

    @Column(type = ColumnType.TIMESTAMP_UTC, nullable = true)
    private Date expectedDt;

    @Column(type = ColumnType.TIMESTAMP_UTC, nullable = true)
    private Date criticalDt;

    @Column(type = ColumnType.TIMESTAMP_UTC, nullable = true)
    private Date actionDt;

    @Column(length = 64, nullable = true)
    private String actor;

    @Column(length = 32, nullable = true)
    private String wfAction;

    @Column(name = "ACTOR_COMMENT", length = 512, nullable = true)
    private String comment;

    @Column(length = 64, nullable = true)
    private String prevWfStepName;

    @Column(name = "ERROR_CD", length = 32, nullable = true)
    private String errorCode;

    @Column(name = "ERROR_MSG", length = 512, nullable = true)
    private String errorMsg;

    @ListOnly(key = "wfItemHistId", property = "applicationName")
    private String applicationName;

    @ListOnly(key = "wfItemHistId", property = "workflowName")
    private String workflowName;

    @ListOnly(key = "wfItemHistId", property = "entity")
    private String entity;

    @ListOnly(key = "wfItemHistId", property = "originWorkRecId")
    private Long originWorkRecId;

    @ListOnly(key = "wfItemHistId", property = "itemDesc")
    private String wfItemDesc;

    @ListOnly(key = "wfItemHistId", property = "branchCode")
    private String branchCode;

    @ListOnly(key = "wfItemHistId", property = "departmentCode")
    private String departmentCode;

    @ListOnly(key = "priority", property = "description")
    private String priorityDesc;

    @Override
    public String getDescription() {
        return wfItemDesc;
    }

    public Long getWfItemHistId() {
        return wfItemHistId;
    }

    public void setWfItemHistId(Long wfItemHistId) {
        this.wfItemHistId = wfItemHistId;
    }

    public String getWfStepName() {
        return wfStepName;
    }

    public void setWfStepName(String wfStepName) {
        this.wfStepName = wfStepName;
    }

    public Date getStepDt() {
        return stepDt;
    }

    public void setStepDt(Date stepDt) {
        this.stepDt = stepDt;
    }

    public Date getCriticalDt() {
        return criticalDt;
    }

    public void setCriticalDt(Date criticalDt) {
        this.criticalDt = criticalDt;
    }

    public Date getExpectedDt() {
        return expectedDt;
    }

    public void setExpectedDt(Date expectedDt) {
        this.expectedDt = expectedDt;
    }

    public Date getActionDt() {
        return actionDt;
    }

    public void setActionDt(Date actionDt) {
        this.actionDt = actionDt;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getWfAction() {
        return wfAction;
    }

    public void setWfAction(String wfAction) {
        this.wfAction = wfAction;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPrevWfStepName() {
        return prevWfStepName;
    }

    public void setPrevWfStepName(String prevWfStepName) {
        this.prevWfStepName = prevWfStepName;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
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

    public String getWfItemDesc() {
        return wfItemDesc;
    }

    public void setWfItemDesc(String wfItemDesc) {
        this.wfItemDesc = wfItemDesc;
    }

    public WorkflowStepPriority getPriority() {
        return priority;
    }

    public void setPriority(WorkflowStepPriority priority) {
        this.priority = priority;
    }

    public String getPriorityDesc() {
        return priorityDesc;
    }

    public void setPriorityDesc(String priorityDesc) {
        this.priorityDesc = priorityDesc;
    }
}
