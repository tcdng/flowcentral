/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.workflow.business;

import java.util.List;

import com.flowcentraltech.flowcentral.application.business.ApplicationWorkItemUtilities;
import com.flowcentraltech.flowcentral.common.business.FlowCentralService;
import com.flowcentraltech.flowcentral.common.entities.WorkEntity;
import com.flowcentraltech.flowcentral.workflow.data.WfChannelDef;
import com.flowcentraltech.flowcentral.workflow.data.WfDef;
import com.flowcentraltech.flowcentral.workflow.data.WfWizardDef;
import com.flowcentraltech.flowcentral.workflow.entities.WfChannel;
import com.flowcentraltech.flowcentral.workflow.entities.WfChannelQuery;
import com.flowcentraltech.flowcentral.workflow.entities.WfStep;
import com.flowcentraltech.flowcentral.workflow.entities.WfStepQuery;
import com.flowcentraltech.flowcentral.workflow.entities.WfWizard;
import com.flowcentraltech.flowcentral.workflow.entities.Workflow;
import com.flowcentraltech.flowcentral.workflow.entities.WorkflowFilter;
import com.flowcentraltech.flowcentral.workflow.entities.WorkflowFilterQuery;
import com.flowcentraltech.flowcentral.workflow.entities.WorkflowQuery;
import com.tcdng.unify.core.UnifyException;

