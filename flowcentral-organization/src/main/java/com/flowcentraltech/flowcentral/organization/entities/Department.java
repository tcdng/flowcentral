/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.organization.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseStatusEntity;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.annotation.UniqueConstraint;

/**
 * Represents department entity.
 * 
 * @author Lateef Ojulari
 * @version 1.0
 */
@Table(name = "FC_DEPARTMENT",
        uniqueConstraints = { @UniqueConstraint({ "code" }), @UniqueConstraint({ "description" }) })
public class Department extends BaseStatusEntity {

    @Column(name = "DEPARTMENT_CD", length = 16)
    private String code;

    @Column(name = "DEPARTMENT_DESC", length = 64)
    private String description;

    @Override
    public String getDescription() {
        return description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
