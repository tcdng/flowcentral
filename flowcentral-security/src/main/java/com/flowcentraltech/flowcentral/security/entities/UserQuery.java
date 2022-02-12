/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.security.entities;

import java.util.Collection;

import com.flowcentraltech.flowcentral.common.entities.BaseStatusWorkEntityQuery;

/**
 * Query class for user records.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class UserQuery extends BaseStatusWorkEntityQuery<User> {

    public UserQuery() {
        super(User.class);
    }

    @Override
    public UserQuery id(Long id) {
        return (UserQuery) super.id(id);
    }

    @Override
    public UserQuery idIn(Collection<Long> id) {
        return (UserQuery) super.idIn(id);
    }

    @Override
    public UserQuery idNotIn(Collection<Long> id) {
        return (UserQuery) super.idNotIn(id);
    }

    public UserQuery fullNameLike(String fullName) {
        return (UserQuery) addLike("fullName", fullName);
    }

    public UserQuery loginId(String loginId) {
        return (UserQuery) addEquals("loginId", loginId);
    }

    public UserQuery loginIdLike(String loginId) {
        return (UserQuery) addLike("loginId", loginId);
    }

    public UserQuery password(String password) {
        return (UserQuery) addEquals("password", password);
    }

    public UserQuery branchCode(String branchCode) {
        return (UserQuery) addEquals("branchCode", branchCode);
    }
}
