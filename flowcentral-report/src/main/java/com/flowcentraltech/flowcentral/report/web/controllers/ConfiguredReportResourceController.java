/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.report.web.controllers;

import java.io.OutputStream;

import com.flowcentraltech.flowcentral.common.data.ReportOptions;
import com.flowcentraltech.flowcentral.report.business.ReportModuleService;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.web.constant.Secured;
import com.tcdng.unify.web.ui.AbstractPageResourceController;

/**
 * Backing resource controller for retrieving a generated configured report
 * report.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("/resource/configuredreport")
public class ConfiguredReportResourceController extends AbstractPageResourceController {

    @Configurable
    private ReportModuleService reportModuleService;

    public ConfiguredReportResourceController() {
        super(Secured.TRUE);
    }

    public void setReportModuleService(ReportModuleService reportModuleService) {
        this.reportModuleService = reportModuleService;
    }

    @Override
    public void prepareExecution() throws UnifyException {
        setContentDisposition(getResourceName());
    }

    @Override
    public void execute(OutputStream outputStream) throws UnifyException {
        ReportOptions reportOptions = (ReportOptions) removeSessionAttribute(getResourceName());
        reportModuleService.populateExtraConfigurationReportOptions(reportOptions);
        reportModuleService.generateDynamicReport(reportOptions, outputStream);
    }
}
