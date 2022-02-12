/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.notification.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseAuditEntity;
import com.flowcentraltech.flowcentral.notification.constants.NotificationInboxStatus;
import com.tcdng.unify.core.annotation.Child;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.ListOnly;
import com.tcdng.unify.core.annotation.Table;

/**
 * Notification inbox entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_NOTIFINBOX")
public class NotificationInbox extends BaseAuditEntity {

    @ForeignKey(name = "REC_ST")
    private NotificationInboxStatus status;

    @Column(name = "NOTIF_SUBJECT", length = 96)
    private String subject;

    @Column(length = 96, nullable = true)
    private String actionLink;

    @Column(length = 96, nullable = true)
    private String actionTarget;

    @Column(length = 64)
    private String userLoginId;

    @Child
    private NotificationInboxMessage notificationInboxMessage;

    @ListOnly(key = "status", property = "description")
    private String statusDesc;

    @Override
    public String getDescription() {
        return subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public NotificationInboxStatus getStatus() {
        return status;
    }

    public void setStatus(NotificationInboxStatus status) {
        this.status = status;
    }

    public String getActionLink() {
        return actionLink;
    }

    public void setActionLink(String actionLink) {
        this.actionLink = actionLink;
    }

    public String getActionTarget() {
        return actionTarget;
    }

    public void setActionTarget(String actionTarget) {
        this.actionTarget = actionTarget;
    }

    public String getUserLoginId() {
        return userLoginId;
    }

    public void setUserLoginId(String userLoginId) {
        this.userLoginId = userLoginId;
    }

    public NotificationInboxMessage getNotificationInboxMessage() {
        return notificationInboxMessage;
    }

    public void setNotificationInboxMessage(NotificationInboxMessage notificationInboxMessage) {
        this.notificationInboxMessage = notificationInboxMessage;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

}
