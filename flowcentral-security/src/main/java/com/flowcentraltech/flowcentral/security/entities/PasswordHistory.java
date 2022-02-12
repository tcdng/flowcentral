/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.security.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseAuditEntity;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.Table;

/**
 * Entity for storing password history information.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_PASSWORDHIST")
public class PasswordHistory extends BaseAuditEntity {

    @ForeignKey(User.class)
    private Long userId;

    @Column(length = 512)
    private String password;

    @Override
    public String getDescription() {
        return null;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
