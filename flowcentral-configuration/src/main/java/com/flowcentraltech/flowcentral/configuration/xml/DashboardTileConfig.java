/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.flowcentraltech.flowcentral.configuration.constants.DashboardTileType;
import com.flowcentraltech.flowcentral.configuration.xml.adapter.DashboardTileTypeXmlAdapter;

/**
 * Dashboard tile configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class DashboardTileConfig extends BaseNameConfig {

    private DashboardTileType type;

    private String chart;

    private int section;

    private int index;

    public DashboardTileConfig() {
        type = DashboardTileType.SIMPLE;
    }

    public DashboardTileType getType() {
        return type;
    }

    @XmlJavaTypeAdapter(DashboardTileTypeXmlAdapter.class)
    @XmlAttribute(required = true)
    public void setType(DashboardTileType type) {
        this.type = type;
    }

    public String getChart() {
        return chart;
    }

    @XmlAttribute(required = true)
    public void setChart(String chart) {
        this.chart = chart;
    }

    public int getSection() {
        return section;
    }

    @XmlAttribute(required = true)
    public void setSection(int section) {
        this.section = section;
    }

    public int getIndex() {
        return index;
    }

    @XmlAttribute
    public void setIndex(int index) {
        this.index = index;
    }

}
