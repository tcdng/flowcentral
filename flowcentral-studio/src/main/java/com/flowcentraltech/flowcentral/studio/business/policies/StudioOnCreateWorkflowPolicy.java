/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.business.policies;

import java.util.ArrayList;
import java.util.List;

import com.flowcentraltech.flowcentral.application.util.ApplicationNameUtils;
import com.flowcentraltech.flowcentral.common.business.policies.EntityActionContext;
import com.flowcentraltech.flowcentral.common.business.policies.EntityActionResult;
import com.flowcentraltech.flowcentral.configuration.constants.ChannelDirectionType;
import com.flowcentraltech.flowcentral.configuration.constants.WorkflowStepPriority;
import com.flowcentraltech.flowcentral.configuration.constants.WorkflowStepType;
import com.flowcentraltech.flowcentral.studio.constants.StudioSessionAttributeConstants;
import com.flowcentraltech.flowcentral.workflow.business.WorkflowModuleService;
import com.flowcentraltech.flowcentral.workflow.constants.WfChannelStatus;
import com.flowcentraltech.flowcentral.workflow.entities.WfChannel;
import com.flowcentraltech.flowcentral.workflow.entities.WfStep;
import com.flowcentraltech.flowcentral.workflow.entities.Workflow;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.util.NameUtils;

/**
 * Studio on create workflow policy.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("studiooncreateworkflow-policy")
public class StudioOnCreateWorkflowPolicy extends StudioOnCreateComponentPolicy {

    @Configurable
    private WorkflowModuleService workflowModuleService;
    
    public void setWorkflowModuleService(WorkflowModuleService workflowModuleService) {
        this.workflowModuleService = workflowModuleService;
    }

    @Override
    protected void doExecutePreAction(EntityActionContext ctx) throws UnifyException {
        super.doExecutePreAction(ctx);
        Workflow workflow = (Workflow) ctx.getInst();
        List<WfStep> stepList = new ArrayList<WfStep>();

        // Add start step
        WfStep wfStep = new WfStep();
        wfStep.setType(WorkflowStepType.START);
        wfStep.setPriority(WorkflowStepPriority.NORMAL);
        wfStep.setName("start");
        wfStep.setDescription("Start");
        wfStep.setLabel("Start");
        wfStep.setNextStepName("end");
        stepList.add(wfStep);

        // Add end step
        wfStep = new WfStep();
        wfStep.setType(WorkflowStepType.END);
        wfStep.setPriority(WorkflowStepPriority.NORMAL);
        wfStep.setName("end");
        wfStep.setDescription("End");
        wfStep.setLabel("End");
        stepList.add(wfStep);

        // Add error step
        wfStep = new WfStep();
        wfStep.setType(WorkflowStepType.ERROR);
        wfStep.setPriority(WorkflowStepPriority.NORMAL);
        wfStep.setName("error");
        wfStep.setDescription("Error");
        wfStep.setLabel("Error");
        stepList.add(wfStep);

        workflow.setStepList(stepList);
    }

    @Override
    protected EntityActionResult doExecutePostAction(EntityActionContext ctx) throws UnifyException {
        EntityActionResult result = super.doExecutePostAction(ctx);
        final String applicationName = (String) getSessionAttribute(
                StudioSessionAttributeConstants.CURRENT_APPLICATION_NAME);
        final Long applicationId = (Long) getSessionAttribute(StudioSessionAttributeConstants.CURRENT_APPLICATION_ID);
        Workflow workflow = (Workflow) ctx.getInst();
        WfChannel wfChannel = new WfChannel();
        wfChannel.setApplicationId(applicationId);
        wfChannel.setName(workflow.getName());
        final String description = NameUtils.describeName(workflow.getName()) + " Channel";
        wfChannel.setDescription(description);
        wfChannel.setLabel(description);
        wfChannel.setEntity(workflow.getEntity());
        wfChannel.setDestination(ApplicationNameUtils.getApplicationEntityLongName(applicationName, workflow.getName()));
        wfChannel.setDirection(ChannelDirectionType.INWARD);
        wfChannel.setStatus(WfChannelStatus.OPEN);
        
        workflowModuleService.createWorkflowChannel(wfChannel);
        return result;
    }

}