/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.lists;

import com.flowcentraltech.flowcentral.application.business.ApplicationModuleService;
import com.flowcentraltech.flowcentral.application.web.widgets.BeanTablePolicy;
import com.flowcentraltech.flowcentral.common.web.lists.AbstractEntityTypeListCommand;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.list.LongParam;

/**
 * Studio entity bean table policy list command
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("studioappletbeantablepolicylist")
public class StudioEntityBeanTablePolicyListCommand extends AbstractEntityTypeListCommand<BeanTablePolicy, LongParam> {

    @Configurable
    private ApplicationModuleService applicationModuleService;

    public StudioEntityBeanTablePolicyListCommand() {
        super(BeanTablePolicy.class, LongParam.class);
    }

    public final void setApplicationModuleService(ApplicationModuleService applicationModuleService) {
        this.applicationModuleService = applicationModuleService;
    }

    @Override
    protected String getEntityName(LongParam param) throws UnifyException {
        if (param.isPresent()) {
            return applicationModuleService.getAppAppletEntity(param.getValue());
        }

        return null;
    }

}