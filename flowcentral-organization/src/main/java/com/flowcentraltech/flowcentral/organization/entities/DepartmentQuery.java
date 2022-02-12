/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.organization.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseStatusEntityQuery;

/**
 * Query class for departments.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class DepartmentQuery extends BaseStatusEntityQuery<Department> {

    public DepartmentQuery() {
        super(Department.class);
    }

    public DepartmentQuery code(String code) {
        return (DepartmentQuery) addEquals("code", code);
    }

    public DepartmentQuery codeLike(String code) {
        return (DepartmentQuery) addLike("code", code);
    }

    public DepartmentQuery descriptionLike(String description) {
        return (DepartmentQuery) addLike("description", description);
    }
}
