/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.organization.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseStatusEntity;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.ListOnly;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.annotation.UniqueConstraint;

/**
 * Represents branch entity.
 * 
 * @author Lateef Ojulari
 * @version 1.0
 */
@Table(name = "FC_BRANCH", uniqueConstraints = { @UniqueConstraint({ "code" }), @UniqueConstraint({ "description" }),
        @UniqueConstraint({ "sortCode" }) })
public class Branch extends BaseStatusEntity {

    @ForeignKey(Zone.class)
    private Long zoneId;

    @Column(name = "BRANCH_CD", length = 16)
    private String code;

    @Column(name = "BRANCH_DESC", length = 64)
    private String description;

    @Column(name = "SORT_CD", length = 32, nullable = true)
    private String sortCode;

    @Column(name = "HEAD_OFFICE_FG")
    private boolean headOffice;

    @ListOnly(key = "zoneId", property = "code")
    private String zoneCode;

    @ListOnly(key = "zoneId", property = "description")
    private String zoneDesc;

    @ListOnly(key = "zoneId", property = "languageTag")
    private String languageTag;

    @ListOnly(key = "zoneId", property = "timeZone")
    private String timeZone;

    @Override
    public String getDescription() {
        return this.description;
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

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public boolean getHeadOffice() {
        return headOffice;
    }

    public void setHeadOffice(boolean headOffice) {
        this.headOffice = headOffice;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }

    public String getZoneCode() {
        return zoneCode;
    }

    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }

    public String getZoneDesc() {
        return zoneDesc;
    }

    public void setZoneDesc(String zoneDesc) {
        this.zoneDesc = zoneDesc;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getLanguageTag() {
        return languageTag;
    }

    public void setLanguageTag(String languageTag) {
        this.languageTag = languageTag;
    }
}
