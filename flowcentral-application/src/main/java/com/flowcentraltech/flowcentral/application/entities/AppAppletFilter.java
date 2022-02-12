/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.common.constants.OwnershipType;
import com.flowcentraltech.flowcentral.common.entities.BaseConfigNamedEntity;
import com.tcdng.unify.core.annotation.Child;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.ListOnly;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.annotation.UniqueConstraint;

/**
 * Application applet filter entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_APPLETFILTER", uniqueConstraints = { @UniqueConstraint({ "appAppletId", "name" }),
        @UniqueConstraint({ "appAppletId", "description" }) })
public class AppAppletFilter extends BaseConfigNamedEntity {

    @ForeignKey(AppApplet.class)
    private Long appAppletId;

    @ForeignKey
    private OwnershipType ownershipType;

    @Column(length = 64, nullable = true)
    private String owner;

    @Column
    private boolean quickFilter;

    @Column(name = "PREFFERED_FORM_NM", length = 128, nullable = true)
    private String preferredForm;

    @ListOnly(key = "ownershipType", property = "description")
    private String ownershipTypeDesc;

    @Child(category = "applet")
    private AppFilter filter;

    public AppAppletFilter(String name, String description, String definition) {
        this.setName(name);
        this.setDescription(description);
        this.filter = new AppFilter(definition);
    }

    public AppAppletFilter() {
        
    }
    
    public Long getAppAppletId() {
        return appAppletId;
    }

    public void setAppAppletId(Long appAppletId) {
        this.appAppletId = appAppletId;
    }

    public OwnershipType getOwnershipType() {
        return ownershipType;
    }

    public void setOwnershipType(OwnershipType ownershipType) {
        this.ownershipType = ownershipType;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPreferredForm() {
        return preferredForm;
    }

    public void setPreferredForm(String preferredForm) {
        this.preferredForm = preferredForm;
    }

    public boolean isQuickFilter() {
        return quickFilter;
    }

    public void setQuickFilter(boolean quickFilter) {
        this.quickFilter = quickFilter;
    }

    public String getOwnershipTypeDesc() {
        return ownershipTypeDesc;
    }

    public void setOwnershipTypeDesc(String ownershipTypeDesc) {
        this.ownershipTypeDesc = ownershipTypeDesc;
    }

    public AppFilter getFilter() {
        return filter;
    }

    public void setFilter(AppFilter filter) {
        this.filter = filter;
    }

}
