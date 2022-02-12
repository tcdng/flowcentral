/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.chart.data;

import java.util.List;

import com.flowcentraltech.flowcentral.configuration.constants.ChartSeriesDataType;

/**
 * Long chart series.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class LongChartSeries extends ChartSeries<Long> {

    public LongChartSeries(String name, Long[] data) {
        super(name, data);
    }

    public LongChartSeries(String name, List<Long> data) {
        super(name, data);
    }

    @Override
    public ChartSeriesDataType getSeriesType() {
        return ChartSeriesDataType.LONG;
    }

    @Override
    public Class<Long> getDataType() {
        return Long.class;
    }

}
