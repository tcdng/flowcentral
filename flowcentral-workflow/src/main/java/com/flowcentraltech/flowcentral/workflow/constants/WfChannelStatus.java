/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.workflow.constants;

import com.tcdng.unify.convert.constants.EnumConst;
import com.tcdng.unify.core.annotation.StaticList;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.util.EnumUtils;

/**
 * Workflow channel status
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table("FC_WFCHANNELSTATUS")
@StaticList(name = "wfchannelstatuslist", description = "$m{staticlist.wfchannelstatuslist}")
public enum WfChannelStatus implements EnumConst {

    OPEN("O"),
    CLOSED("C"),
    SUSPENDED("S");

    private final String code;

    private WfChannelStatus(String code) {
        this.code = code;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String defaultCode() {
        return OPEN.code;
    }

    public static WfChannelStatus fromCode(String code) {
        return EnumUtils.fromCode(WfChannelStatus.class, code);
    }

    public static WfChannelStatus fromName(String name) {
        return EnumUtils.fromName(WfChannelStatus.class, name);
    }

}
