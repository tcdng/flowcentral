/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.lists;

import com.flowcentraltech.flowcentral.configuration.constants.EntityFieldType;
import com.tcdng.unify.core.list.AbstractListParam;

/**
 * Entity field type parameters.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class EntityFieldTypeParams extends AbstractListParam {

    private EntityFieldType type;

    public EntityFieldTypeParams(EntityFieldType type) {
        this.type = type;
    }

    public EntityFieldType getType() {
        return type;
    }

    @Override
    public boolean isPresent() {
        return type != null;
    }
}
