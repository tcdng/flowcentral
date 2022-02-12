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

import com.flowcentraltech.flowcentral.application.data.EntityDef;
import com.flowcentraltech.flowcentral.application.web.lists.AbstractApplicationListCommand;
import com.flowcentraltech.flowcentral.system.business.SystemModuleService;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.util.StringUtils;

/**
 * Workflow recipient name rule list command.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("studiowfrecipientnamerulelist")
public class StudioWfRecipientNameRuleListCommand extends AbstractApplicationListCommand<WfRecipientPolicyParams> {

    @Configurable
    private SystemModuleService systemModuleService;

    public StudioWfRecipientNameRuleListCommand() {
        super(WfRecipientPolicyParams.class);
    }

    public void setSystemModuleService(SystemModuleService systemModuleService) {
        this.systemModuleService = systemModuleService;
    }

    @Override
    public List<? extends Listable> execute(Locale locale, WfRecipientPolicyParams params) throws UnifyException {
        if (params.isPresent()) {
            switch (params.getRecipientPolicy()) {
                case "entity-wfrecipientpolicy":
                    String entity = applicationService().getAppAppletEntity(params.getPropertyOwnerId());
                    if (!StringUtils.isBlank(entity)) {
                        EntityDef entityDef = applicationService().getEntityDef(entity);
                        return entityDef.getStringFieldDefList();
                    }
                    break;
                case "sysparam-wfrecipientpolicy":
                    return systemModuleService.getNamesSystemParameters();
                default:
                    break;
            }
        }

        return Collections.emptyList();
    }

}
