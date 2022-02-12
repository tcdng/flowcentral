/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.data;

import com.flowcentraltech.flowcentral.configuration.xml.ReportConfig;

/**
 * Report installation configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ReportInstall {

    private ReportConfig reportConfig;

    public ReportInstall(ReportConfig reportConfig) {
        this.reportConfig = reportConfig;
    }

    public ReportConfig getReportConfig() {
        return reportConfig;
    }

}
