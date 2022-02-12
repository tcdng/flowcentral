/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseConfigNamedEntity;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.Table;

/**
 * Application entity unique constraint.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_ENTITYUNIQUECONST")
public class AppEntityUniqueConstraint extends BaseConfigNamedEntity {

    @ForeignKey(AppEntity.class)
    private Long appEntityId;

    @Column(length = 512)
    private String fieldList;

    public Long getAppEntityId() {
        return appEntityId;
    }

    public void setAppEntityId(Long appEntityId) {
        this.appEntityId = appEntityId;
    }

    public String getFieldList() {
        return fieldList;
    }

    public void setFieldList(String fieldList) {
        this.fieldList = fieldList;
    }

}
