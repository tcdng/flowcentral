/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.web.controllers;

import java.io.OutputStream;

import com.flowcentraltech.flowcentral.common.business.ReportProvider;
import com.flowcentraltech.flowcentral.common.data.ReportOptions;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.web.constant.Secured;
import com.tcdng.unify.web.ui.AbstractPageResourceController;

/**
 * Common resource controller for generating a report.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("/common/resource/report")
public class CommonReportResourceController extends AbstractPageResourceController {

    @Configurable
    private ReportProvider reportProvider;

    public CommonReportResourceController() {
        super(Secured.FALSE);
    }

    public void setReportProvider(ReportProvider reportProvider) {
        this.reportProvider = reportProvider;
    }

    @Override
    public void prepareExecution() throws UnifyException {
        setContentDisposition(getResourceName());
    }

    @Override
    public void execute(OutputStream outputStream) throws UnifyException {
        ReportOptions reportOptions = (ReportOptions) removeSessionAttribute(getResourceName());
        reportProvider.generateDynamicReport(reportOptions, outputStream);
    }
}
