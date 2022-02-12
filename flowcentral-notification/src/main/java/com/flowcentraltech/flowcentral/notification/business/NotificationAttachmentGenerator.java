/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.notification.business;

import java.util.List;

import com.flowcentraltech.flowcentral.common.data.Attachment;
import com.flowcentraltech.flowcentral.common.data.Dictionary;
import com.tcdng.unify.core.UnifyComponent;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.data.ValueStore;

/**
 * Notification attachment generator.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface NotificationAttachmentGenerator extends UnifyComponent {

    /**
     * Generates notification attachments using supplied dictionary.
     * 
     * @param dictionary
     *                   the dictionary to user
     * @return the list of generated attachments
     * @throws UnifyException
     *                        if an error occurs
     */
    List<Attachment> generateAttachment(Dictionary dictionary) throws UnifyException;

    /**
     * Generates notification attachments using supplied packable document.
     * 
     * @param valueStore
     *                   the value store
     * @return the list of generated attachments
     * @throws UnifyException
     *                        if an error occurs
     */
    List<Attachment> generateAttachment(ValueStore valueStore) throws UnifyException;
}
