/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.common.web.lists;

import com.tcdng.unify.core.UnifyComponent;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.list.StringParam;

/**
 * Convenient abstract base class for entity type list command.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractEntityParamTypeListCommand<T extends UnifyComponent>
        extends AbstractEntityTypeListCommand<T, StringParam> {

    public AbstractEntityParamTypeListCommand(Class<T> typeClazz) {
        super(typeClazz, StringParam.class);
    }

    @Override
    protected String getEntityName(StringParam param) throws UnifyException {
        return param.getValue();
    }
}
