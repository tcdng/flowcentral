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
 * Double chart series.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class DoubleChartSeries extends ChartSeries<Double> {

    public DoubleChartSeries(String name, Double[] data) {
        super(name, data);
    }

    public DoubleChartSeries(String name, List<Double> data) {
        super(name, data);
    }

    @Override
    public ChartSeriesDataType getSeriesType() {
        return ChartSeriesDataType.DOUBLE;
    }

    @Override
    public Class<Double> getDataType() {
        return Double.class;
    }

}
