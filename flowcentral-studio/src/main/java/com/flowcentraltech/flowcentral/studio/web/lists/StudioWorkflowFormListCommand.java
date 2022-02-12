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

import com.flowcentraltech.flowcentral.application.entities.AppFormQuery;
import com.flowcentraltech.flowcentral.application.util.ApplicationNameUtils;
import com.flowcentraltech.flowcentral.application.web.lists.AbstractApplicationListCommand;
import com.flowcentraltech.flowcentral.workflow.business.WorkflowModuleService;
import com.flowcentraltech.flowcentral.workflow.entities.Workflow;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.list.LongParam;

/**
 * Studio workflow form list command
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("studioworkflowformlist")
public class StudioWorkflowFormListCommand extends AbstractApplicationListCommand<LongParam> {

    @Configurable
    private WorkflowModuleService workflowModuleService;

    public StudioWorkflowFormListCommand() {
        super(LongParam.class);
    }

    public void setWorkflowModuleService(WorkflowModuleService workflowModuleService) {
        this.workflowModuleService = workflowModuleService;
    }

    @Override
    public List<? extends Listable> execute(Locale locale, LongParam longParam) throws UnifyException {
        if (longParam.isPresent()) {
            Workflow workflow = workflowModuleService.findLeanWorkflowById(longParam.getValue());
            return ApplicationNameUtils.getListableList(
                    applicationService().findAppForms(new AppFormQuery().entity(workflow.getEntity())));
        }

        return Collections.emptyList();
    }

}
