/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.constants;

import com.tcdng.unify.convert.constants.EnumConst;
import com.tcdng.unify.core.annotation.StaticList;
import com.tcdng.unify.core.util.EnumUtils;

/**
 * Product category constants.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@StaticList(name = "productcategorylist", description = "Product Category List")
public enum ProductCategory implements EnumConst {

    SHIRTS(
            "SHT"),
    PANTS(
            "PNT");

    private final String code;

    private ProductCategory(String code) {
        this.code = code;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String defaultCode() {
        return SHIRTS.code;
    }

    public static ProductCategory fromCode(String code) {
        return EnumUtils.fromCode(ProductCategory.class, code);
    }

    public static ProductCategory fromName(String name) {
        return EnumUtils.fromName(ProductCategory.class, name);
    }

}
