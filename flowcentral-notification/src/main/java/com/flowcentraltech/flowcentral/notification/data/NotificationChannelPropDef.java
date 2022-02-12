/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.notification.data;

import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.util.DataUtils;

/**
 * Notification channel property definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class NotificationChannelPropDef {

    private String name;

    private String value;

    public NotificationChannelPropDef(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public <T> T getValue(Class<T> dataClazz) throws UnifyException {
        return DataUtils.convert(dataClazz, value);
    }
}
