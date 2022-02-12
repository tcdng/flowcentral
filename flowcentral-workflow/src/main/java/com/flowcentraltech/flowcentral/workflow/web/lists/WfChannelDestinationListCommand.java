/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.workflow.web.lists;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

import com.flowcentraltech.flowcentral.application.util.ApplicationNameUtils;
import com.flowcentraltech.flowcentral.configuration.constants.ChannelDirectionType;
import com.flowcentraltech.flowcentral.workflow.entities.WorkflowQuery;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.Listable;

/**
 * Workflow channel destination list command.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("wfchanneldestinationlist")
public class WfChannelDestinationListCommand extends AbstractWorkflowListCommand<WfChannelDestinationParams> {

    public WfChannelDestinationListCommand() {
        super(WfChannelDestinationParams.class);
    }

    @Override
    public List<? extends Listable> execute(Locale locale, WfChannelDestinationParams params) throws UnifyException {
        if (params.isPresent()) {
            if (ChannelDirectionType.INWARD.equals(params.getDirection())) {
                return ApplicationNameUtils
                        .getListableList(getWorkflowModuleService().findWorkflows((WorkflowQuery) new WorkflowQuery()
                                .entity(params.getEntity()).addSelect("applicationName", "name", "description")));
            }
        }

        return Collections.emptyList();
    }

}
