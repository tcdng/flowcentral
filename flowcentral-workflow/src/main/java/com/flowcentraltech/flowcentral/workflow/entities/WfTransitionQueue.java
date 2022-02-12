/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.workflow.entities;

import java.util.Date;

import com.flowcentraltech.flowcentral.common.entities.BaseEntity;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.Table;

/**
 * Workflow transition queue entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_WORKTRANSITIONQUEUE")
public class WfTransitionQueue extends BaseEntity {

    @Column
    private Long wfItemId;

    @Column(nullable = true)
    private Date processingDt;

    @Override
    public String getDescription() {
        return null;
    }

    public Long getWfItemId() {
        return wfItemId;
    }

    public void setWfItemId(Long wfItemId) {
        this.wfItemId = wfItemId;
    }

    public Date getProcessingDt() {
        return processingDt;
    }

    public void setProcessingDt(Date processingDt) {
        this.processingDt = processingDt;
    }

}
