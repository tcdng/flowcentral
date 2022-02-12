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

import com.flowcentraltech.flowcentral.application.util.ApplicationNameUtils;
import com.flowcentraltech.flowcentral.application.web.lists.AbstractApplicationListCommand;
import com.flowcentraltech.flowcentral.notification.business.NotificationModuleService;
import com.flowcentraltech.flowcentral.notification.entities.NotificationTemplateQuery;
import com.flowcentraltech.flowcentral.workflow.business.WorkflowModuleService;
import com.flowcentraltech.flowcentral.workflow.entities.WfStep;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.list.LongParam;

/**
 * Studio workflow step notification template list command
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("studiowfstepnotiftempllist")
public class StudioWfStepNotifTemplateListCommand extends AbstractApplicationListCommand<LongParam> {

    @Configurable
    private WorkflowModuleService workflowModuleService;

    @Configurable
    private NotificationModuleService notificationModuleService;

    public StudioWfStepNotifTemplateListCommand() {
        super(LongParam.class);
    }

    public void setWorkflowModuleService(WorkflowModuleService workflowModuleService) {
        this.workflowModuleService = workflowModuleService;
    }

    public void setNotificationModuleService(NotificationModuleService notificationModuleService) {
        this.notificationModuleService = notificationModuleService;
    }

    @Override
    public List<? extends Listable> execute(Locale locale, LongParam longParam) throws UnifyException {
        if (longParam.isPresent()) {
            WfStep wfStep = workflowModuleService.findLeanWorkflowStepById(longParam.getValue());
            return ApplicationNameUtils.getListableList(notificationModuleService
                    .findNotificationTemplates((NotificationTemplateQuery) new NotificationTemplateQuery()
                            .entity(wfStep.getEntityName()).addSelect("name", "description", "applicationName")));
        }

        return Collections.emptyList();
    }

}
