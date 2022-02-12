/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.chart.data;

import java.util.Date;
import java.util.List;

import com.flowcentraltech.flowcentral.configuration.constants.ChartCategoryDataType;

/**
 * Date chart categories.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class DateChartCategories extends ChartCategories<Date> {

    public DateChartCategories(List<Date> categories) {
        super(categories);
    }

    public DateChartCategories(Date[] categories) {
        super(categories);
    }

    @Override
    public ChartCategoryDataType getCategoryType() {
        return ChartCategoryDataType.DATE;
    }

    @Override
    public Class<Date> getDataType() {
        return Date.class;
    }

}
