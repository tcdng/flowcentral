/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.security.entities;

import java.util.Collection;

import com.flowcentraltech.flowcentral.common.entities.BaseAuditEntityQuery;

/**
 * Query class for user group members.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class UserGroupMemberQuery extends BaseAuditEntityQuery<UserGroupMember> {

    public UserGroupMemberQuery() {
        super(UserGroupMember.class);
    }

    public UserGroupMemberQuery userGroupId(Long userGroupId) {
        return (UserGroupMemberQuery) addEquals("userGroupId", userGroupId);
    }

    public UserGroupMemberQuery userGroupIdIn(Collection<Long> userGroupId) {
        return (UserGroupMemberQuery) addAmongst("userGroupId", userGroupId);
    }

    public UserGroupMemberQuery userId(Long userId) {
        return (UserGroupMemberQuery) addEquals("userId", userId);
    }

    public UserGroupMemberQuery userLoginId(String userLoginId) {
        return (UserGroupMemberQuery) addEquals("userLoginId", userLoginId);
    }
}
