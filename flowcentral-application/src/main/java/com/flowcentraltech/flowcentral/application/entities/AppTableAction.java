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
import com.tcdng.unify.core.annotation.UniqueConstraint;

/**
 * Application table action entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_TABLEACTION", uniqueConstraints = { @UniqueConstraint({ "appTableId", "name" }) })
public class AppTableAction extends BaseConfigNamedEntity {

    @ForeignKey(AppTable.class)
    private Long appTableId;

    @Column(name = "TABLEACTION_LABEL", length = 64)
    private String label;

    @Column(name = "ACTION_POLICY", length = 64)
    private String policy;

    @Column
    private int orderIndex;

    public Long getAppTableId() {
        return appTableId;
    }

    public void setAppTableId(Long appTableId) {
        this.appTableId = appTableId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public int getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(int orderIndex) {
        this.orderIndex = orderIndex;
    }

}
