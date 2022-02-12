/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.web.lists;

import com.flowcentraltech.flowcentral.application.policies.EntityBasedFilterGenerator;
import com.flowcentraltech.flowcentral.common.web.lists.AbstractEntityTypeListCommand;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.list.ZeroParams;

/**
 * Reference filter generator list command.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("reffiltergeneratorlist")
public class RefFilterGeneratorListCommand
        extends AbstractEntityTypeListCommand<EntityBasedFilterGenerator, ZeroParams> {

    public RefFilterGeneratorListCommand() {
        super(EntityBasedFilterGenerator.class, ZeroParams.class);
    }

    @Override
    protected String getEntityName(ZeroParams param) throws UnifyException {
        return "application.appRef";
    }

}
