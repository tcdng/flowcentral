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
 * UI action type.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table("FC_UIACTIONTYPE")
@StaticList(name = "uiactiontypelist", description = "$m{staticlist.uiactiontypelist}")
public enum UIActionType implements EnumConst {

    BUTTON(
            "BTN"),
    LINK(
            "LNK");

    private final String code;

    private UIActionType(String code) {
        this.code = code;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String defaultCode() {
        return BUTTON.code;
    }

    public static UIActionType fromCode(String code) {
        return EnumUtils.fromCode(UIActionType.class, code);
    }

    public static UIActionType fromName(String name) {
        return EnumUtils.fromName(UIActionType.class, name);
    }

}
