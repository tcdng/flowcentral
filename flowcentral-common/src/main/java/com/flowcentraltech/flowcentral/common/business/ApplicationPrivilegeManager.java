/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.business;

import java.util.List;

import com.tcdng.unify.core.UnifyComponent;
import com.tcdng.unify.core.UnifyException;

/**
 * Application privilege manager.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface ApplicationPrivilegeManager extends UnifyComponent {

    /**
     * Registers a privilege.
     * 
     * @param applicationId
     *                              the application ID
     * @param privilegeCategoryCode
     *                              the privilege category code
     * @param privilegeCode
     *                              the privilege code
     * @param privilegeDesc
     *                              the privilege description
     * @throws UnifyException
     *                        if privilege category code is unknown. If an error
     *                        occurs
     */
    void registerPrivilege(Long applicationId, String privilegeCategoryCode, String privilegeCode, String privilegeDesc)
            throws UnifyException;

    /**
     * Unregisters a privilege.
     * 
     * @param applicationId
     *                              the application ID
     * @param privilegeCategoryCode
     *                              the privilege category code
     * @param privilegeCode
     *                              the privilege code
     * @return true if privilege was existing otherwise false
     * @throws UnifyException
     *                        if privilege category code is unknown. If an error
     *                        occurs
     */
    boolean unregisterPrivilege(Long applicationId, String privilegeCategoryCode, String privilegeCode)
            throws UnifyException;

    /**
     * Finds role privileges.
     * 
     * @param privilegeCategoryCode
     *                              the privilege category code
     * @param roleCode
     *                              the role code
     * @return list of privilege codes
     * @throws UnifyException
     *                        if an error occurs
     */
    List<String> findRolePrivileges(String privilegeCategoryCode, String roleCode) throws UnifyException;

    /**
     * Assigns privilege to a role.
     * 
     * @param roleCode
     *                      the role code
     * @param privilegeCode
     *                      the privilege code
     * @return false if privilege already assigned otherwise true
     * @throws UnifyException
     *                        if an error occurs
     */
    boolean assignPrivilegeToRole(String roleCode, String privilegeCode) throws UnifyException;

    /**
     * Checks if a role has a privilege.
     * 
     * @param roleCode
     *                      the role code
     * @param privilegeCode
     *                      the privilege code
     * @return true if supplied role has privilege otherwise false
     * @throws UnifyException
     *                        if an error occurs
     */
    boolean isRoleWithPrivilege(String roleCode, String privilegeCode) throws UnifyException;
}
