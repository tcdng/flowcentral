/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.organization.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseStatusEntityQuery;

/**
 * Query class for branches.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class BranchQuery extends BaseStatusEntityQuery<Branch> {

    public BranchQuery() {
        super(Branch.class);
    }

    public BranchQuery zoneId(Long zoneId) {
        return (BranchQuery) addEquals("zoneId", zoneId);
    }

    public BranchQuery code(String code) {
        return (BranchQuery) addEquals("code", code);
    }

    public BranchQuery sortCode(String sortCode) {
        return (BranchQuery) addEquals("sortCode", sortCode);
    }

    public BranchQuery sortCodeLike(String sortCode) {
        return (BranchQuery) addLike("sortCode", sortCode);
    }

    public BranchQuery descriptionLike(String description) {
        return (BranchQuery) addLike("description", description);
    }
}
