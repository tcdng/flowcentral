/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.workflow.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseNamedEntity;
import com.flowcentraltech.flowcentral.configuration.constants.NotificationType;
import com.flowcentraltech.flowcentral.configuration.constants.WorkflowAlertType;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.ListOnly;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.annotation.UniqueConstraint;

/**
 * Workflow step alert entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_WORKSTEPALERT", uniqueConstraints = { @UniqueConstraint({ "wfStepId", "name" }),
        @UniqueConstraint({ "wfStepId", "description" }) })
public class WfStepAlert extends BaseNamedEntity {

    @ForeignKey(WfStep.class)
    private Long wfStepId;

    @ForeignKey
    private NotificationType notificationType;

    @ForeignKey(name = "ALERT_TY")
    private WorkflowAlertType type;

    @Column(length = 64, nullable = true)
    private String recipientPolicy;

    @Column(length = 64, nullable = true)
    private String recipientNameRule;

    @Column(length = 64, nullable = true)
    private String recipientContactRule;

    @Column(length = 128)
    private String template;

    @Column(name = "FIRE_ON_PREV_STEP_NM", length = 64, nullable = true)
    private String fireOnPrevStepName;

    @Column(name = "FIRE_ON_CONDITION_NM", length = 64, nullable = true)
    private String fireOnConditionName;

    @ListOnly(key = "wfStepId", property = "description")
    private String wfStepDesc;

    @ListOnly(key = "notificationType", property = "description")
    private String notificationTypeDesc;

    @ListOnly(key = "type", property = "description")
    private String typeDesc;

    public Long getWfStepId() {
        return wfStepId;
    }

    public void setWfStepId(Long wfStepId) {
        this.wfStepId = wfStepId;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public WorkflowAlertType getType() {
        return type;
    }

    public void setType(WorkflowAlertType type) {
        this.type = type;
    }

    public String getRecipientPolicy() {
        return recipientPolicy;
    }

    public void setRecipientPolicy(String recipientPolicy) {
        this.recipientPolicy = recipientPolicy;
    }

    public String getRecipientNameRule() {
        return recipientNameRule;
    }

    public void setRecipientNameRule(String recipientNameRule) {
        this.recipientNameRule = recipientNameRule;
    }

    public String getRecipientContactRule() {
        return recipientContactRule;
    }

    public void setRecipientContactRule(String recipientContactRule) {
        this.recipientContactRule = recipientContactRule;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getFireOnPrevStepName() {
        return fireOnPrevStepName;
    }

    public void setFireOnPrevStepName(String fireOnPrevStepName) {
        this.fireOnPrevStepName = fireOnPrevStepName;
    }

    public String getFireOnConditionName() {
        return fireOnConditionName;
    }

    public void setFireOnConditionName(String fireOnConditionName) {
        this.fireOnConditionName = fireOnConditionName;
    }

    public String getWfStepDesc() {
        return wfStepDesc;
    }

    public void setWfStepDesc(String wfStepDesc) {
        this.wfStepDesc = wfStepDesc;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public String getNotificationTypeDesc() {
        return notificationTypeDesc;
    }

    public void setNotificationTypeDesc(String notificationTypeDesc) {
        this.notificationTypeDesc = notificationTypeDesc;
    }

}
