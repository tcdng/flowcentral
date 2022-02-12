/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.lists;

import com.flowcentraltech.flowcentral.application.business.EntitySetValuesGenerator;
import com.flowcentraltech.flowcentral.common.web.lists.AbstractEntityTypeListCommand;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;

/**
 * Entity set values generator list command.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("entitysetvaluesgenlist")
public class EntitySetValuesGenListCommand
        extends AbstractEntityTypeListCommand<EntitySetValuesGenerator, EntityDefListParams> {

    public EntitySetValuesGenListCommand() {
        super(EntitySetValuesGenerator.class, EntityDefListParams.class);
    }

    @Override
    protected String getEntityName(EntityDefListParams param) throws UnifyException {
        if (param.isPresent()) {
            return param.getEntityDef().getLongName();
        }

        return null;
    }

}
