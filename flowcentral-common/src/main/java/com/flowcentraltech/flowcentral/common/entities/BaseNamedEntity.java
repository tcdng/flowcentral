/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.entities;

import com.tcdng.unify.core.annotation.Column;

/**
 * Base named entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class BaseNamedEntity extends BaseAuditEntity {

    @Column(name = "ENTITY_NM", length = 64)
    private String name;

    @Column(name = "ENTITY_DESC", length = 96)
    private String description;

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    @Override
    public final String getDescription() {
        return description;
    }

    public final void setDescription(String description) {
        this.description = description;
    }

}
