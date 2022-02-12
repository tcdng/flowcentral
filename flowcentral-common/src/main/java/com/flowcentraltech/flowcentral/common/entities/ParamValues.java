/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.entities;

import com.tcdng.unify.core.annotation.CategoryColumn;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.FosterParentId;
import com.tcdng.unify.core.annotation.FosterParentType;
import com.tcdng.unify.core.annotation.Index;
import com.tcdng.unify.core.annotation.Table;

/**
 * Common parameter values entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_PARAMVALUES", indexes = { @Index(value = { "entity" }), @Index(value = { "category" }) })
public class ParamValues extends BaseAuditEntity {

    @FosterParentId
    private Long entityInstId;

    @FosterParentType(length = 128)
    private String entity;

    @CategoryColumn(name = "PARAMVALUES_CAT")
    private String category;

    @Column(name = "PARAMVALUES_DEF", length = 2048)
    private String definition;

    public ParamValues(String definition) {
        this.definition = definition;
    }

    public ParamValues() {

    }

    @Override
    public String getDescription() {
        return category;
    }

    public Long getEntityInstId() {
        return entityInstId;
    }

    public void setEntityInstId(Long entityInstId) {
        this.entityInstId = entityInstId;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

}
