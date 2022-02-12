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
 * Long chart categories.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class LongChartCategories extends ChartCategories<Long> {

    public LongChartCategories(List<Long> categories) {
        super(categories);
    }

    public LongChartCategories(Long[] categories) {
        super(categories);
    }

    @Override
    public ChartCategoryDataType getCategoryType() {
        return ChartCategoryDataType.LONG;
    }

    @Override
    public Class<Long> getDataType() {
        return Long.class;
    }

}
