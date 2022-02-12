/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.lists;

import com.flowcentraltech.flowcentral.application.business.EntityMatcher;
import com.flowcentraltech.flowcentral.common.web.lists.AbstractEntityTypeListCommand;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.list.StringParam;

/**
 * Entity matcher list command.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("entitymatcherlist")
public class EntityMatcherListCommand extends AbstractEntityTypeListCommand<EntityMatcher, StringParam> {

    public EntityMatcherListCommand() {
        super(EntityMatcher.class, StringParam.class);
    }

    @Override
    protected String getEntityName(StringParam param) throws UnifyException {
        if (param.isPresent()) {
            return param.getValue();
        }

        return null;
    }

}
