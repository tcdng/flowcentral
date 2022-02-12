/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.business;

import java.util.List;

import com.flowcentraltech.flowcentral.common.constants.CollaborationType;
import com.flowcentraltech.flowcentral.common.data.CollaborationLockInfo;
import com.tcdng.unify.core.UnifyComponent;
import com.tcdng.unify.core.UnifyException;

/**
 * Collaboration provider.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface CollaborationProvider extends UnifyComponent {

    /**
     * Gets collaboration applets.
     * 
     * @return the collaboration applets
     * @throws UnifyException
     *                        if an error occurs
     */
    List<String> getCollaborationApplets() throws UnifyException;
    
    /**
     * Checks if licensed for collaboration.
     * 
     * @return true if licensed otherwise false
     * @throws UnifyException
     *                        if an error occurs
     */
    boolean isLicensedForCollaboration() throws UnifyException;
    
    /**
     * Gets lock information.
     * 
     * @param type
     *                 the collaboration type
     * @param resourceName
     *                 the resource's long name
     * @return the lock information if found otherwise null
     * @throws UnifyException
     *                        if an error occurs
     */
    CollaborationLockInfo getLockInfo(CollaborationType type, String resourceName) throws UnifyException;

    /**
     * Checks if resource's is locked.
     * 
     * @param type
     *                 the collaboration type
     * @param resourceName
     *                 the resource's long name
     * @return true if locked otherwise false
     * @throws UnifyException
     *                        if an error occurs
     */
    boolean isLocked(CollaborationType type, String resourceName) throws UnifyException;

    /**
     * Checks if resource's is locked by user.
     * 
     * @param type
     *                 the collaboration type
     * @param resourceName
     *                 the resource's long name
     * @param userLoginId
     *                    the user login ID
     * @return true if locked by user otherwise false
     * @throws UnifyException
     *                        if an error occurs
     */
    boolean isLockedBy(CollaborationType type, String resourceName, String userLoginId) throws UnifyException;

    /**
     * Locks a resource by user.
     * 
     * @param type
     *                    the collaboration type
     * @param resourceName
     *                    the resource's long name
     * @param userLoginId
     *                    the user login ID
     * @return true is successfully locked or user already owns lock otherwise false
     * @throws UnifyException
     *                        if an error occurs
     */
    boolean lock(CollaborationType type, String resourceName, String userLoginId) throws UnifyException;

    /**
     * Unlocks a resource by user.
     * 
     * @param type
     *                    the collaboration type
     * @param resourceName
     *                    the resource's long name
     * @param userLoginId
     *                    the user login ID
     * @return true is successfully unlocked by user otherwise false
     * @throws UnifyException
     *                        if an error occurs
     */
    boolean unlock(CollaborationType type, String resourceName, String userLoginId) throws UnifyException;

    /**
     * Unlocks a resource.
     * 
     * @param type
     *                 the collaboration type
     * @param resourceName
     *                 the resource's long name
     * @return true is successfully unlocked otherwise false
     * @throws UnifyException
     *                        if an error occurs
     */
    boolean unlock(CollaborationType type, String resourceName) throws UnifyException;

    /**
     * Grab lock a resource by user.
     * 
     * @param type
     *                    the collaboration type
     * @param resourceName
     *                    the resource's long name
     * @param userLoginId
     *                    the user login ID
     * @return true is successfully lock was successfully grabbed. 
     * @throws UnifyException
     *                        if an error occurs
     */
    boolean grabLock(CollaborationType type, String resourceName, String userLoginId) throws UnifyException;
}
