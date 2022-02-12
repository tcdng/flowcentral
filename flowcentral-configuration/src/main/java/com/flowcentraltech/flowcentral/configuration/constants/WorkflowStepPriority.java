/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.constants;

import com.tcdng.unify.convert.constants.EnumConst;
import com.tcdng.unify.core.annotation.StaticList;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.util.EnumUtils;

/**
 * Workflow step priority levels.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table("FC_WFSTEPPRIORITY")
@StaticList(name = "wfstepprioritylist", description = "$m{staticlist.wfstepprioritylist}")
public enum WorkflowStepPriority implements EnumConst {

    CRITICAL(
            "C"),
    HIGH(
            "H"),
    NORMAL(
            "N"),
    LOW(
            "L");

    private final String code;

    private WorkflowStepPriority(String code) {
        this.code = code;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String defaultCode() {
        return NORMAL.code;
    }

    public static WorkflowStepPriority fromCode(String code) {
        return EnumUtils.fromCode(WorkflowStepPriority.class, code);
    }

    public static WorkflowStepPriority fromName(String name) {
        return EnumUtils.fromName(WorkflowStepPriority.class, name);
    }
}
