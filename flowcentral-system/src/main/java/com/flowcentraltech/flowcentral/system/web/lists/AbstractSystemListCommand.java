/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.system.web.lists;

import com.flowcentraltech.flowcentral.common.web.lists.AbstractFlowCentralListCommand;
import com.flowcentraltech.flowcentral.system.business.SystemModuleService;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.list.ListParam;

/**
 * Convenient abstract base class for system module list commands.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractSystemListCommand<T extends ListParam> extends AbstractFlowCentralListCommand<T> {

    @Configurable
    private SystemModuleService systemModuleService;

    public AbstractSystemListCommand(Class<T> paramType) {
        super(paramType);
    }

    public void setSystemModuleService(SystemModuleService systemModuleService) {
        this.systemModuleService = systemModuleService;
    }

    protected SystemModuleService getSystemModuleService() {
        return systemModuleService;
    }

}
