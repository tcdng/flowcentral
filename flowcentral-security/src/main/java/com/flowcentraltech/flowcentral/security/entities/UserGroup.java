/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.security.entities;

import java.util.List;

import com.flowcentraltech.flowcentral.common.entities.BaseStatusEntity;
import com.tcdng.unify.core.annotation.ChildList;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.annotation.UniqueConstraint;

/**
 * Entity for storing user group information.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_USERGROUP",
        uniqueConstraints = { @UniqueConstraint({ "name" }), @UniqueConstraint({ "description" }) })
public class UserGroup extends BaseStatusEntity {

    @Column(name = "USERGROUP_NM", length = 64)
    private String name;

    @Column(name = "USERGROUP_DESC", length = 96)
    private String description;

    @Column(length = 64, nullable = true)
    private String email;

    @ChildList
    private List<UserGroupRole> userGroupRoleList;

    @ChildList
    private List<UserGroupMember> userGroupMemberList;

    @Override
    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<UserGroupRole> getUserGroupRoleList() {
        return userGroupRoleList;
    }

    public void setUserGroupRoleList(List<UserGroupRole> userGroupRoleList) {
        this.userGroupRoleList = userGroupRoleList;
    }

    public List<UserGroupMember> getUserGroupMemberList() {
        return userGroupMemberList;
    }

    public void setUserGroupMemberList(List<UserGroupMember> userGroupMemberList) {
        this.userGroupMemberList = userGroupMemberList;
    }

}
