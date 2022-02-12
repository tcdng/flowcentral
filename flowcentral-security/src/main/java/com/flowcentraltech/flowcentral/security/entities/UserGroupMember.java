/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.security.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseAuditEntity;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.ListOnly;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.annotation.UniqueConstraint;
import com.tcdng.unify.core.data.Describable;
import com.tcdng.unify.core.util.StringUtils;

/**
 * Entity for storing user group member information.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_USERGROUPMEMBER", uniqueConstraints = { @UniqueConstraint({ "userGroupId", "userId" }) })
public class UserGroupMember extends BaseAuditEntity implements Describable {

    @ForeignKey(UserGroup.class)
    private Long userGroupId;

    @ForeignKey(User.class)
    private Long userId;

    @ListOnly(key = "userGroupId", property = "name")
    private String userGroupName;

    @ListOnly(key = "userGroupId", property = "description")
    private String userGroupDesc;

    @ListOnly(key = "userGroupId", property = "email")
    private String userGroupEmail;

    @ListOnly(key = "userId", property = "loginId")
    private String userLoginId;

    @ListOnly(key = "userId", property = "fullName")
    private String userFullName;

    @ListOnly(key = "userId", property = "email")
    private String userEmail;

    @ListOnly(key = "userId", property = "branchId")
    private Long userBranchId;

    @ListOnly(key = "userId", property = "branchDesc")
    private String userBranchDesc;

    @Override
    public String getDescription() {
        return StringUtils.concatenate(userGroupDesc, " - ", userFullName);
    }

    public Long getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(Long userGroupId) {
        this.userGroupId = userGroupId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserGroupName() {
        return userGroupName;
    }

    public void setUserGroupName(String userGroupName) {
        this.userGroupName = userGroupName;
    }

    public String getUserGroupDesc() {
        return userGroupDesc;
    }

    public void setUserGroupDesc(String userGroupDesc) {
        this.userGroupDesc = userGroupDesc;
    }

    public String getUserGroupEmail() {
        return userGroupEmail;
    }

    public void setUserGroupEmail(String userGroupEmail) {
        this.userGroupEmail = userGroupEmail;
    }

    public String getUserLoginId() {
        return userLoginId;
    }

    public void setUserLoginId(String userLoginId) {
        this.userLoginId = userLoginId;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Long getUserBranchId() {
        return userBranchId;
    }

    public void setUserBranchId(Long userBranchId) {
        this.userBranchId = userBranchId;
    }

    public String getUserBranchDesc() {
        return userBranchDesc;
    }

    public void setUserBranchDesc(String userBranchDesc) {
        this.userBranchDesc = userBranchDesc;
    }

}
