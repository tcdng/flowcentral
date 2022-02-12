/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.chart.web.writers;

import com.flowcentraltech.flowcentral.chart.business.ChartModuleService;
import com.flowcentraltech.flowcentral.chart.data.ChartData;
import com.flowcentraltech.flowcentral.chart.data.ChartDataProvider;
import com.flowcentraltech.flowcentral.chart.data.ChartDef;
import com.flowcentraltech.flowcentral.chart.util.ChartUtils;
import com.flowcentraltech.flowcentral.chart.web.widgets.ChartWidget;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.annotation.Writes;
import com.tcdng.unify.web.ui.widget.ResponseWriter;
import com.tcdng.unify.web.ui.widget.Widget;
import com.tcdng.unify.web.ui.widget.writer.AbstractWidgetWriter;

/**
 * Chart writer.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Writes(ChartWidget.class)
@Component("fc-chart-writer")
public class ChartWriter extends AbstractWidgetWriter {

    @Configurable
    private ChartModuleService chartModuleService;

    public void setChartModuleService(ChartModuleService chartModuleService) {
        this.chartModuleService = chartModuleService;
    }

    @Override
    protected void doWriteStructureAndContent(ResponseWriter writer, Widget widget) throws UnifyException {
        ChartWidget chartWidget = (ChartWidget) widget;
        writer.write("<div");
        writeTagAttributes(writer, chartWidget);
        writer.write(">");
        writer.write("</div>");
    }

    @Override
    protected void doWriteBehavior(ResponseWriter writer, Widget widget) throws UnifyException {
        super.doWriteBehavior(writer, widget);

        ChartWidget chartWidget = (ChartWidget) widget;
        final String chartLongName = chartWidget.getValue(String.class);
        ChartDef chartDef = chartModuleService.getChartDef(chartLongName);
        ChartData chartData = ((ChartDataProvider) getComponent(chartDef.getProvider())).provide(chartDef.getRule());
        writer.beginFunction("fux.rigChart");
        writer.writeParam("pId", chartWidget.getId());
        writer.writeParam("pOptions", ChartUtils.getOptionsJsonWriter(chartDef, chartData, chartWidget.isSparkLine()));
        writer.endFunction();
    }
}
