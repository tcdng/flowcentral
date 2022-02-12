/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.common.web.lists;

import com.flowcentraltech.flowcentral.common.business.EnvironmentService;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.list.AbstractListCommand;
import com.tcdng.unify.core.list.ListParam;

/**
 * Convenient abstract base class for flowcentral list command.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractFlowCentralListCommand<T extends ListParam> extends AbstractListCommand<T> {

    @Configurable
    private EnvironmentService environmentService;
    
    public AbstractFlowCentralListCommand(Class<T> paramType) {
        super(paramType);
    }

    public final void setEnvironmentService(EnvironmentService environmentService) {
        this.environmentService = environmentService;
    }

    protected final EnvironmentService environment() {
        return environmentService;
    }

}
