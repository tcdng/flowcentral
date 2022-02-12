/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.chart.data;

import java.util.List;

import com.flowcentraltech.flowcentral.configuration.constants.ChartSeriesDataType;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.util.DataUtils;

/**
 * Chart series definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class ChartSeries<T extends Number> {

    private String name;

    private List<T> data;

    protected ChartSeries(String name, List<T> data) {
        this.name = name;
        this.data = DataUtils.unmodifiableList(data);
    }

    protected ChartSeries(String name, T[] data) {
        this.name = name;
        this.data = DataUtils.unmodifiableList(data);
    }

    public abstract ChartSeriesDataType getSeriesType();

    public abstract Class<T> getDataType();

    public String getName() {
        return name;
    }

    public List<T> getData() {
        return data;
    }

    public T[] dataToArray() {
        return DataUtils.toArray(getDataType(), data);
    }

    public String dataToJsonArrayString() throws UnifyException {
        return DataUtils.asJsonArrayString(dataToArray());
    }

    public int size() {
        return data.size();
    }
}
