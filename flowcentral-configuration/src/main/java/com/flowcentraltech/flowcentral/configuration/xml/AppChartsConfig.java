/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.configuration.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * Charts configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppChartsConfig {

    private List<AppChartConfig> chartList;

    public List<AppChartConfig> getChartList() {
        return chartList;
    }

    @XmlElement(name = "chart")
    public void setChartList(List<AppChartConfig> chartList) {
        this.chartList = chartList;
    }
}
