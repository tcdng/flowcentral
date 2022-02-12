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
 * Application reports configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppReportsConfig {

    private List<AppReportConfig> reportList;

    public List<AppReportConfig> getReportList() {
        return reportList;
    }

    @XmlElement(name = "report", required = true)
    public void setReportList(List<AppReportConfig> reportList) {
        this.reportList = reportList;
    }

}
