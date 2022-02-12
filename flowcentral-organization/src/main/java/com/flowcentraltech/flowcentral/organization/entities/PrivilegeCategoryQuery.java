/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.organization.entities;

import java.util.Collection;

import com.flowcentraltech.flowcentral.common.entities.BaseAuditEntityQuery;

/**
 * Privilege category query.
 * 
 * @author Lateef Ojulari
 * @version 1.0
 */
public class PrivilegeCategoryQuery extends BaseAuditEntityQuery<PrivilegeCategory> {

    public PrivilegeCategoryQuery() {
        super(PrivilegeCategory.class);
    }

    public PrivilegeCategoryQuery code(String code) {
        return (PrivilegeCategoryQuery) addEquals("code", code);
    }

    public PrivilegeCategoryQuery codeIn(Collection<String> code) {
        return (PrivilegeCategoryQuery) addAmongst("code", code);
    }

    public PrivilegeCategoryQuery descriptionLike(String description) {
        return (PrivilegeCategoryQuery) addLike("description", description);
    }
}
