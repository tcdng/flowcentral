/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.notification.constants;

/**
 * Notification module error constants.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface NotificationModuleErrorConstants {

    /** Can not find notification template {0}. */
    String CANNOT_FIND_NOTIFICATION_TEMPLATE = "NOTIF_0001";

    /** Notification channel with name [{0}] is unknown. */
    String NOTIFICATION_CHANNEL_WITH_NAME_UNKNOWN = "NOTIF_0002";

    /** Can not send a message of type [{0}] through notification channel [{1}]. */
    String CANNOT_SEND_NOTIFICATION_TYPE_THROUGH_CHANNEL = "NOTIF_0003";

    /** No notification messaging channel available for [{0}]. */
    String NOTIFICATION_CHANNEL_NOT_AVAILABLE = "NOTIF_0004";

    /** Can not construct message with no recipients. */
    String NOTIFICATION_CHANNEL_CONSTRUCT_NO_RECIPIENT = "NOTIF_0005";

}
