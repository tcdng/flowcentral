/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.security.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseAuditEntityQuery;

/**
 * Query class for password history.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class PasswordHistoryQuery extends BaseAuditEntityQuery<PasswordHistory> {

    public PasswordHistoryQuery() {
        super(PasswordHistory.class);
    }

    public PasswordHistoryQuery userId(Long userId) {
        return (PasswordHistoryQuery) addEquals("userId", userId);
    }

    public PasswordHistoryQuery password(String password) {
        return (PasswordHistoryQuery) addEquals("password", password);
    }
}
