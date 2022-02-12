/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import com.flowcentraltech.flowcentral.application.web.lists.AbstractApplicationListCommand;
import com.flowcentraltech.flowcentral.workflow.business.WorkflowModuleService;
import com.flowcentraltech.flowcentral.workflow.entities.WfStep;
import com.flowcentraltech.flowcentral.workflow.entities.WfStepQuery;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.data.ListData;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.list.LongParam;
import com.tcdng.unify.core.util.DataUtils;

/**
 * Studio workflow step route to list command
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("studiowfsteproutetolist")
public class StudioWfStepRouteToListCommand extends AbstractApplicationListCommand<LongParam> {

    @Configurable
    private WorkflowModuleService workflowModuleService;

    public StudioWfStepRouteToListCommand() {
        super(LongParam.class);
    }

    public void setWorkflowModuleService(WorkflowModuleService workflowModuleService) {
        this.workflowModuleService = workflowModuleService;
    }

    @Override
    public List<? extends Listable> execute(Locale locale, LongParam longParam) throws UnifyException {
        if (longParam.isPresent()) {
            WfStep wfStep = workflowModuleService.findLeanWorkflowStepById(longParam.getValue());
            List<WfStep> stepList = workflowModuleService
                    .findWorkflowSteps((WfStepQuery) new WfStepQuery().workflowId(wfStep.getWorkflowId()).routableTo()
                            .idNot(longParam.getValue()).addSelect("name", "description"));
            if (!DataUtils.isBlank(stepList)) {
                List<ListData> list = new ArrayList<ListData>();
                for (WfStep rwfStep : stepList) {
                    list.add(new ListData(rwfStep.getName(), rwfStep.getDescription()));
                }

                return list;
            }
        }

        return Collections.emptyList();
    }

}
