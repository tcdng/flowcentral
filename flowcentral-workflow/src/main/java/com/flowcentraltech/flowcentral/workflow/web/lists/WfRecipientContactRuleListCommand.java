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

import com.flowcentraltech.flowcentral.application.business.ApplicationModuleService;
import com.flowcentraltech.flowcentral.application.data.EntityDef;
import com.flowcentraltech.flowcentral.system.business.SystemModuleService;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.data.Listable;

/**
 * Workflow recipient contact rule list command.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("wfrecipientcontactrulelist")
public class WfRecipientContactRuleListCommand extends AbstractWorkflowListCommand<WfRecipientPolicyParams> {

    @Configurable
    private ApplicationModuleService applicationModuleService;

    @Configurable
    private SystemModuleService systemModuleService;

    public WfRecipientContactRuleListCommand() {
        super(WfRecipientPolicyParams.class);
    }

    public void setApplicationModuleService(ApplicationModuleService applicationModuleService) {
        this.applicationModuleService = applicationModuleService;
    }

    public void setSystemModuleService(SystemModuleService systemModuleService) {
        this.systemModuleService = systemModuleService;
    }

    @Override
    public List<? extends Listable> execute(Locale locale, WfRecipientPolicyParams params) throws UnifyException {
        if (params.isPresent()) {
            switch (params.getRecipientPolicy()) {
                case "entity-wfrecipientpolicy":
                    EntityDef entityDef = applicationModuleService.getEntityDef(params.getEntity());
                    return entityDef.getStringFieldDefList();
                case "sysparam-wfrecipientpolicy":
                    return systemModuleService.getContactSystemParameters();
                default:
                    break;
            }
        }

        return Collections.emptyList();
    }

}
