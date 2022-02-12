/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.organization.web.lists;

import com.flowcentraltech.flowcentral.common.web.lists.AbstractFlowCentralListCommand;
import com.flowcentraltech.flowcentral.organization.business.OrganizationModuleService;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.list.ListParam;

/**
 * Convenient abstract base class for organization list commands.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractOrganizationListCommand<T extends ListParam> extends AbstractFlowCentralListCommand<T> {

    @Configurable
    private OrganizationModuleService organizationModuleService;

    public AbstractOrganizationListCommand(Class<T> paramType) {
        super(paramType);
    }

    public void setOrganizationModuleService(OrganizationModuleService organizationModuleService) {
        this.organizationModuleService = organizationModuleService;
    }

    protected OrganizationModuleService getOrganizationModuleService() {
        return organizationModuleService;
    }

}
