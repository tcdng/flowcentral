/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.notification.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseEntity;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.annotation.UniqueConstraint;

/**
 * Notification channel property entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_CHANNELPROP", uniqueConstraints = { @UniqueConstraint({ "notificationChannelId", "name" }) })
public class NotificationChannelProp extends BaseEntity {

    @ForeignKey(NotificationChannel.class)
    private Long notificationChannelId;

    @Column(name = "CHANNELPROP_NM", length = 128)
    private String name;

    @Column(name = "CHANNELPROP_VAL", length = 256, nullable = true)
    private String value;

    @Override
    public String getDescription() {
        return name;
    }

    public Long getNotificationChannelId() {
        return notificationChannelId;
    }

    public void setNotificationChannelId(Long notificationChannelId) {
        this.notificationChannelId = notificationChannelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
