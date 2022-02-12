/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.entities;

import com.flowcentraltech.flowcentral.common.constants.RecordStatus;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.ListOnly;
import com.tcdng.unify.core.annotation.Policy;

/**
 * Base class for status entities.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Policy("basestatus-entitypolicy")
public abstract class BaseStatusEntity extends BaseAuditEntity {

    @ForeignKey(name = "REC_ST")
    private RecordStatus status;

    @ListOnly(key = "status", property = "description")
    private String statusDesc;

    public RecordStatus getStatus() {
        return status;
    }

    public void setStatus(RecordStatus status) {
        this.status = status;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

}
