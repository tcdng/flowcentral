/*
 * Copyright 2021-2022 FlowCentral Technologies Limited.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.flowcentraltech.flowcentral.common.business;

import java.util.Collection;
import java.util.List;

import com.tcdng.unify.core.UnifyComponent;
import com.tcdng.unify.core.UnifyException;

/**
 * Role participating user provider.
 * 
 * @author FlowCentral Technologies Limited
 * @since 1.0
 */
public interface RoleParticipatingUserProvider extends UnifyComponent {

    /**
     * Gets participating users by role.
     * 
     * @param branchCode
     *                   the optional branch code
     * @param roleCode
     *                   the role code
     * @return a list of recipients
     * @throws UnifyException
     *                        if an error occurs
     */
    List<String> getParticipatingUsersByRole(String branchCode, String roleCode) throws UnifyException;

    /**
     * Gets participating users by roles.
     * 
     * @param branchCode
     *                   the optional branch code
     * @param roles
     *                   the role codes
     * @return a list of recipients
     * @throws UnifyException
     *                        if an error occurs
     */
    List<String> getParticipatingUsersByRole(String branchCode, Collection<String> roles) throws UnifyException;
}
