/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.organization.entities;

import java.util.Date;

import com.flowcentraltech.flowcentral.common.entities.BaseStatusEntityQuery;
import com.tcdng.unify.core.criterion.OrBuilder;

/**
 * Query class for roles.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class RoleQuery extends BaseStatusEntityQuery<Role> {

    public RoleQuery() {
        super(Role.class);
    }

    @Override
    public RoleQuery addOrder(String field) {
        return (RoleQuery) super.addOrder(field);
    }

    @Override
    public RoleQuery addSelect(String field) {
        return (RoleQuery) super.addSelect(field);
    }

    public RoleQuery departmentId(Long departmentId) {
        return (RoleQuery) addEquals("departmentId", departmentId);
    }

    public RoleQuery code(String code) {
        return (RoleQuery) addEquals("code", code);
    }

    public RoleQuery codeLike(String code) {
        return (RoleQuery) addLike("code", code);
    }

    public RoleQuery description(String description) {
        return (RoleQuery) addEquals("description", description);
    }

    public RoleQuery descriptionLike(String description) {
        return (RoleQuery) addLike("description", description);
    }

    public RoleQuery activeBefore(Date activeBefore) {
        return (RoleQuery) addRestriction(
                new OrBuilder().lessEqual("activeBefore", activeBefore).isNull("activeBefore").build());
    }

    public RoleQuery activeAfter(Date activeAfter) {
        return (RoleQuery) addRestriction(
                new OrBuilder().greaterEqual("activeAfter", activeAfter).isNull("activeAfter").build());
    }
}
