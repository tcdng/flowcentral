/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.workflow.data;

import com.flowcentraltech.flowcentral.configuration.constants.NotificationType;
import com.flowcentraltech.flowcentral.configuration.constants.WorkflowAlertType;
import com.tcdng.unify.core.util.StringUtils;

/**
 * Workflow alert definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class WfAlertDef {

    private WorkflowAlertType type;

    private NotificationType notificationType;

    private String name;

    private String description;

    private String recipientPolicy;

    private String recipientNameRule;

    private String recipientContactRule;

    private String template;

    private String fireOnPrevStepName;

    private String fireOnCondition;

    public WfAlertDef(WorkflowAlertType type, NotificationType notificationType, String name, String description,
            String recipientPolicy, String recipientNameRule, String recipientContactRule, String template,
            String fireOnPrevStepName, String fireOnCondition) {
        this.type = type;
        this.notificationType = notificationType;
        this.name = name;
        this.description = description;
        this.recipientPolicy = recipientPolicy;
        this.recipientNameRule = recipientNameRule;
        this.recipientContactRule = recipientContactRule;
        this.template = template;
        this.fireOnPrevStepName = fireOnPrevStepName;
        this.fireOnCondition = fireOnCondition;
    }

    public WorkflowAlertType getType() {
        return type;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getRecipientPolicy() {
        return recipientPolicy;
    }

    public boolean isWithRecipientPolicy() {
        return !StringUtils.isBlank(recipientPolicy);
    }

    public String getRecipientNameRule() {
        return recipientNameRule;
    }

    public String getRecipientContactRule() {
        return recipientContactRule;
    }

    public String getTemplate() {
        return template;
    }

    public String getFireOnPrevStepName() {
        return fireOnPrevStepName;
    }

    public boolean isFireAlertOnPreviousStep(String prevStepName) {
        return StringUtils.isBlank(fireOnPrevStepName) || fireOnPrevStepName.equals(prevStepName);
    }

    public boolean isWithFireAlertOnCondition() {
        return fireOnCondition != null;
    }

    public String getFireOnCondition() {
        return fireOnCondition;
    }

    public boolean isPassThrough() {
        return type.isPassThrough();
    }

    public boolean isUserInteract() {
        return type.isUserInteract();
    }

    public boolean isCriticalNotification() {
        return type.isCriticalNotification();
    }

    public boolean isExpirationNotification() {
        return type.isExpirationNotification();
    }

    @Override
    public String toString() {
        return "WfAlertDef [type=" + type + ", notificationType=" + notificationType + ", name=" + name
                + ", description=" + description + ", recipientPolicy=" + recipientPolicy + ", template=" + template
                + ", fireOnPrevStepName=" + fireOnPrevStepName + ", fireOnCondition=" + fireOnCondition + "]";
    }

}
