/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.system.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseStatusEntityQuery;

/**
 * Credential query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class CredentialQuery extends BaseStatusEntityQuery<Credential> {

    public CredentialQuery() {
        super(Credential.class);
    }

    public CredentialQuery name(String name) {
        return (CredentialQuery) addEquals("name", name);
    }

    public CredentialQuery nameLike(String name) {
        return (CredentialQuery) addLike("name", name);
    }

    public CredentialQuery descriptionLike(String description) {
        return (CredentialQuery) addLike("description", description);
    }
}
