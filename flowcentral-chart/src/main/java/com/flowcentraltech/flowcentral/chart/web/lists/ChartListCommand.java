/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.chart.web.lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.flowcentraltech.flowcentral.application.util.ApplicationNameUtils;
import com.flowcentraltech.flowcentral.chart.business.ChartModuleService;
import com.flowcentraltech.flowcentral.chart.entities.Chart;
import com.flowcentraltech.flowcentral.chart.entities.ChartQuery;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.data.ListData;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.list.AbstractZeroParamsListCommand;
import com.tcdng.unify.core.list.ZeroParams;

/**
 * Chart list command.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("chartlist")
public class ChartListCommand extends AbstractZeroParamsListCommand {

    @Configurable
    private ChartModuleService chartModuleService;

    public void setChartModuleService(ChartModuleService chartModuleService) {
        this.chartModuleService = chartModuleService;
    }

    @Override
    public List<? extends Listable> execute(Locale locale, ZeroParams param) throws UnifyException {
        List<ListData> resultList = new ArrayList<ListData>();
        for (Chart chart : chartModuleService.findCharts((ChartQuery) new ChartQuery()
                .addSelect("applicationName", "name", "description").ignoreEmptyCriteria(true))) {
            resultList.add(new ListData(
                    ApplicationNameUtils.getApplicationEntityLongName(chart.getApplicationName(), chart.getName()),
                    chart.getDescription()));
        }

        return resultList;
    }

}
