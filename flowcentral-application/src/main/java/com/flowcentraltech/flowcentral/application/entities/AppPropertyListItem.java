/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseEntity;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.ListOnly;
import com.tcdng.unify.core.annotation.Table;

/**
 * Application property rule choice entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_PROPLISTITEM")
public class AppPropertyListItem extends BaseEntity {

    @ForeignKey(AppPropertySet.class)
    private Long appPropertySetId;

    @Column(name = "PROPLISTITEM_NM", length = 64)
    private String name;

    @Column(name = "PROPLISTITEM_DESC", length = 96)
    private String description;

    @Column(name = "ITEM_REFERENCE", length = 96, nullable = true)
    private String references;

    @Column(length = 128)
    private String inputWidget;

    @Column(length = 128, nullable = true)
    private String defaultVal;

    @Column
    private boolean required;

    @Column
    private boolean mask;

    @Column
    private boolean encrypt;

    @ListOnly(key = "appPropertySetId", property = "label")
    private String appPropertySetLabel;

    @Override
    public String getDescription() {
        return description;
    }

    public Long getAppPropertySetId() {
        return appPropertySetId;
    }

    public void setAppPropertySetId(Long appPropertySetId) {
        this.appPropertySetId = appPropertySetId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }

    public String getInputWidget() {
        return inputWidget;
    }

    public void setInputWidget(String inputWidget) {
        this.inputWidget = inputWidget;
    }

    public String getDefaultVal() {
        return defaultVal;
    }

    public void setDefaultVal(String defaultVal) {
        this.defaultVal = defaultVal;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public boolean isMask() {
        return mask;
    }

    public void setMask(boolean mask) {
        this.mask = mask;
    }

    public boolean isEncrypt() {
        return encrypt;
    }

    public void setEncrypt(boolean encrypt) {
        this.encrypt = encrypt;
    }

    public String getAppPropertySetLabel() {
        return appPropertySetLabel;
    }

    public void setAppPropertySetLabel(String appPropertySetLabel) {
        this.appPropertySetLabel = appPropertySetLabel;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
