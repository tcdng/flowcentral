/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.organization.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseAuditEntity;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.annotation.UniqueConstraint;

/**
 * Privilege category entity.
 * 
 * @author Lateef Ojulari
 * @version 1.0
 */
@Table(name = "FC_PRIVILEGECAT",
        uniqueConstraints = { @UniqueConstraint({ "code" }), @UniqueConstraint({ "description" }) })
public class PrivilegeCategory extends BaseAuditEntity {

    @Column(name = "PRIVILEGECAT_CD", length = 64)
    private String code;

    @Column(name = "PRIVILEGECAT_DESC", length = 96)
    private String description;

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
