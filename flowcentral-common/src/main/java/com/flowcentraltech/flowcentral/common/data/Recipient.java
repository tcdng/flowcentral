/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.data;

import com.flowcentraltech.flowcentral.configuration.constants.NotificationRecipientType;

/**
 * Recipient.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class Recipient {

    private NotificationRecipientType type;

    private String name;

    private String contact;

    public Recipient(NotificationRecipientType type, String name, String contact) {
        this.type = type;
        this.name = name;
        this.contact = contact;
    }

    public Recipient(String name, String contact) {
        this.type = NotificationRecipientType.TO;
        this.name = name;
        this.contact = contact;
    }

    public NotificationRecipientType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    @Override
    public String toString() {
        return "Recipient [type=" + type + ", name=" + name + ", contact=" + contact + "]";
    }

}
