/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.dashboard.data;

import com.flowcentraltech.flowcentral.configuration.constants.DashboardTileType;

/**
 * Dashboard tile definition object.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class DashboardTileDef {

    private DashboardTileType type;

    private String name;

    private String description;

    private String chart;

    private int section;

    private int index;

    public DashboardTileDef(DashboardTileType type, String name, String description, String chart, int section,
            int index) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.chart = chart;
        this.section = section;
        this.index = index;
    }

    public DashboardTileType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getChart() {
        return chart;
    }

    public int getSection() {
        return section;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return "DashboardTileDef [type=" + type + ", name=" + name + ", description=" + description + ", chart=" + chart
                + ", section=" + section + ", index=" + index + "]";
    }

}
