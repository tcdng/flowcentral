/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.lists;

import java.util.List;

import com.flowcentraltech.flowcentral.common.business.EnvironmentDelegate;
import com.flowcentraltech.flowcentral.common.web.lists.AbstractFlowCentralTypeListCommand;
import com.tcdng.unify.core.UnifyComponentConfig;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.list.ZeroParams;

/**
 * Studio environment delegate list command.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("studioenvironmentdelegatelist")
public class StudioEnvironmentDelegateListCommand extends AbstractFlowCentralTypeListCommand<EnvironmentDelegate, ZeroParams> {

    public StudioEnvironmentDelegateListCommand() {
        super(EnvironmentDelegate.class, ZeroParams.class);
    }

    @Override
    protected List<UnifyComponentConfig> filterList(List<UnifyComponentConfig> baseConfigList, ZeroParams params)
            throws UnifyException {
        return baseConfigList;
    }

}
