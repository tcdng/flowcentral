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
 * Entity base type.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table("FC_ENTITYBASETYPE")
@StaticList(name = "entitybasetypelist", description = "$m{staticlist.entitybasetypelist}")
public enum EntityBaseType implements EnumConst {

    BASE_ENTITY(
            "ENT"),
    BASE_AUDIT_ENTITY(
            "ADE"),
    BASE_STATUS_ENTITY(
            "STA"),
    BASE_WORK_ENTITY(
            "WKE"),
    BASE_STATUS_WORK_ENTITY(
            "SWK"),
    BASE_NAMED_ENTITY(
            "NME"),
    BASE_CONFIG_ENTITY(
            "CGE"),
    BASE_CONFIG_NAMED_ENTITY(
            "CNE"),
    BASE_APPLICATION_ENTITY(
            "APE");

    private final String code;

    private EntityBaseType(String code) {
        this.code = code;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String defaultCode() {
        return BASE_ENTITY.code;
    }

    public boolean isAuditType() {
        return !BASE_ENTITY.equals(this) && !BASE_CONFIG_ENTITY.equals(this);
    }

    public boolean isWorkEntityType() {
        return BASE_WORK_ENTITY.equals(this) || BASE_STATUS_WORK_ENTITY.equals(this);
    }

    public static EntityBaseType fromCode(String code) {
        return EnumUtils.fromCode(EntityBaseType.class, code);
    }

    public static EntityBaseType fromName(String name) {
        return EnumUtils.fromName(EntityBaseType.class, name);
    }
}
