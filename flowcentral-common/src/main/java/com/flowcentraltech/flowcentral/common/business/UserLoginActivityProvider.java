/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.business;

import java.util.List;

import com.flowcentraltech.flowcentral.common.data.UserRoleInfo;
import com.tcdng.unify.core.UnifyComponent;
import com.tcdng.unify.core.UnifyException;

/**
 * User login activity provider.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface UserLoginActivityProvider extends UnifyComponent {

    /**
     * Gets available user roles excluding supplied role that are active now.
     * 
     * @param userLoginId
     *                        the user login ID
     * @param excludeRoleCode
     *                        the code of the role to exclude
     * @return the user role list
     * @throws UnifyException
     *                        if an error occurs
     */
    List<UserRoleInfo> getAvailableUserRolesActiveNow(String userLoginId, String excludeRoleCode) throws UnifyException;

    /**
     * Logs out current session user.
     * 
     * @param complete
     *                 indicates if session should be nullified.
     * @throws UnifyException
     *                        if an error occurs
     */
    void logoutUser(boolean complete) throws UnifyException;

}
