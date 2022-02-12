/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.common.web.panels;

import com.flowcentraltech.flowcentral.common.data.ReportOptions;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.UplBinding;
import com.tcdng.unify.core.util.StringUtils;
import com.tcdng.unify.web.annotation.Action;

/**
 * Basic panel for presenting and capturing report options.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-reportrunnerpanel")
@UplBinding("web/common/upl/reportrunnerpanel.upl")
public class ReportRunnerPanel extends BaseDialogPanel {

    @Action
    @Override
    public void switchState() throws UnifyException {
        super.switchState();
        ReportOptions reportOptions = (ReportOptions) getValue();
        setVisible("runnerTitlePanel", StringUtils.isNotBlank(reportOptions.getReportDescription()));
        setVisible("rptColumnOptionsPanel", !reportOptions.isUserInputOnly() && reportOptions.isWithColumnOptions());
        setVisible("rptParamsPanel", reportOptions.isWithUserInput());
    }

}
