/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Application dashboard configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppDashboardConfig extends BaseNameConfig {

    private int sections;

    private List<DashboardTileConfig> tileList;

    public int getSections() {
        return sections;
    }

    @XmlAttribute(required = true)
    public void setSections(int sections) {
        this.sections = sections;
    }

    public List<DashboardTileConfig> getTileList() {
        return tileList;
    }

    @XmlElement(name = "dashboard-tile", required = true)
    public void setTileList(List<DashboardTileConfig> tileList) {
        this.tileList = tileList;
    }

}
