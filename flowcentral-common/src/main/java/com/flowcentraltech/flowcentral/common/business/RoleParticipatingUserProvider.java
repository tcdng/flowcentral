/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.business;

import java.util.Collection;
import java.util.List;

import com.tcdng.unify.core.UnifyComponent;
import com.tcdng.unify.core.UnifyException;

/**
 * Role participating user provider.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface RoleParticipatingUserProvider extends UnifyComponent {

    /**
     * Gets participating users by role.
     * 
     * @param branchCode
     *                   the optional branch code
     * @param roleCode
     *                   the role code
     * @return a list of recipients
     * @throws UnifyException
     *                        if an error occurs
     */
    List<String> getParticipatingUsersByRole(String branchCode, String roleCode) throws UnifyException;

    /**
     * Gets participating users by roles.
     * 
     * @param branchCode
     *                   the optional branch code
     * @param roles
     *                   the role codes
     * @return a list of recipients
     * @throws UnifyException
     *                        if an error occurs
     */
    List<String> getParticipatingUsersByRole(String branchCode, Collection<String> roles) throws UnifyException;
}
