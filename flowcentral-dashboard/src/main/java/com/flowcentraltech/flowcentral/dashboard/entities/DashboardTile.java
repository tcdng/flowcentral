/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.dashboard.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseConfigNamedEntity;
import com.flowcentraltech.flowcentral.configuration.constants.DashboardTileType;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.ListOnly;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.annotation.UniqueConstraint;

/**
 * Dashboard snapshot entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_DASHBOARDTILE",
        uniqueConstraints = { @UniqueConstraint({ "name" }), @UniqueConstraint({ "description" }) })
public class DashboardTile extends BaseConfigNamedEntity {

    @ForeignKey(Dashboard.class)
    private Long dashboardId;

    @ForeignKey(name = "DASHBOARDTILE_TY")
    private DashboardTileType type;

    @Column(name = "CHART_NM", length = 128)
    private String chart;

    @Column
    private int section;

    @Column(name = "DISPLAY_INDEX")
    private int index;

    @ListOnly(key = "type", property = "description")
    private String typeDesc;

    public DashboardTile() {

    }

    public Long getDashboardId() {
        return dashboardId;
    }

    public void setDashboardId(Long dashboardId) {
        this.dashboardId = dashboardId;
    }

    public DashboardTileType getType() {
        return type;
    }

    public void setType(DashboardTileType type) {
        this.type = type;
    }

    public String getChart() {
        return chart;
    }

    public void setChart(String chart) {
        this.chart = chart;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

}
