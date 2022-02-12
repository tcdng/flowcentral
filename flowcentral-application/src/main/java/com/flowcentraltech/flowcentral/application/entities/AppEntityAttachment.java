/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseConfigNamedEntity;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.ListOnly;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.constant.FileAttachmentType;

/**
 * Application entity attachment configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_ENTITYATTACHMENT")
public class AppEntityAttachment extends BaseConfigNamedEntity {

    @ForeignKey(AppEntity.class)
    private Long appEntityId;

    @ForeignKey
    private FileAttachmentType type;

    @ListOnly(key = "type", property = "description")
    private String typeDesc;

    public Long getAppEntityId() {
        return appEntityId;
    }

    public void setAppEntityId(Long appEntityId) {
        this.appEntityId = appEntityId;
    }

    public FileAttachmentType getType() {
        return type;
    }

    public void setType(FileAttachmentType type) {
        this.type = type;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

}
