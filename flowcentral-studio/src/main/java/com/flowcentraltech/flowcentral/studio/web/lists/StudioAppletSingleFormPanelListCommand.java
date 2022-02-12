/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.lists;

import com.flowcentraltech.flowcentral.application.business.ApplicationModuleService;
import com.flowcentraltech.flowcentral.application.web.panels.SingleFormPanel;
import com.flowcentraltech.flowcentral.common.web.lists.AbstractEntityTypeListCommand;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.list.LongParam;

/**
 * Studio applet single form panel list command
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("studiosingleformpanellist")
public class StudioAppletSingleFormPanelListCommand extends AbstractEntityTypeListCommand<SingleFormPanel, LongParam> {

    @Configurable
    private ApplicationModuleService applicationModuleService;

    public StudioAppletSingleFormPanelListCommand() {
        super(SingleFormPanel.class, LongParam.class);
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
