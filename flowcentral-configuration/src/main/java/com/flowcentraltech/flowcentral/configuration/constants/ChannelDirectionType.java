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
 * Channel direction type enumeration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table("FC_CHANNELDIRECTIONTYPE")
@StaticList(name = "channeldirectiontypelist", description = "$m{staticlist.channeldirectiontypelist}")
public enum ChannelDirectionType implements EnumConst {

    INWARD("I"),
    OUTWARD("O");

    private final String code;

    private ChannelDirectionType(String code) {
        this.code = code;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String defaultCode() {
        return INWARD.code;
    }

    public static ChannelDirectionType fromCode(String code) {
        return EnumUtils.fromCode(ChannelDirectionType.class, code);
    }

    public static ChannelDirectionType fromName(String name) {
        return EnumUtils.fromName(ChannelDirectionType.class, name);
    }

}
