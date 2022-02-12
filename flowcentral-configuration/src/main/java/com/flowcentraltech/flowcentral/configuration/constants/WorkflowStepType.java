/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.constants;

import java.util.Arrays;
import java.util.List;

import com.tcdng.unify.convert.constants.EnumConst;
import com.tcdng.unify.core.annotation.StaticList;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.util.EnumUtils;

/**
 * Workflow step type constants.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table("FC_WFSTEPTYPE")
@StaticList(name = "wfsteptypelist", description = "$m{staticlist.wfsteptypelist}")
public enum WorkflowStepType implements EnumConst {

    START(
            "STR",
            "play",
            WorkflowStepColor.GREEN,
            true,
            false,
            false,
            0),
    ENRICHMENT(
            "ENR",
            "outdent",
            WorkflowStepColor.CYAN,
            true,
            true,
            false,
            1),
    PROCEDURE(
            "PRC",
            "stream",
            WorkflowStepColor.CYAN,
            true,
            true,
            false,
            2),
    RECORD_ACTION(
            "REC",
            "database",
            WorkflowStepColor.NAVY,
            true,
            true,
            false,
            3),
    BINARY_ROUTING(
            "BRT",
            "directions",
            WorkflowStepColor.BLUE,
            false,
            true,
            false,
            4),
    POLICY_ROUTING(
            "PRT",
            "directions",
            WorkflowStepColor.BLUE,
            false,
            true,
            false,
            5),
    MULTI_ROUTING(
            "MRT",
            "directions",
            WorkflowStepColor.BLUE,
            false,
            true,
            false,
            6),
    USER_ACTION(
            "USR",
            "user-check",
            WorkflowStepColor.ORANGE,
            true,
            true,
            true,
            7),
    SET_VALUES(
            "SET",
            "equals",
            WorkflowStepColor.PURPLE,
            true,
            false,
            false,
            8),
    ERROR(
            "ERR",
            "exclamation-circle",
            WorkflowStepColor.RED,
            true,
            true,
            true,
            9),
    END(
            "END",
            "flag",
            WorkflowStepColor.BLACK,
            true,
            false,
            false,
            10);

    private final String code;

    private final String icon;

    private final WorkflowStepColor color;

    private final boolean supportSetValues;

    private final boolean sendPassThroughAlert;

    private final boolean sendUserActionAlert;

    private final int index;

    private static final List<WorkflowStepType> list = Arrays.asList(values());

    private WorkflowStepType(String code, String icon, WorkflowStepColor color, boolean supportSetValues,
            boolean sendPassThrough, boolean sendUserActionAlert, int index) {
        this.code = code;
        this.icon = icon;
        this.color = color;
        this.supportSetValues = supportSetValues;
        this.sendPassThroughAlert = sendPassThrough;
        this.sendUserActionAlert = sendUserActionAlert;
        this.index = index;
    }

    @Override
    public String code() {
        return code;
    }

    public String icon() {
        return icon;
    }

    public WorkflowStepColor color() {
        return color;
    }

    public boolean supportSetValues() {
        return supportSetValues;
    }

    public boolean sendPassThroughAlert() {
        return sendPassThroughAlert;
    }

    public boolean sendUserActionAlert() {
        return sendUserActionAlert;
    }

    public int index() {
        return index;
    }

    @Override
    public String defaultCode() {
        return START.code;
    }

    public boolean isStart() {
        return START.equals(this);
    }

    public boolean isError() {
        return ERROR.equals(this);
    }

    public boolean isEnd() {
        return END.equals(this);
    }

    public boolean isAcceptInflow() {
        return !START.equals(this) && !ERROR.equals(this);
    }

    public boolean isBinaryRouting() {
        return BINARY_ROUTING.equals(this);
    }

    public boolean isPolicy() {
        return ENRICHMENT.equals(this) || PROCEDURE.equals(this) || POLICY_ROUTING.equals(this);
    }

    public boolean isOptional() {
        return !START.equals(this) && !END.equals(this) && !ERROR.equals(this);
    }

    public boolean isAutomatic() {
        return !USER_ACTION.equals(this) && !ERROR.equals(this);
    }

    public boolean isSetValues() {
        return SET_VALUES.equals(this);
    }

    public boolean isUserInteractive() {
        return USER_ACTION.equals(this);
    }

    public boolean isRecordAction() {
        return RECORD_ACTION.equals(this);
    }

    public boolean isSettling() {
        return USER_ACTION.equals(this) || ERROR.equals(this);
    }

    public boolean isFlowing() {
        return !isTerminal();
    }

    public boolean isTerminal() {
        return USER_ACTION.equals(this) || ERROR.equals(this) || END.equals(this);
    }

    public static List<WorkflowStepType> asList() {
        return list;
    }

    public static WorkflowStepType fromIndex(int index) {
        return list.get(index);
    }

    public static int length() {
        return list.size();
    }

    public static WorkflowStepType fromCode(String code) {
        return EnumUtils.fromCode(WorkflowStepType.class, code);
    }

    public static WorkflowStepType fromName(String name) {
        return EnumUtils.fromName(WorkflowStepType.class, name);
    }
}
