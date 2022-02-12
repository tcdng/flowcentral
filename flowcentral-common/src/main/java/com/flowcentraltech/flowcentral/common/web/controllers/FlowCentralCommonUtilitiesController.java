/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.web.controllers;

import com.flowcentraltech.flowcentral.common.business.CollaborationProvider;
import com.flowcentraltech.flowcentral.common.constants.CommonModuleAuditConstants;
import com.flowcentraltech.flowcentral.common.constants.FlowCentralRequestAttributeConstants;
import com.flowcentraltech.flowcentral.common.constants.FlowCentralSessionAttributeConstants;
import com.flowcentraltech.flowcentral.common.data.CollaborationLockedResourceInfo;
import com.flowcentraltech.flowcentral.common.data.ReportOptions;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.annotation.UplBinding;
import com.tcdng.unify.web.annotation.Action;
import com.tcdng.unify.web.annotation.ResultMapping;
import com.tcdng.unify.web.annotation.ResultMappings;
import com.tcdng.unify.web.ui.AbstractCommonUtilitiesPageController;

/**
 * Flow central common utilities controller.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("/application/commonutilities")
@UplBinding("web/common/upl/flowcentralcommonutilities.upl")
@ResultMappings({
        @ResultMapping(name = "showapplicationreportoptions",
                response = { "!showpopupresponse popup:$s{reportRunnerPopup}" }),
        @ResultMapping(name = "viewreport",
                response = { "!refreshpanelresponse panels:$l{reportRunnerPopup}", "!commonreportresponse" }),
        @ResultMapping(name = "showlockedresource", response = { "!showpopupresponse popup:$s{lockedResourcePopup}" }),
        @ResultMapping(name = "grablocksuccess", response = { "!hidepopupresponse" }) })
public class FlowCentralCommonUtilitiesController
        extends AbstractCommonUtilitiesPageController<FlowCentralCommonUtilitiesPageBean> {

    @Configurable
    private CollaborationProvider collaborationProvider;
    
    public FlowCentralCommonUtilitiesController() {
        super(FlowCentralCommonUtilitiesPageBean.class);
    }

    public void setCollaborationProvider(CollaborationProvider collaborationProvider) {
        this.collaborationProvider = collaborationProvider;
    }

    @Action
    public String showLockedResource() throws UnifyException {
        return "showlockedresource";
    }

    @Action
    public String grabResourceLock() throws UnifyException {
        if (collaborationProvider != null) {
            CollaborationLockedResourceInfo info = (CollaborationLockedResourceInfo) getSessionAttribute(
                    FlowCentralSessionAttributeConstants.LOCKED_RESOURCEOPTIONS);
            collaborationProvider.grabLock(info.getType(), info.getResourceName(), getUserToken().getUserLoginId());
        }

        return "grablocksuccess";
    }

    @Action
    public String generateReport() throws UnifyException {
        ReportOptions reportOptions = (ReportOptions) getSessionAttribute(
                FlowCentralSessionAttributeConstants.REPORTOPTIONS);
        setRequestAttribute(FlowCentralRequestAttributeConstants.REPORTOPTIONS, reportOptions);
        getEventLogger().logUserEvent(CommonModuleAuditConstants.GENERATE_REPORT, reportOptions.getTitle());
        return "viewreport";
    }

    @Action
    public String closeReport() throws UnifyException {
        removeSessionAttribute(FlowCentralSessionAttributeConstants.REPORTOPTIONS);
        return hidePopup();
    }

}
