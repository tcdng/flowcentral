/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.data;

import java.util.List;

/**
 * User role options.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class UserRoleOptions {

    private List<UserRoleInfo> userRoleList;

    public UserRoleOptions(List<UserRoleInfo> userRoleList) {
        this.userRoleList = userRoleList;
    }

    public List<UserRoleInfo> getUserRoleList() {
        return userRoleList;
    }
}
