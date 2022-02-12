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
 * Dashboard tile type constants.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table("FC_DASHBOARDTILETYPE")
@StaticList(name = "dashboardtiletypelist", description = "$m{staticlist.dashboardtiletypelist}")
public enum DashboardTileType implements EnumConst {

    SIMPLE(
            "SMP"),
    SPARKLINE(
            "SPK");

    private final String code;

    private DashboardTileType(String code) {
        this.code = code;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String defaultCode() {
        return SIMPLE.code;
    }

    public static DashboardTileType fromCode(String code) {
        return EnumUtils.fromCode(DashboardTileType.class, code);
    }

    public static DashboardTileType fromName(String name) {
        return EnumUtils.fromName(DashboardTileType.class, name);
    }
}
