/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.organization.business;

import java.util.List;

import com.flowcentraltech.flowcentral.common.business.FlowCentralService;
import com.flowcentraltech.flowcentral.organization.entities.Privilege;
import com.flowcentraltech.flowcentral.organization.entities.PrivilegeCategory;
import com.flowcentraltech.flowcentral.organization.entities.PrivilegeCategoryQuery;
import com.flowcentraltech.flowcentral.organization.entities.PrivilegeQuery;
import com.flowcentraltech.flowcentral.organization.entities.Role;
import com.flowcentraltech.flowcentral.organization.entities.RoleQuery;
import com.tcdng.unify.core.UnifyException;

/**
 * Organization module service.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface OrganizationModuleService extends FlowCentralService {

    /**
     * Finds roles using supplied query.
     * 
     * @param query
     *              the query to use
     * @return the role list
     * @throws UnifyException
     *                        if an error occurs
     */
    List<Role> findRoles(RoleQuery query) throws UnifyException;

    /**
     * Gets role code for supplied role ID.
     * 
     * @param roleId
     *               the role ID
     * @return the role code
     * @throws UnifyException
     *                        if role with ID does not exist. if an error occurs
     */
    String getRoleCode(Long roleId) throws UnifyException;

    /**
     * Finds privilege categories by query.
     * 
     * @param query
     *              the search query
     * @return the privilege categories
     * @throws UnifyException
     *                        if an error occurs
     */
    List<PrivilegeCategory> findPrivilegeCategories(PrivilegeCategoryQuery query) throws UnifyException;

    /**
     * Finds privileges using supplied query.
     * 
     * @param query
     *              the query to use
     * @return the privilege list
     * @throws UnifyException
     *                        if an error occurs
     */
    List<Privilege> findPrivileges(PrivilegeQuery query) throws UnifyException;

    /**
     * Get branch ID.
     * 
     * @param branchCode
     *                   the branch code
     * @return the branch ID if found otherwise null
     * @throws UnifyException
     *                        if an error occurs
     */
    Long getBranchID(String branchCode) throws UnifyException;

    /**
     * Get department ID..
     * 
     * @param departmentCode
     *                       the department code
     * @return the department ID if found otherwise null
     * @throws UnifyException
     *                        if an error occurs
     */
    Long getDepartmentID(String departmentCode) throws UnifyException;

    /**
     * Invalidates role privileges cache.
     * 
     * @param roleCodes
     *                  the role codes
     * @throws UnifyException
     *                        if an error occurs
     */
    void invalidateRolePrivilegesCache(String... roleCodes) throws UnifyException;
}
