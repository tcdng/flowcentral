/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseConfigNamedEntity;
import com.flowcentraltech.flowcentral.configuration.constants.FormAnnotationType;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.ListOnly;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.annotation.UniqueConstraint;

/**
 * Application form annotation entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_FORMANNOTATION", uniqueConstraints = { @UniqueConstraint({ "appFormId", "name" }),
        @UniqueConstraint({ "appFormId", "description" }) })
public class AppFormAnnotation extends BaseConfigNamedEntity {

    @ForeignKey(AppForm.class)
    private Long appFormId;

    @ForeignKey(name = "FORMANNOTATION_TY")
    private FormAnnotationType type;

    @Column(length = 512)
    private String message;

    @Column
    private boolean html;

    @ListOnly(key = "type", property = "description")
    private String typeDesc;

    public Long getAppFormId() {
        return appFormId;
    }

    public void setAppFormId(Long appFormId) {
        this.appFormId = appFormId;
    }

    public FormAnnotationType getType() {
        return type;
    }

    public void setType(FormAnnotationType type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isHtml() {
        return html;
    }

    public void setHtml(boolean html) {
        this.html = html;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

}
