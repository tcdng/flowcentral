/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.common.constants;

import com.tcdng.unify.convert.constants.EnumConst;
import com.tcdng.unify.core.annotation.StaticList;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.util.EnumUtils;

/**
 * Record status enumeration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table("FC_RECORDSTATUS")
@StaticList(name = "statuslist", description = "$m{staticlist.statuslist}")
public enum RecordStatus implements EnumConst {

    ACTIVE(
            "A"),
    INACTIVE(
            "I"),
    DORMANT(
            "D");

    private final String code;

    private RecordStatus(String code) {
        this.code = code;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String defaultCode() {
        return INACTIVE.code;
    }

    public static RecordStatus fromCode(String code) {
        return EnumUtils.fromCode(RecordStatus.class, code);
    }

    public static RecordStatus fromName(String name) {
        return EnumUtils.fromName(RecordStatus.class, name);
    }

}
