/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.chart.data;

import com.flowcentraltech.flowcentral.chart.business.ChartModuleService;
import com.tcdng.unify.core.AbstractUnifyComponent;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Configurable;

/**
 * Convenient abstract base class for chart data providers.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractChartDataProvider extends AbstractUnifyComponent implements ChartDataProvider {

    @Configurable
    private ChartModuleService chartModuleService;

    public void setChartModuleService(ChartModuleService chartModuleService) {
        this.chartModuleService = chartModuleService;
    }

    @Override
    protected void onInitialize() throws UnifyException {

    }

    @Override
    protected void onTerminate() throws UnifyException {

    }

    protected ChartModuleService getChartModuleService() {
        return chartModuleService;
    }

}
