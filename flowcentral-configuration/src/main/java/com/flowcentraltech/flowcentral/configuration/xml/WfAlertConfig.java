/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.configuration.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.flowcentraltech.flowcentral.configuration.constants.NotificationType;
import com.flowcentraltech.flowcentral.configuration.constants.WorkflowAlertType;
import com.flowcentraltech.flowcentral.configuration.xml.adapter.NotificationTypeXmlAdapter;
import com.flowcentraltech.flowcentral.configuration.xml.adapter.WorkflowAlertTypeXmlAdapter;

/**
 * Workflow alert configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class WfAlertConfig extends BaseNameConfig {

    private WorkflowAlertType type;

    private NotificationType notificationType;

    private String recipientPolicy;

    private String recipientNameRule;

    private String recipientContactRule;

    private String template;

    private String fireOnPrevStepName;

    private String fireOnCondition;

    public WorkflowAlertType getType() {
        return type;
    }

    @XmlJavaTypeAdapter(WorkflowAlertTypeXmlAdapter.class)
    @XmlAttribute(name = "type", required = true)
    public void setType(WorkflowAlertType type) {
        this.type = type;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    @XmlJavaTypeAdapter(NotificationTypeXmlAdapter.class)
    @XmlAttribute(name = "channel", required = true)
    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public String getRecipientPolicy() {
        return recipientPolicy;
    }

    @XmlAttribute
    public void setRecipientPolicy(String recipientPolicy) {
        this.recipientPolicy = recipientPolicy;
    }

    public String getRecipientNameRule() {
        return recipientNameRule;
    }

    @XmlAttribute
    public void setRecipientNameRule(String recipientNameRule) {
        this.recipientNameRule = recipientNameRule;
    }

    public String getRecipientContactRule() {
        return recipientContactRule;
    }

    @XmlAttribute
    public void setRecipientContactRule(String recipientContactRule) {
        this.recipientContactRule = recipientContactRule;
    }

    public String getTemplate() {
        return template;
    }

    @XmlAttribute(required = true)
    public void setTemplate(String template) {
        this.template = template;
    }

    public String getFireOnPrevStepName() {
        return fireOnPrevStepName;
    }

    @XmlAttribute
    public void setFireOnPrevStepName(String fireOnPrevStepName) {
        this.fireOnPrevStepName = fireOnPrevStepName;
    }

    public String getFireOnCondition() {
        return fireOnCondition;
    }

    @XmlAttribute
    public void setFireOnCondition(String fireOnCondition) {
        this.fireOnCondition = fireOnCondition;
    }

}
