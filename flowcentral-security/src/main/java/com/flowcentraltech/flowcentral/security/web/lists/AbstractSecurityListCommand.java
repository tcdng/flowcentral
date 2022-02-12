/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.security.web.lists;

import com.flowcentraltech.flowcentral.common.web.lists.AbstractFlowCentralListCommand;
import com.flowcentraltech.flowcentral.security.business.SecurityModuleService;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.list.ListParam;

/**
 * Convenient abstract base class for security list commands.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractSecurityListCommand<T extends ListParam> extends AbstractFlowCentralListCommand<T> {

    @Configurable
    private SecurityModuleService securityModuleService;

    public AbstractSecurityListCommand(Class<T> paramType) {
        super(paramType);
    }

    public void setSecurityModuleService(SecurityModuleService securityModuleService) {
        this.securityModuleService = securityModuleService;
    }

    protected SecurityModuleService getSecurityModuleService() {
        return securityModuleService;
    }

}
