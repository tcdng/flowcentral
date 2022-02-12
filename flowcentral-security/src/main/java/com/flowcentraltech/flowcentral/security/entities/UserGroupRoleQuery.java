/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.security.entities;

import java.util.Collection;
import java.util.Date;

import com.flowcentraltech.flowcentral.common.constants.RecordStatus;
import com.flowcentraltech.flowcentral.common.entities.BaseAuditEntityQuery;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.criterion.OrBuilder;
import com.tcdng.unify.core.util.CalendarUtils;

/**
 * Query class for user group roles.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class UserGroupRoleQuery extends BaseAuditEntityQuery<UserGroupRole> {

    public UserGroupRoleQuery() {
        super(UserGroupRole.class);
    }

    public UserGroupRoleQuery userGroupId(Long userGroupId) {
        return (UserGroupRoleQuery) addEquals("userGroupId", userGroupId);
    }

    public UserGroupRoleQuery userGroupIdIn(Collection<Long> userGroupId) {
        return (UserGroupRoleQuery) addAmongst("userGroupId", userGroupId);
    }

    public UserGroupRoleQuery roleId(Long roleId) {
        return (UserGroupRoleQuery) addEquals("roleId", roleId);
    }

    public UserGroupRoleQuery roleIdNot(Long roleId) {
        return (UserGroupRoleQuery) addNotEquals("roleId", roleId);
    }

    public UserGroupRoleQuery roleCode(String roleCode) {
        return (UserGroupRoleQuery) addEquals("roleCode", roleCode);
    }

    public UserGroupRoleQuery roleCodeNot(String roleCode) {
        return (UserGroupRoleQuery) addNotEquals("roleCode", roleCode);
    }

    public UserGroupRoleQuery roleStatus(RecordStatus roleStatus) {
        return (UserGroupRoleQuery) addEquals("roleStatus", roleStatus);
    }

    public UserGroupRoleQuery roleCodeIn(Collection<String> roleCode) {
        return (UserGroupRoleQuery) addAmongst("roleCode", roleCode);
    }

    public UserGroupRoleQuery roleCodeNotIn(Collection<String> roleCode) {
        return (UserGroupRoleQuery) addNotAmongst("roleCode", roleCode);
    }

    public UserGroupRoleQuery roleActiveTime(Date date) throws UnifyException {
        date = CalendarUtils.getTimeOfDay(date);
        return (UserGroupRoleQuery) addRestriction(
                new OrBuilder().less("activeBefore", date).isNull("activeBefore").build())
                        .addRestriction(new OrBuilder().greater("activeAfter", date).isNull("activeAfter").build());
    }
}
