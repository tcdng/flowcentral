/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseConfigNamedEntity;
import com.tcdng.unify.core.annotation.Child;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.ListOnly;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.web.ui.constant.MessageType;

/**
 * Application form review policy entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_FORMREVIEWPOLICY")
public class AppFormReviewPolicy extends BaseConfigNamedEntity {

    @ForeignKey(AppForm.class)
    private Long appFormId;

    @ForeignKey
    private MessageType messageType;
    
    @Column(length = 512)
    private String message;

    @Column(length = 64, nullable = true)
    private String errorMatcher;
    
    @Column(name = "FORM_EVENTS", length = 256, nullable = true)
    private String formEvents;
    
    @Column(name = "POLICY_TARGET", length = 256, nullable = true)
    private String target;

    @Child(category = "formreviewpolicy")
    private AppFilter errorCondition;

    @ListOnly(name = "form_entity", key = "appFormId", property = "entity")
    private String entityName;

    @ListOnly(key = "messageType", property = "description")
    private String messageTypeDesc;

    public Long getAppFormId() {
        return appFormId;
    }

    public void setAppFormId(Long appFormId) {
        this.appFormId = appFormId;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorMatcher() {
        return errorMatcher;
    }

    public void setErrorMatcher(String errorMatcher) {
        this.errorMatcher = errorMatcher;
    }

    public String getFormEvents() {
        return formEvents;
    }

    public void setFormEvents(String formEvents) {
        this.formEvents = formEvents;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public AppFilter getErrorCondition() {
        return errorCondition;
    }

    public void setErrorCondition(AppFilter errorCondition) {
        this.errorCondition = errorCondition;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getMessageTypeDesc() {
        return messageTypeDesc;
    }

    public void setMessageTypeDesc(String messageTypeDesc) {
        this.messageTypeDesc = messageTypeDesc;
    }
}
