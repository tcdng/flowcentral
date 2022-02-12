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
 * Workspace privilege manager.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface WorkspacePrivilegeManager extends UnifyComponent {

    /**
     * Finds role workspace codes.
     * 
     * @param roleCode
     *                 the role code
     * @return list of workspace codes
     * @throws UnifyException
     *                        if an error occurs
     */
    List<String> findRoleWorkspaceCodes(String roleCode) throws UnifyException;

    /**
     * Counts workspaces for role.
     * 
     * @param roleCode
     *                 the role code
     * @return number of workspaces
     * @throws UnifyException
     *                        if an error occurs
     */
    int countRoleWorkspaces(String roleCode) throws UnifyException;

    /**
     * Checks if workspace has a privilege.
     * 
     * @param workspaceCode
     *                      the workspace code
     * @param privilegeCode
     *                      the privilege code
     * @return true if supplied workspace has privilege otherwise false
     * @throws UnifyException
     *                        if an error occurs
     */
    boolean isWorkspaceWithPrivilege(String workspaceCode, String privilegeCode) throws UnifyException;
}
