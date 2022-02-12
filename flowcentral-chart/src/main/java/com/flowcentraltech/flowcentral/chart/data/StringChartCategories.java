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
 * String chart categories.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class StringChartCategories extends ChartCategories<String> {

    public StringChartCategories(List<String> categories) {
        super(categories);
    }

    public StringChartCategories(String[] categories) {
        super(categories);
    }

    @Override
    public ChartCategoryDataType getCategoryType() {
        return ChartCategoryDataType.STRING;
    }

    @Override
    public Class<String> getDataType() {
        return String.class;
    }

}
