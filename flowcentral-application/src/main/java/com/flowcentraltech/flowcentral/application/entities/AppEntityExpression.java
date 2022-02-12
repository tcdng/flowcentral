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
 * Application entity expression.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_ENTITYEXPRESSION", uniqueConstraints = { @UniqueConstraint({ "appEntityId", "name" }) })
public class AppEntityExpression extends BaseConfigNamedEntity {

    @ForeignKey(AppEntity.class)
    private Long appEntityId;
    
    @Column(name = "EXPRESSION", length = 512)
    private String expression;

    public Long getAppEntityId() {
        return appEntityId;
    }

    public void setAppEntityId(Long appEntityId) {
        this.appEntityId = appEntityId;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

}
