/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.chart.data.provider;

import java.util.List;
import java.util.Locale;

import com.flowcentraltech.flowcentral.chart.constants.ChartModuleNameConstants;
import com.flowcentraltech.flowcentral.chart.data.AbstractChartDataProvider;
import com.flowcentraltech.flowcentral.chart.data.ChartData;
import com.flowcentraltech.flowcentral.chart.entities.ChartSnapshotQuery;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.Listable;

/**
 * Chart snapshot chart data provider.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component(name = ChartModuleNameConstants.CHARTSNAPSHOT_PROVIDER, description = "$m{chartsnapshot.provider}")
public class ChartSnapshotChartDataProvider extends AbstractChartDataProvider {

    @Override
    public ChartData provide(String rule) throws UnifyException {
        return getChartModuleService().getChartSnapshotDef(rule).getChartData();
    }

    @Override
    public List<? extends Listable> getRuleList(Locale locale) throws UnifyException {
        return getChartModuleService().findChartSnapshots((ChartSnapshotQuery) new ChartSnapshotQuery()
                .addSelect("name", "description").ignoreEmptyCriteria(true));
    }

}
