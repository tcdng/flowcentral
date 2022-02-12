/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.chart.data;

import java.util.List;

import com.flowcentraltech.flowcentral.configuration.constants.ChartCategoryDataType;

/**
 * Integer chart categories.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class IntegerChartCategories extends ChartCategories<Integer> {

    public IntegerChartCategories(List<Integer> categories) {
        super(categories);
    }

    public IntegerChartCategories(Integer[] categories) {
        super(categories);
    }

    @Override
    public ChartCategoryDataType getCategoryType() {
        return ChartCategoryDataType.INTEGER;
    }

    @Override
    public Class<Integer> getDataType() {
        return Integer.class;
    }

}
