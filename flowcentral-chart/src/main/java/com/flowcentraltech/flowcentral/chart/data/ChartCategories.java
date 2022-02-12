/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.chart.data;

import java.util.List;

import com.flowcentraltech.flowcentral.configuration.constants.ChartCategoryDataType;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.util.DataUtils;

/**
 * Chart categories object.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class ChartCategories<T> {

    private List<T> categories;

    public ChartCategories(List<T> categories) {
        this.categories = DataUtils.unmodifiableList(categories);
    }

    public ChartCategories(T[] categories) {
        this.categories = DataUtils.unmodifiableList(categories);
    }

    public abstract ChartCategoryDataType getCategoryType();

    public abstract Class<T> getDataType();

    public List<T> getCategories() {
        return categories;
    }

    public T[] categoriesToArray() {
        return DataUtils.toArray(getDataType(), categories);
    }

    public String categoriesToJsonArrayString() throws UnifyException {
        return DataUtils.asJsonArrayString(categoriesToArray());
    }

    public int size() {
        return categories.size();
    }
}
