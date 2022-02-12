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
 * License status enumeration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table("FC_LICENSESTATUS")
@StaticList(name = "licensestatuslist", description = "$m{staticlist.licensestatuslist}")
public enum LicenseStatus implements EnumConst {

    LICENSED(
            "LIC"),
    NOT_LICENSED(
            "NLC"),
    EXPIRED(
            "EXP");

    private final String code;

    private LicenseStatus(String code) {
        this.code = code;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String defaultCode() {
        return NOT_LICENSED.code;
    }

    public boolean isLicensed() {
        return LICENSED.equals(this);
    }

    public boolean isNotLicensed() {
        return NOT_LICENSED.equals(this);
    }

    public boolean isExpired() {
        return EXPIRED.equals(this);
    }

    public static LicenseStatus fromCode(String code) {
        return EnumUtils.fromCode(LicenseStatus.class, code);
    }

    public static LicenseStatus fromName(String name) {
        return EnumUtils.fromName(LicenseStatus.class, name);
    }

}
