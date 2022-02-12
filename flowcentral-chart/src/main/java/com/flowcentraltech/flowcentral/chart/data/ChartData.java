/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.chart.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.flowcentraltech.flowcentral.configuration.constants.ChartCategoryDataType;
import com.flowcentraltech.flowcentral.configuration.constants.ChartSeriesDataType;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.util.DataUtils;

/**
 * Chart data.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ChartData {

    private ChartCategories<?> categories;

    private List<ChartSeries<?>> series;

    private ChartData(ChartCategories<?> categories, List<ChartSeries<?>> series) {
        this.categories = categories;
        this.series = series;
    }

    public ChartCategories<?> getCategories() {
        return categories;
    }

    public List<ChartSeries<?>> getSeries() {
        return series;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {

        private ChartCategories<?> categories;

        private List<ChartSeries<?>> series;

        public Builder() {
            series = new ArrayList<ChartSeries<?>>();
        }

        public Builder categories(ChartCategoryDataType type, String categoriesJson) throws UnifyException {
            switch (type) {
                case DATE:
                    categories = new DateChartCategories(
                            DataUtils.convert(Date[].class, DataUtils.fromJsonString(Long[].class, categoriesJson)));
                    break;
                case INTEGER:
                    categories = new IntegerChartCategories(DataUtils.fromJsonString(Integer[].class, categoriesJson));
                    break;
                case LONG:
                    categories = new LongChartCategories(DataUtils.fromJsonString(Long[].class, categoriesJson));
                    break;
                case STRING:
                    categories = new StringChartCategories(DataUtils.fromJsonString(String[].class, categoriesJson));
                    break;
                default:
                    break;
            }
            return this;
        }

        public Builder addSeries(ChartSeriesDataType type, String name, String seriesJson) throws UnifyException {
            switch (type) {
                case DOUBLE:
                    series.add(new DoubleChartSeries(name, DataUtils.fromJsonString(Double[].class, seriesJson)));
                    break;
                case INTEGER:
                    series.add(new IntegerChartSeries(name, DataUtils.fromJsonString(Integer[].class, seriesJson)));
                    break;
                case LONG:
                    series.add(new LongChartSeries(name, DataUtils.fromJsonString(Long[].class, seriesJson)));
                    break;
                default:
                    break;

            }
            return this;
        }

        public ChartData build() throws UnifyException {
            if (categories == null) {
                throw new RuntimeException("Chart categories is required.");
            }

            if (series.size() == 0) {
                throw new RuntimeException("At least one series is required.");
            }

            return new ChartData(categories, series);
        }
    }
}
