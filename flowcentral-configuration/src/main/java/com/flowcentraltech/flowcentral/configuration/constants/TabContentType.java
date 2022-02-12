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
 * Tab content type.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table("FC_TABCONTENTTYPE")
@StaticList(name = "tabcontenttypelist", description = "$m{staticlist.tabcontenttypelist}")
public enum TabContentType implements EnumConst {

    MINIFORM(
            "MNF"),
    MINIFORM_CHANGELOG(
            "MNC"),
    CHILD(
            "CHD"),
    CHILD_LIST(
            "CHL"),
    FILTER_CONDITION(
            "FIL"),
    FIELD_SEQUENCE(
            "FSQ"),
    PARAM_VALUES(
            "PMV"),
    PROPERTY_LIST(
            "PRL"),
    SET_VALUES(
            "STV");

    private final String code;

    private TabContentType(String code) {
        this.code = code;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String defaultCode() {
        return MINIFORM.code;
    }

    public boolean isChildOrChildList() {
        return this.equals(CHILD) || this.equals(CHILD_LIST);
    }
    
    public boolean isMiniForm() {
        return this.equals(MINIFORM) || this.equals(MINIFORM_CHANGELOG);
    }

    public static TabContentType fromCode(String code) {
        return EnumUtils.fromCode(TabContentType.class, code);
    }

    public static TabContentType fromName(String name) {
        return EnumUtils.fromName(TabContentType.class, name);
    }

}
