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
 * Base class for work entity with status.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Policy("basestatuswork-entitypolicy")
public abstract class BaseStatusWorkEntity extends BaseWorkEntity {

    @ForeignKey(name = "REC_ST")
    private RecordStatus status;

    @ListOnly(key = "status", property = "description")
    private String statusDesc;

    public final RecordStatus getStatus() {
        return status;
    }

    public final void setStatus(RecordStatus status) {
        this.status = status;
    }

    public final String getStatusDesc() {
        return statusDesc;
    }

    public final void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

}
