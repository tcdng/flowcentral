/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.notification.data;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.flowcentraltech.flowcentral.common.data.BaseNamedDef;
import com.flowcentraltech.flowcentral.configuration.constants.NotificationType;
import com.tcdng.unify.convert.util.ConverterUtils;
import com.tcdng.unify.core.UnifyException;

/**
 * Notification channel definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class NotificationChannelDef extends BaseNamedDef {

    private NotificationType notificationType;

    private String senderName;

    private String senderContact;

    private Map<String, NotificationChannelPropDef> propDefMap;

    private boolean channelConfigured;

    private NotificationChannelDef(NotificationType notificationType, String senderName, String senderContact,
            Map<String, NotificationChannelPropDef> propDefMap, String name, String description, Long id,
            long version) {
        super(name, description, id, version);
        this.notificationType = notificationType;
        this.senderName = senderName;
        this.senderContact = senderContact;
        this.propDefMap = propDefMap;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getSenderContact() {
        return senderContact;
    }

    public boolean isChannelConfigured() {
        return channelConfigured;
    }

    public void setChannelConfigured() {
        this.channelConfigured = true;
    }

    @SuppressWarnings("unchecked")
    public <T> T getPropValue(Class<T> dataClazz, String name) throws UnifyException {
        NotificationChannelPropDef notificationChannelPropDef = propDefMap.get(name);
        if (notificationChannelPropDef != null) {
            return notificationChannelPropDef.getValue(dataClazz);
        }

        return (T) ConverterUtils.getNullValue(dataClazz);
    }

    public <T> T getPropValue(Class<T> dataClazz, String name, T defVal) throws UnifyException {
        NotificationChannelPropDef notificationChannelPropDef = propDefMap.get(name);
        if (notificationChannelPropDef != null) {
            return notificationChannelPropDef.getValue(dataClazz);
        }

        return defVal;
    }

    public boolean isProp(String name) {
        return propDefMap.containsKey(name);
    }

    public NotificationChannelPropDef getPropDef(String name) {
        NotificationChannelPropDef notificationChannelPropDef = propDefMap.get(name);
        if (notificationChannelPropDef == null) {
            throw new RuntimeException(
                    "Property with name [" + name + "] is unknown for applet definition [" + getName() + "].");
        }

        return notificationChannelPropDef;
    }

    public static Builder newBuilder(NotificationType type, String senderName, String senderContact, String name,
            String description, Long id, long version) {
        return new Builder(type, senderName, senderContact, name, description, id, version);
    }

    public static class Builder {

        private Map<String, NotificationChannelPropDef> propDefMap;

        private NotificationType type;

        private String senderName;

        private String senderContact;

        private String name;

        private String description;

        private Long id;

        private long version;

        public Builder(NotificationType type, String senderName, String senderContact, String name, String description,
                Long id, long version) {
            this.type = type;
            this.senderName = senderName;
            this.senderContact = senderContact;
            this.propDefMap = new HashMap<String, NotificationChannelPropDef>();
            this.name = name;
            this.description = description;
            this.id = id;
            this.version = version;
        }

        public Builder addPropDef(String name, String value) {
            if (propDefMap.containsKey(name)) {
                throw new RuntimeException("Property with name [" + name + "] already exists in this definition.");
            }

            propDefMap.put(name, new NotificationChannelPropDef(name, value));
            return this;
        }

        public NotificationChannelDef build() {
            return new NotificationChannelDef(type, senderName, senderContact, Collections.unmodifiableMap(propDefMap),
                    name, description, id, version);
        }
    }
}
