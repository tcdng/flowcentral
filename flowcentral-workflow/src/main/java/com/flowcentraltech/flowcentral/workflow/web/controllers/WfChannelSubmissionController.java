/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.workflow.web.controllers;

import java.util.ArrayList;
import java.util.List;

import com.flowcentraltech.flowcentral.application.business.ApplicationModuleService;
import com.flowcentraltech.flowcentral.application.data.EntityClassDef;
import com.flowcentraltech.flowcentral.common.entities.WorkEntity;
import com.flowcentraltech.flowcentral.workflow.business.WorkflowModuleService;
import com.flowcentraltech.flowcentral.workflow.constants.WfChannelErrorConstants;
import com.flowcentraltech.flowcentral.workflow.data.WfChannelDef;
import com.flowcentraltech.flowcentral.workflow.web.data.WfChannelSubmission;
import com.flowcentraltech.flowcentral.workflow.web.data.WfChannelSubmissionResult;
import com.tcdng.unify.core.UnifyCoreErrorConstants;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.web.AbstractPlainJsonController;

/**
 * Workflow channel submission controller.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("/workflowchannel/submit")
public class WfChannelSubmissionController extends AbstractPlainJsonController {

    @Configurable
    private ApplicationModuleService applicationModuleService;

    @Configurable
    private WorkflowModuleService workflowModuleService;

    public void setApplicationModuleService(ApplicationModuleService applicationModuleService) {
        this.applicationModuleService = applicationModuleService;
    }

    public void setWorkflowModuleService(WorkflowModuleService workflowModuleService) {
        this.workflowModuleService = workflowModuleService;
    }

    @Override
    protected Object doExecute(String jsonRequest) throws UnifyException {
        int errorCode = WfChannelErrorConstants.NO_ERROR;
        String errorMsg = null;
        try {
            WfChannelSubmission wfChannelSubmission = getObjectFromRequestJson(WfChannelSubmission.class, jsonRequest);
            WfChannelDef wfChannelDef = workflowModuleService.getWfChannelDef(wfChannelSubmission.getChannel());
            EntityClassDef entityClassDef = applicationModuleService.getEntityClassDef(wfChannelDef.getEntity());
            List<WorkEntity> workEntityList = new ArrayList<WorkEntity>();
            for (String document : wfChannelSubmission.getDocuments()) {
                WorkEntity workEntity = (WorkEntity) getObjectFromRequestJson(entityClassDef.getEntityClass(),
                        document);
                applicationModuleService.resolveEntityReferences(workEntity, wfChannelDef.getEntity());
                workEntityList.add(workEntity);
            }

            workflowModuleService.submitToWorkflowByChannel(wfChannelSubmission.getChannel(),
                    wfChannelSubmission.getBranchCode(), wfChannelSubmission.getDepartmentCode(), workEntityList);
        } catch (UnifyException e) {
            errorCode = WfChannelErrorConstants.SYSTEM_EXCEPTION;
            errorMsg = getSessionMessage(e.getErrorCode(), e.getErrorParams());
            logError(e);
        } catch (Exception e) {
            errorCode = WfChannelErrorConstants.SYSTEM_EXCEPTION;
            errorMsg = getSessionMessage(UnifyCoreErrorConstants.COMPONENT_OPERATION_ERROR, getName(), e.getMessage());
            logError(e);
        }

        return new WfChannelSubmissionResult(errorCode, errorMsg);
    }

}
