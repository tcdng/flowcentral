/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.data;

/**
 * User role information.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class UserRoleInfo {

    private String roleCode;

    private String roleDesc;

    private String groupName;

    private String groupDesc;

    private String departmentCode;

    public UserRoleInfo(String roleCode, String roleDesc, String groupName, String groupDesc, String departmentCode) {
        this.roleCode = roleCode;
        this.roleDesc = roleDesc;
        this.groupName = groupName;
        this.groupDesc = groupDesc;
        this.departmentCode = departmentCode;
    }

    public UserRoleInfo(String roleCode, String roleDesc, String departmentCode) {
        this.roleCode = roleCode;
        this.roleDesc = roleDesc;
        this.departmentCode = departmentCode;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }
}
