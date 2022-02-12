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
 * Integer chart series.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class IntegerChartSeries extends ChartSeries<Integer> {

    public IntegerChartSeries(String name, Integer[] data) {
        super(name, data);
    }

    public IntegerChartSeries(String name, List<Integer> data) {
        super(name, data);
    }

    @Override
    public ChartSeriesDataType getSeriesType() {
        return ChartSeriesDataType.INTEGER;
    }

    @Override
    public Class<Integer> getDataType() {
        return Integer.class;
    }

}
