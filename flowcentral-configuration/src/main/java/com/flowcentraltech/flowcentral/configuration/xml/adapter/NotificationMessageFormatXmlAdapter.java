/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml.adapter;

import com.flowcentraltech.flowcentral.configuration.constants.NotificationMessageFormat;
import com.tcdng.unify.core.util.xml.AbstractEnumConstXmlAdapter;

/**
 * Notification message format XML adapter.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class NotificationMessageFormatXmlAdapter extends AbstractEnumConstXmlAdapter<NotificationMessageFormat> {

    public NotificationMessageFormatXmlAdapter() {
        super(NotificationMessageFormat.class);
    }

}
