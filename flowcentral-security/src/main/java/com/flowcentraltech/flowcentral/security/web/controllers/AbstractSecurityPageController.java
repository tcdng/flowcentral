/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.security.web.controllers;

import com.flowcentraltech.flowcentral.common.web.controllers.AbstractFlowCentralPageController;
import com.flowcentraltech.flowcentral.security.business.SecurityModuleService;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.web.constant.ReadOnly;
import com.tcdng.unify.web.constant.ResetOnWrite;
import com.tcdng.unify.web.constant.Secured;
import com.tcdng.unify.web.ui.AbstractPageBean;

/**
 * Convenient abstract base class for security module page controllers.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractSecurityPageController<T extends AbstractPageBean> extends AbstractFlowCentralPageController<T> {

    @Configurable
    private SecurityModuleService securityModuleService;
    
    public AbstractSecurityPageController(Class<T> pageBeanClass, Secured secured, ReadOnly readOnly,
            ResetOnWrite resetOnWrite) {
        super(pageBeanClass, secured, readOnly, resetOnWrite);
    }

    public void setSecurityModuleService(SecurityModuleService securityModuleService) {
        this.securityModuleService = securityModuleService;
    }

    protected SecurityModuleService getSecurityModuleService() {
        return securityModuleService;
    }

}
