/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.chart.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseEntity;
import com.flowcentraltech.flowcentral.configuration.constants.ChartSeriesDataType;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.ListOnly;
import com.tcdng.unify.core.annotation.Table;

/**
 * Chart snapshot series entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_CHARTSNAPSHOTSERIES")
public class ChartSnapshotSeries extends BaseEntity {

    @ForeignKey(ChartSnapshot.class)
    private Long chartSnapshotId;

    @ForeignKey
    private ChartSeriesDataType seriesDataType;

    @Column(name = "CHARTSNAPSHOTSERIES_NM", length = 64)
    private String name;

    @Column(length = 2048)
    private String series;

    @ListOnly(key = "seriesDataType", property = "description")
    private String seriesDataTypeDesc;

    public ChartSnapshotSeries(ChartSeriesDataType seriesDataType, String name, String series) {
        this.seriesDataType = seriesDataType;
        this.name = name;
        this.series = series;
    }

    public ChartSnapshotSeries() {

    }

    @Override
    public String getDescription() {
        return name;
    }

    public Long getChartSnapshotId() {
        return chartSnapshotId;
    }

    public void setChartSnapshotId(Long chartSnapshotId) {
        this.chartSnapshotId = chartSnapshotId;
    }

    public ChartSeriesDataType getSeriesDataType() {
        return seriesDataType;
    }

    public void setSeriesDataType(ChartSeriesDataType seriesDataType) {
        this.seriesDataType = seriesDataType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getSeriesDataTypeDesc() {
        return seriesDataTypeDesc;
    }

    public void setSeriesDataTypeDesc(String seriesDataTypeDesc) {
        this.seriesDataTypeDesc = seriesDataTypeDesc;
    }

}
