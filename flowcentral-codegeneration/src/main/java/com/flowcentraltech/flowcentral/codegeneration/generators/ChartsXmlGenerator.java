/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.codegeneration.generators;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipOutputStream;

import com.flowcentraltech.flowcentral.chart.business.ChartModuleService;
import com.flowcentraltech.flowcentral.chart.entities.Chart;
import com.flowcentraltech.flowcentral.configuration.xml.AppChartConfig;
import com.flowcentraltech.flowcentral.configuration.xml.AppChartsConfig;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.util.DataUtils;

/**
 * Charts XML Generator.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("charts-xml-generator")
public class ChartsXmlGenerator extends AbstractStaticArtifactGenerator {

    @Configurable
    private ChartModuleService chartModuleService;

    public void setChartModuleService(ChartModuleService chartModuleService) {
        this.chartModuleService = chartModuleService;
    }

    @Override
    protected void doGenerate(ExtensionModuleStaticFileBuilderContext ctx, String applicationName, ZipOutputStream out)
            throws UnifyException {
        List<Long> chartIdList = chartModuleService.findChartIdList(applicationName);
        if (!DataUtils.isBlank(chartIdList)) {
            final String lowerCaseApplicationName = applicationName.toLowerCase();

            AppChartsConfig appChartsConfig = new AppChartsConfig();
            List<AppChartConfig> chartConfigList = new ArrayList<AppChartConfig>();
            for (Long chartId : chartIdList) {
                AppChartConfig appChartConfig = new AppChartConfig();
                Chart chart = chartModuleService.findChart(chartId);
                String descKey = getDescriptionKey(lowerCaseApplicationName, "chart", chart.getName());
                String titleKey = descKey + ".title";
                String subTitleKey = descKey + ".subtitle";
                ctx.addMessage(StaticMessageCategoryType.CHART, descKey, chart.getDescription());
                ctx.addMessage(StaticMessageCategoryType.CHART, titleKey, chart.getTitle());
                ctx.addMessage(StaticMessageCategoryType.CHART, subTitleKey, chart.getSubTitle());

                appChartConfig.setType(chart.getType());
                appChartConfig.setPaletteType(chart.getPaletteType());
                appChartConfig.setName(chart.getName());
                appChartConfig.setDescription("$m{" + descKey + "}");
                appChartConfig.setTitle("$m{" + titleKey + "}");
                appChartConfig.setSubTitle("$m{" + subTitleKey + "}");
                appChartConfig.setWidth(chart.getWidth());
                appChartConfig.setHeight(chart.getHeight());
                appChartConfig.setProvider(chart.getProvider());
                appChartConfig.setRule(chart.getRule());
                appChartConfig.setShowGrid(chart.isShowGrid());
                appChartConfig.setShowDataLabels(chart.isShowDataLabels());
                appChartConfig.setStacked(chart.isStacked());
                appChartConfig.setSmooth(chart.isSmooth());

                chartConfigList.add(appChartConfig);
            }

            appChartsConfig.setChartList(chartConfigList);
            ctx.setChartsConfig(appChartsConfig);
        }

    }

}
