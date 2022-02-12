/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.system.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseAuditEntity;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.annotation.UniqueConstraint;

/**
 * Environment variable entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_ENVIRONMENTVARIABLE",
        uniqueConstraints = { @UniqueConstraint({ "name" }), @UniqueConstraint({ "description" }) })
public class EnvironmentVariable extends BaseAuditEntity {

    @Column(length = 64)
    private String name;

    @Column(length = 128)
    private String description;

    @Column(name="VARIABLE_VAL", length = 1024)
    private String variable;

    @Override
    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

}
