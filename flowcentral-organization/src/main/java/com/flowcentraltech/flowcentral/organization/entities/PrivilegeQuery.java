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
 * Privilege query.
 * 
 * @author Lateef Ojulari
 * @version 1.0
 */
public class PrivilegeQuery extends BaseAuditEntityQuery<Privilege> {

    public PrivilegeQuery() {
        super(Privilege.class);
    }

    public PrivilegeQuery applicationId(Long applicationId) {
        return (PrivilegeQuery) addEquals("applicationId", applicationId);
    }

    public PrivilegeQuery applicationName(String applicationName) {
        return (PrivilegeQuery) addEquals("applicationName", applicationName);
    }

    public PrivilegeQuery code(String code) {
        return (PrivilegeQuery) addEquals("code", code);
    }

    public PrivilegeQuery codeIn(Collection<String> code) {
        return (PrivilegeQuery) addAmongst("code", code);
    }

    public PrivilegeQuery privilegeCatCode(String privilegeCatCode) {
        return (PrivilegeQuery) addEquals("privilegeCatCode", privilegeCatCode);
    }

    public PrivilegeQuery privilegeCategoryId(Long privilegeCategoryId) {
        return (PrivilegeQuery) addEquals("privilegeCategoryId", privilegeCategoryId);
    }

}
