/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.organization.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseStatusEntity;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.annotation.UniqueConstraint;

/**
 * Represents zone entity.
 * 
 * @author Lateef Ojulari
 * @version 1.0
 */
@Table(name = "FC_ZONE", uniqueConstraints = { @UniqueConstraint({ "code" }), @UniqueConstraint({ "description" }) })
public class Zone extends BaseStatusEntity {

    @Column(name = "ZONE_CD", length = 16)
    private String code;

    @Column(name = "ZONE_DESC", length = 64)
    private String description;

    @Column(name = "ZONE_TIMEZONE", length = 64, nullable = true)
    private String timeZone;

    @Column(length = 64, nullable = true)
    private String languageTag;

    @Override
    public String getDescription() {
        return description;
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
