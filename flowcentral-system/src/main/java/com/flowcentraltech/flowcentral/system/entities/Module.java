/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.system.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseStatusEntity;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.annotation.UniqueConstraint;

/**
 * System module.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_MODULE", uniqueConstraints = { @UniqueConstraint({ "name" }), @UniqueConstraint({ "description" }),
        @UniqueConstraint({ "shortCode" }) })
public class Module extends BaseStatusEntity {

    @Column(name = "MODULE_NM", length = 32)
    private String name;

    @Column(name = "MODULE_DESC", length = 196)
    private String description;

    @Column(name = "MODULE_LABEL", length = 64)
    private String label;

    @Column(name = "SHORT_CD", length = 16)
    private String shortCode;

    @Override
    public String getDescription() {
        return description;
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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

}
