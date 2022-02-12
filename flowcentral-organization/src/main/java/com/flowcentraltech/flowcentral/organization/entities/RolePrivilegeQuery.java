/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.organization.entities;

import java.util.Collection;
import java.util.List;

import com.flowcentraltech.flowcentral.common.entities.BaseAuditEntityQuery;

/**
 * Role privilege query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class RolePrivilegeQuery extends BaseAuditEntityQuery<RolePrivilege> {

    public RolePrivilegeQuery() {
        super(RolePrivilege.class);
    }

    public RolePrivilegeQuery roleId(Long roleId) {
        return (RolePrivilegeQuery) addEquals("roleId", roleId);
    }

    public RolePrivilegeQuery roleIdIn(List<Long> roleIdList) {
        return (RolePrivilegeQuery) addAmongst("roleId", roleIdList);
    }

    public RolePrivilegeQuery roleCode(String roleCode) {
        return (RolePrivilegeQuery) addEquals("roleCode", roleCode);
    }

    public RolePrivilegeQuery privilegeCatCode(String privilegeCatCode) {
        return (RolePrivilegeQuery) addEquals("privilegeCatCode", privilegeCatCode);
    }

    public RolePrivilegeQuery privilegeId(Long privilegeId) {
        return (RolePrivilegeQuery) addEquals("privilegeId", privilegeId);
    }

    public RolePrivilegeQuery privilegeIdIn(Collection<Long> privilegeId) {
        return (RolePrivilegeQuery) addAmongst("privilegeId", privilegeId);
    }

    public RolePrivilegeQuery privilegeIdNotIn(Collection<Long> privilegeId) {
        return (RolePrivilegeQuery) addNotAmongst("privilegeId", privilegeId);
    }

    public RolePrivilegeQuery moduleCode(String moduleCode) {
        return (RolePrivilegeQuery) addEquals("moduleCode", moduleCode);
    }

    @Override
    public RolePrivilegeQuery addSelect(String field) {
        return (RolePrivilegeQuery) super.addSelect(field);
    }

    @Override
    public RolePrivilegeQuery addOrder(String field) {
        return (RolePrivilegeQuery) super.addOrder(field);
    }
}
