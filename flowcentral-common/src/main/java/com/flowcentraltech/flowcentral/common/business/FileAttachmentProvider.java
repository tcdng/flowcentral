/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.business;

import java.util.List;
import java.util.Map;

import com.flowcentraltech.flowcentral.common.data.Attachment;
import com.tcdng.unify.core.UnifyComponent;
import com.tcdng.unify.core.UnifyException;

/**
 * File attachment provider.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface FileAttachmentProvider extends UnifyComponent {

    /**
     * Count number of file attachments for an entity instance.
     * 
     * @param category
     *                        the file attachment category
     * @param ownerEntityName
     *                        the entity type long name
     * @param ownerInstId
     *                        the entity instance ID
     * @return the number of attachments
     * @throws UnifyException
     *                        if an error occurs
     */
    int countFileAttachments(String category, String ownerEntityName, Long ownerInstId) throws UnifyException;

    /**
     * Creates or updates a file attachment for an entity instance. An entity
     * instance can have multiple file attachments with different names.
     * 
     * @param category
     *                        the file attachment category
     * @param ownerEntityName
     *                        the entity type long name
     * @param ownerInstId
     *                        the entity instance ID
     * @param attachment
     *                        the attachment to save
     * @return true if new file attachment was created otherwise false if it was
     *         updated
     * @throws UnifyException
     *                        if entity instance with supplied ID does not exist. If
     *                        an error occurs
     */
    boolean saveFileAttachment(String category, String ownerEntityName, Long ownerInstId, Attachment attachment)
            throws UnifyException;

    /**
     * Retrieves a file attachment for an entity instance.
     * 
     * @param category
     *                        the file attachment category
     * @param ownerEntityName
     *                        the entity type long name
     * @param ownerInstId
     *                        the entity instance ID
     * @param attachmentName
     *                        the attachment name
     * @return the attachment if exists otherwise null
     * @throws UnifyException
     *                        if an error occurs
     */
    Attachment retrieveFileAttachment(String category, String ownerEntityName, Long ownerInstId, String attachmentName)
            throws UnifyException;

    /**
     * Retrieves all file attachment for an entity instance.
     * 
     * @param category
     *                        the file attachment category
     * @param ownerEntityName
     *                        the entity type long name
     * @param ownerInstId
     *                        the entity instance ID
     * @return the attachment list
     * @throws UnifyException
     *                        if an error occurs
     */
    List<Attachment> retrieveAllFileAttachments(String category, String ownerEntityName, Long ownerInstId)
            throws UnifyException;

    /**
     * Retrieves all file attachment for an entity instance.
     * 
     * @param category
     *                        the file attachment category
     * @param ownerEntityName
     *                        the entity type long name
     * @param ownerInstId
     *                        the entity instance ID
     * @return file names by attachment name
     * @throws UnifyException
     */
    Map<String, String> retrieveAllAttachmentFileNames(String category, String ownerEntityName, Long ownerInstId)
            throws UnifyException;

    /**
     * Deletes a file attachment for an entity instance.
     * 
     * @param category
     *                        the file attachment category
     * @param ownerEntityName
     *                        the entity type long name
     * @param ownerInstId
     *                        the entity instance ID
     * @param attachmentName
     *                        the attachment name
     * @return true if attachment was deleted otherwise false when not existing
     * @throws UnifyException
     *                        if an error occurs
     */
    boolean deleteFileAttachment(String category, String ownerEntityName, Long ownerInstId, String attachmentName)
            throws UnifyException;

    /**
     * Synchronize file attachments from a source entity to a destination entity.
     * 
     * @param category
     *                         the file attachment category
     * @param ownerEntityName
     *                         the entity type long name
     * @param destEntityInstId
     *                         destination entity instance ID
     * @param srcEntityInstId
     *                         source entity instance ID
     * @return true if synchronized otherwise false
     * @throws UnifyException
     *                        if an error occurs
     */
    boolean sychFileAttachments(String category, String ownerEntityName, Long destEntityInstId, Long srcEntityInstId)
            throws UnifyException;
}