/**
 * Workflow business service.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface WorkflowModuleService extends FlowCentralService, ApplicationWorkItemUtilities {

    /**
     * Submit entity instance to workflow by workflow name.
     * 
     * @param workflowName
     *                     the workflow long name
     * @param inst
     *                     the entity instance to submit to workflow
     * @throws UnifyException
     *                        if workflow is unknown. If instance type does not
     *                        match workflow entity definition. If an error occurs
     */
    void submitToWorkflowByName(String workflowName, WorkEntity inst) throws UnifyException;

    /**
     * Submit work entity instance to workflow by channel name.
     * 
     * @param workflowChannelName
     *                            the workflow channel name
     * @param inst
     *                            the entity instance to submit to workflow
     * @return the result code
     * @throws UnifyException
     *                        if workflow channel is unknown. If instance type does
     *                        not match workflow entity definition. If an error
     *                        occurs
     */
    int submitToWorkflowByChannel(String wfDocChannelName, WorkEntity inst) throws UnifyException;

    /**
     * Submit work entity instances to workflow by channel name.
     * 
     * @param workflowChannelName
     *                            the workflow channel name
     * @param entityList
     *                            the entity instances to submit to workflow
     * @return the result code
     * @throws UnifyException
     *                        if workflow channel is unknown. If instances type does
     *                        not match workflow entity definition. If an error
     *                        occurs
     */
    int submitToWorkflowByChannel(String wfDocChannelName, List<WorkEntity> entityList) throws UnifyException;

    /**
     * Submit work entity instances to workflow by channel name.
     * 
     * @param workflowChannelName
     *                            the workflow channel name
     * @param branchCode
     *                            optional branch code
     * @param departmentCode
     *                            optional department code
     * @param entityList
     *                            the entity instances to submit to workflow
     * @return the result code
     * @throws UnifyException
     *                        if workflow channel is unknown. If instances type does
     *                        not match workflow entity definition. If an error
     *                        occurs
     */
    int submitToWorkflowByChannel(String wfDocChannelName, String branchCode, String departmentCode,
            List<WorkEntity> entityList) throws UnifyException;

    /**
     * Finds workflow by ID.
     * 
     * @param workflowId
     *                the workflow ID
     * @return the workflow
     * @throws UnifyException
     *                        if workflow with ID is not found. If an error occurs
     */
    Workflow findWorkflow(Long workflowId) throws UnifyException;

    /**
     * Finds workflow ID list for application.
     * 
     * @param applicationName
     *                        the application name
     * @return list of application workflow IDs
     * @throws UnifyException
     *                        if an error occurs
     */
    List<Long> findWorkflowIdList(String applicationName) throws UnifyException;

    /**
     * Finds workflow channel by ID.
     * 
     * @param wfChannelId
     *                the workflow channel ID
     * @return the workflow channel
     * @throws UnifyException
     *                        if workflow channel with ID is not found. If an error occurs
     */
    WfChannel findWfChannel(Long wfChannelId) throws UnifyException;

    /**
     * Finds workflow channel ID list for application.
     * 
     * @param applicationName
     *                        the application name
     * @return list of application workflow channel IDs
     * @throws UnifyException
     *                        if an error occurs
     */
    List<Long> findWfChannelIdList(String applicationName) throws UnifyException;

    /**
     * Finds workflow wizard by ID.
     * 
     * @param wfWizardId
     *                the workflow wizard ID
     * @return the workflow wizard
     * @throws UnifyException
     *                        if workflow wizard with ID is not found. If an error occurs
     */
    WfWizard findWfWizard(Long wfWizardId) throws UnifyException;

    /**
     * Finds workflow wizard ID list for application.
     * 
     * @param applicationName
     *                        the application name
     * @return list of application workflow wizard IDs
     * @throws UnifyException
     *                        if an error occurs
     */
    List<Long> findWfWizardIdList(String applicationName) throws UnifyException;

    /**
     * Finds workflow by ID.
     * 
     * @param workflowId
     *                   the workflow ID
     * @return the workflow
     * @throws UnifyException
     *                        if an error occurs
     */
    Workflow findLeanWorkflowById(Long workflowId) throws UnifyException;

    /**
     * Finds workflows by criteria.
     * 
     * @param query
     *              the query
     * @return list of workflows
     * @throws UnifyException
     *                        if an error occurs
     */
    List<Workflow> findWorkflows(WorkflowQuery query) throws UnifyException;

    /**
     * Finds workflow filters by query.
     * 
     * @param query
     *              the query to use
     * @return list of workflow filters
     * @throws UnifyException
     *                        if an error occurs
     */
    List<WorkflowFilter> findWorkflowFilters(WorkflowFilterQuery query) throws UnifyException;
    
    /**
     * Finds workflow step by ID.
     * 
     * @param wfStepId
     *                 the workflow step ID
     * @return the workflow step
     * @throws UnifyException
     *                        if an error occurs
     */
    WfStep findLeanWorkflowStepById(Long wfStepId) throws UnifyException;

    /**
     * Finds workflow steps by query.
     * 
     * @param query
     *              the workflow step query
     * @return the workflow steps
     * @throws UnifyException
     *                        if an error occurs
     */
    List<WfStep> findWorkflowSteps(WfStepQuery query) throws UnifyException;

    /**
     * Gets an application workflow definition.
     * 
     * @param workflowName
     *                     the workflow long name
     * @return the workflow definition
     * @throws UnifyException
     *                        if an error occurs
     */
    WfDef getWfDef(String workflowName) throws UnifyException;

    /**
     * Gets the work entity instance for a workflow item
     * 
     * @param wfItemId
     *                 the workflow item ID
     * @return the workflow item work entity instance
     * @throws UnifyException
     *                        if an error occurs
     */
    WorkEntity getWfItemWorkEntity(Long wfItemId) throws UnifyException;

    /**
     * Applies user action on workflow item.
     * 
     * @param wfEntityInst
     *                     the workflow item work entity instance
     * @param wfItemId
     *                     the workflow item ID
     * @param stepName
     *                     the workflow step name
     * @param userAction
     *                     the user action to apply
     * @return true if successfully applied otherwise false when workflow item is
     *         not in step
     * @throws UnifyException
     *                        if an error occurs
     */
    boolean applyUserAction(WorkEntity wfEntityInst, Long wfItemId, String stepName, String userAction)
            throws UnifyException;

    /**
     * Gets application workflow wizard definition.
     * 
     * @param wfWizardName
     *                     the workflow wizard long name
     * @return the workflow wizard definition
     * @throws UnifyException
     *                        if an error occurs
     */
    WfWizardDef getWfWizardDef(String wfWizardName) throws UnifyException;

    /**
     * Graduates workflow wizard item from DRAFT to ACTUAL.
     * 
     * @param wfWizardName
     *                     the workflow wizard name
     * @param workEntityId
     *                     the work entity ID
     * @throws UnifyException
     *                        if an error occurs
     */
    void graduateWfWizardItem(String wfWizardName, Long workEntityId) throws UnifyException;
    
    /**
     * Creates a workflow channel.
     * 
     * @param wfChannel
     *                  the workflow channel to create.
     * @return the ID of the created workflow channel
     * @throws UnifyException
     *                        if an error occurs
     */
    Long createWorkflowChannel(WfChannel wfChannel) throws UnifyException;

    /**
     * Finds workflow channels by criteria.
     * 
     * @param query
     *              the query
     * @return list of workflow channels
     * @throws UnifyException
     *                        if an error occurs
     */
    List<WfChannel> findWorkflowChannels(WfChannelQuery query) throws UnifyException;
    
    /**
     * Gets application workflow channel.
     * 
     * @param workflowChannelName
     *                            the workflow channel name
     * @return the workflow channel definition
     * @throws UnifyException
     *                        if an error occurs
     */
    WfChannelDef getWfChannelDef(String workflowChannelName) throws UnifyException;
}
