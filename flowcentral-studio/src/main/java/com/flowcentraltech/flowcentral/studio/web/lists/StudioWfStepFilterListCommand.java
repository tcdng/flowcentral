/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.lists;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

import com.flowcentraltech.flowcentral.application.web.lists.AbstractApplicationListCommand;
import com.flowcentraltech.flowcentral.workflow.business.WorkflowModuleService;
import com.flowcentraltech.flowcentral.workflow.entities.WfStep;
import com.flowcentraltech.flowcentral.workflow.entities.WorkflowFilterQuery;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.list.LongParam;

/**
 * Studio workflow step filter list command
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("studiowfstepfilterlist")
public class StudioWfStepFilterListCommand extends AbstractApplicationListCommand<LongParam> {

    @Configurable
    private WorkflowModuleService workflowModuleService;

    public StudioWfStepFilterListCommand() {
        super(LongParam.class);
    }

    public void setWorkflowModuleService(WorkflowModuleService workflowModuleService) {
        this.workflowModuleService = workflowModuleService;
    }

    @Override
    public List<? extends Listable> execute(Locale locale, LongParam longParam) throws UnifyException {
        if (longParam.isPresent()) {
            WfStep wfStep = workflowModuleService.findLeanWorkflowStepById(longParam.getValue());
            return workflowModuleService.findWorkflowFilters((WorkflowFilterQuery) new WorkflowFilterQuery()
                    .workflowId(wfStep.getWorkflowId()).addSelect("name", "description"));
        }

        return Collections.emptyList();
    }

}
