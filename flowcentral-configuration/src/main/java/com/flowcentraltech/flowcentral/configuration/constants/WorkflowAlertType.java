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
package com.flowcentraltech.flowcentral.configuration.constants;

import com.tcdng.unify.convert.constants.EnumConst;
import com.tcdng.unify.core.annotation.StaticList;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.util.EnumUtils;

/**
 * Workflow alert type constants.
 * 
 * @author FlowCentral Technologies Limited
 * @since 1.0
 */
@Table("FC_WFALERTTYPE")
@StaticList(name = "wfalerttypelist", description = "$m{staticlist.wfalerttypelist}")
public enum WorkflowAlertType implements EnumConst {

    PASS_THROUGH(
            "P"),
    USER_INTERACT(
            "U"),
    CRITICAL_NOTIFICATION(
            "C"),
    EXPIRATION_NOTIFICATION(
            "E");

    private final String code;

    private WorkflowAlertType(String code) {
        this.code = code;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String defaultCode() {
        return USER_INTERACT.code;
    }

    public boolean isPassThrough() {
        return PASS_THROUGH.equals(this);
    }

    public boolean isUserInteract() {
        return USER_INTERACT.equals(this);
    }

    public boolean isCriticalNotification() {
        return CRITICAL_NOTIFICATION.equals(this);
    }

    public boolean isExpirationNotification() {
        return EXPIRATION_NOTIFICATION.equals(this);
    }

    public static WorkflowAlertType fromCode(String code) {
        return EnumUtils.fromCode(WorkflowAlertType.class, code);
    }

    public static WorkflowAlertType fromName(String name) {
        return EnumUtils.fromName(WorkflowAlertType.class, name);
    }
}
