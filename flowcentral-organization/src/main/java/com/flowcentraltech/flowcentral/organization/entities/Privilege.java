/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.organization.entities;

import com.flowcentraltech.flowcentral.application.entities.Application;
import com.flowcentraltech.flowcentral.common.entities.BaseAuditEntity;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.ListOnly;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.annotation.UniqueConstraint;

/**
 * Privilege entity.
 * 
 * @author Lateef Ojulari
 * @version 1.0
 */
@Table(name = "FC_PRIVILEGE", uniqueConstraints = { @UniqueConstraint({ "code" }) })
public class Privilege extends BaseAuditEntity {

    @ForeignKey(Application.class)
    private Long applicationId;

    @ForeignKey(PrivilegeCategory.class)
    private Long privilegeCategoryId;

    @Column(name = "PRIVILEGE_CD", length = 64)
    private String code;

    @Column(name = "PRIVILEGE_DESC", length = 96)
    private String description;

    @ListOnly(key = "applicationId", property = "name")
    private String applicationName;

    @ListOnly(key = "applicationId", property = "description")
    private String applicationDesc;

    @ListOnly(key = "privilegeCategoryId", property = "code")
    private String privilegeCatCode;

    @ListOnly(key = "privilegeCategoryId", property = "description")
    private String privilegeCatDesc;

    @Override
    public String getDescription() {
        return description;
    }

    public Long getPrivilegeCategoryId() {
        return privilegeCategoryId;
    }

    public void setPrivilegeCategoryId(Long privilegeCategoryId) {
        this.privilegeCategoryId = privilegeCategoryId;
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

    public String getPrivilegeCatCode() {
        return privilegeCatCode;
    }

    public void setPrivilegeCatCode(String privilegeCatCode) {
        this.privilegeCatCode = privilegeCatCode;
    }

    public String getPrivilegeCatDesc() {
        return privilegeCatDesc;
    }

    public void setPrivilegeCatDesc(String privilegeCatDesc) {
        this.privilegeCatDesc = privilegeCatDesc;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getApplicationDesc() {
        return applicationDesc;
    }

    public void setApplicationDesc(String applicationDesc) {
        this.applicationDesc = applicationDesc;
    }

}
