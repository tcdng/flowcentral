/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.chart.data;

/**
 * Chart snapshot definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ChartSnapshotDef {

    private String name;

    private String description;

    private ChartData chartData;

    private Long id;

    private long version;

    public ChartSnapshotDef(String name, String description, ChartData chartData, Long id, long version) {
        this.name = name;
        this.description = description;
        this.chartData = chartData;
        this.id = id;
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ChartData getChartData() {
        return chartData;
    }

    public Long getId() {
        return id;
    }

    public long getVersion() {
        return version;
    }
}
