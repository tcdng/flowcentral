/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.business;

import java.util.Collection;
import java.util.List;

import com.flowcentraltech.flowcentral.common.data.Recipient;
import com.flowcentraltech.flowcentral.configuration.constants.NotificationType;
import com.tcdng.unify.core.UnifyComponent;
import com.tcdng.unify.core.UnifyException;

/**
 * Notification recipient provider.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface NotificationRecipientProvider extends UnifyComponent {

    /**
     * Gets recipient by user login ID.
     * 
     * @param type
     *                    the notification type
     * @param userLoginId
     *                    the user login ID
     * @return the recipient
     * @throws UnifyException
     *                        if an error occurs
     */
    Recipient getRecipientByLoginId(NotificationType type, String userLoginId) throws UnifyException;

    /**
     * Gets notification recipients by role.
     * 
     * @param type
     *                 the notification type
     * @param roleCode
     *                 the role code
     * @return a list of recipients
     * @throws UnifyException
     *                        if an error occurs
     */
    List<Recipient> getRecipientsByRole(NotificationType type, String roleCode) throws UnifyException;

    /**
     * Gets notification recipients by roles.
     * 
     * @param type
     *              the notification type
     * @param roles
     *              the role codes
     * @return a list of recipients
     * @throws UnifyException
     *                        if an error occurs
     */
    List<Recipient> getRecipientsByRole(NotificationType type, Collection<String> roles) throws UnifyException;
}
