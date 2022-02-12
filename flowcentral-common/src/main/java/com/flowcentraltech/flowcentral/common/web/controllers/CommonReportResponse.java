/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.web.controllers;

import com.flowcentraltech.flowcentral.common.constants.FlowCentralRequestAttributeConstants;
import com.flowcentraltech.flowcentral.common.data.ReportOptions;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.constant.MimeType;
import com.tcdng.unify.core.report.ReportFormat;
import com.tcdng.unify.web.ui.AbstractOpenWindowPageControllerResponse;

/**
 * Used for preparing the generation of a report and the presentation of the
 * report in a window.
 * <p>
 * Expects the report options be stored in the request scope using the key
 * {@link FlowCentralRequestAttributeConstants#REPORTOPTIONS}.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("commonreportresponse")
public class CommonReportResponse extends AbstractOpenWindowPageControllerResponse {

    @Override
    protected WindowResourceInfo prepareWindowResource() throws UnifyException {
        ReportOptions reportOptions = (ReportOptions) getRequestAttribute(
                FlowCentralRequestAttributeConstants.REPORTOPTIONS);
        String reportFormat = reportOptions.getReportFormat();
        String resourceName = getTimestampedResourceName(reportOptions.getTitle())
                + ReportFormat.fromName(reportOptions.getReportFormat()).fileExt();
        boolean download = reportOptions.isDownload();

        MimeType mimeType = MimeType.APPLICATION_OCTETSTREAM;
        if (!download) {
            mimeType = ReportFormat.fromName(reportFormat).mimeType();
        }

        return new WindowResourceInfo(reportOptions, reportOptions.getReportResourcePath(), resourceName,
                mimeType.template(), download);
    }
}
