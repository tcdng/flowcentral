/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.common.entities;

import java.util.Date;

import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ColumnType;
import com.tcdng.unify.core.annotation.Policy;

/**
 * Base class for audit entities.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Policy("baseaudit-entitypolicy")
public abstract class BaseAuditEntity extends BaseEntity {

    @Column(type = ColumnType.TIMESTAMP_UTC)
    private Date createDt;

    @Column(length = 64)
    private String createdBy;

    @Column(type = ColumnType.TIMESTAMP_UTC)
    private Date updateDt;

    @Column(length = 64)
    private String updatedBy;

    public final Date getCreateDt() {
        return createDt;
    }

    public final void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public final String getCreatedBy() {
        return createdBy;
    }

    public final void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public final Date getUpdateDt() {
        return updateDt;
    }

    public final void setUpdateDt(Date updateDt) {
        this.updateDt = updateDt;
    }

    public final String getUpdatedBy() {
        return updatedBy;
    }

    public final void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
