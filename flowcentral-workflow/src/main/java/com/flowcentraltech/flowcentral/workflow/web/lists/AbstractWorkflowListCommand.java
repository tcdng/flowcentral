/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.workflow.web.lists;

import com.flowcentraltech.flowcentral.common.web.lists.AbstractFlowCentralListCommand;
import com.flowcentraltech.flowcentral.workflow.business.WorkflowModuleService;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.list.ListParam;

/**
 * Convenient abstract base class for workflow module list commands.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractWorkflowListCommand<T extends ListParam> extends AbstractFlowCentralListCommand<T> {

    @Configurable
    private WorkflowModuleService workflowModuleService;

    public AbstractWorkflowListCommand(Class<T> paramType) {
        super(paramType);
    }

    public void setWorkflowModuleService(WorkflowModuleService workflowModuleService) {
        this.workflowModuleService = workflowModuleService;
    }

    protected WorkflowModuleService getWorkflowModuleService() {
        return workflowModuleService;
    }

}
