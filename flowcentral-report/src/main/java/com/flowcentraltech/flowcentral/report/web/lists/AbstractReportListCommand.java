/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.report.web.lists;

import com.flowcentraltech.flowcentral.common.web.lists.AbstractFlowCentralListCommand;
import com.flowcentraltech.flowcentral.report.business.ReportModuleService;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.list.ListParam;

/**
 * Convenient abstract base class for report list commands.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractReportListCommand<T extends ListParam> extends AbstractFlowCentralListCommand<T> {

    @Configurable
    private ReportModuleService reportModuleService;

    public AbstractReportListCommand(Class<T> paramType) {
        super(paramType);
    }

    public void setReportModuleService(ReportModuleService reportModuleService) {
        this.reportModuleService = reportModuleService;
    }

    protected ReportModuleService getReportModuleService() {
        return reportModuleService;
    }

}
