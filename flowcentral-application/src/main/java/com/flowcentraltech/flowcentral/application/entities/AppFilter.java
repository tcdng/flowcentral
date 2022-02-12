/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseAuditEntity;
import com.tcdng.unify.core.annotation.CategoryColumn;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.FosterParentId;
import com.tcdng.unify.core.annotation.FosterParentType;
import com.tcdng.unify.core.annotation.Index;
import com.tcdng.unify.core.annotation.Table;

/**
 * Application filter.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_FILTER", indexes = { @Index(value = { "entity" }), @Index(value = { "category" }) })
public class AppFilter extends BaseAuditEntity {

    @FosterParentId
    private Long entityInstId;

    @FosterParentType(length = 128)
    private String entity;

    @CategoryColumn(name = "FILTER_CAT")
    private String category;

    @Column(name = "FILTER_DEF", length = 2048)
    private String definition;

    public AppFilter(String definition) {
        this.definition = definition;
    }

    public AppFilter() {

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
