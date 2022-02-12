/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.report.web.controllers;

import com.flowcentraltech.flowcentral.common.constants.FlowCentralSessionAttributeConstants;
import com.flowcentraltech.flowcentral.common.data.ReportListing;
import com.flowcentraltech.flowcentral.common.data.ReportOptions;
import com.flowcentraltech.flowcentral.report.business.ReportModuleService;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.annotation.UplBinding;
import com.tcdng.unify.web.annotation.Action;
import com.tcdng.unify.web.constant.ReadOnly;
import com.tcdng.unify.web.constant.ResetOnWrite;
import com.tcdng.unify.web.constant.Secured;
import com.tcdng.unify.web.ui.AbstractPageController;
import com.tcdng.unify.web.ui.widget.data.LinkGridInfo;

/**
 * Report listing controller.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("/report/reportlisting")
@UplBinding("web/report/upl/reportlisting.upl")
public class ReportListingController extends AbstractPageController<ReportListingPageBean> {

    @Configurable("/resource/configuredreport")
    private String reportResourcePath;

    @Configurable
    private ReportModuleService reportModuleService;

    public ReportListingController() {
        super(ReportListingPageBean.class, Secured.TRUE, ReadOnly.FALSE, ResetOnWrite.FALSE);
    }

    public void setReportResourcePath(String reportResourcePath) {
        this.reportResourcePath = reportResourcePath;
    }

    public void setReportModuleService(ReportModuleService reportModuleService) {
        this.reportModuleService = reportModuleService;
    }

    @Action
    public String prepareGenerateReport() throws UnifyException {
        String reportConfigName = getPageRequestContextUtil().getRequestTargetValue(String.class);
        ReportOptions reportOptions = reportModuleService.getReportOptionsForConfiguration(reportConfigName);
        reportOptions.setReportResourcePath(reportResourcePath);
        reportOptions.setUserInputOnly(true);
        setSessionAttribute(FlowCentralSessionAttributeConstants.REPORTOPTIONS, reportOptions);
        return "showapplicationreportoptions";
    }

    @Override
    protected void onInitPage() throws UnifyException {
        setPageValidationEnabled(true);
    }

    @Override
    protected void onOpenPage() throws UnifyException {
        // Load link grid information
        LinkGridInfo.Builder lb = LinkGridInfo.newBuilder();
        final String roleCode = !getUserToken().isReservedUser() ? getUserToken().getRoleCode() : null;
        String applicationName = null;
        for (ReportListing listing : reportModuleService.getRoleReportListing(roleCode)) {
            if (!listing.getApplicationName().equals(applicationName)) {
                applicationName = listing.getApplicationName();
                lb.addCategory(applicationName, listing.getApplicationDesc(),
                        "/report/reportlisting/prepareGenerateReport");
            }

            lb.addLink(applicationName, listing.getLongName(), listing.getDescription());
        }

        ReportListingPageBean pageBean = getPageBean();
        LinkGridInfo linkGridInfo = lb.build();
        pageBean.setLinkGridInfo(linkGridInfo);
    }

}
