/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.workflow.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseAuditEntity;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.Index;
import com.tcdng.unify.core.annotation.Table;

/**
 * Workflow wizard item entity.
 * 
 * @author Lateef Ojulari
 * @version 1.0
 */
@Table(name = "FC_WORKWIZARDITEM", indexes = { @Index("wizard") })
public class WfWizardItem extends BaseAuditEntity {

    @Column(length = 128)
    private String wizard;

    @Column(length = 96)
    private String title;

    @Column(length = 64)
    private String ownerId;

    @Column
    private Long primaryEntityId;

    @Column
    private int percentCompleted;

    @Override
    public String getDescription() {
        return title;
    }

    public String getWizard() {
        return wizard;
    }

    public void setWizard(String wizard) {
        this.wizard = wizard;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Long getPrimaryEntityId() {
        return primaryEntityId;
    }

    public void setPrimaryEntityId(Long primaryEntityId) {
        this.primaryEntityId = primaryEntityId;
    }

    public int getPercentCompleted() {
        return percentCompleted;
    }

    public void setPercentCompleted(int percentCompleted) {
        this.percentCompleted = percentCompleted;
    }

}
