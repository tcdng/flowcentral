/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.lists;

import com.flowcentraltech.flowcentral.application.data.EntityDef;
import com.tcdng.unify.core.list.AbstractListParam;

/**
 * Entity definition list parameters.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class EntityDefListParams extends AbstractListParam {

    private EntityDef entityDef;

    public EntityDefListParams(EntityDef entityDef) {
        this.entityDef = entityDef;
    }

    public EntityDef getEntityDef() {
        return entityDef;
    }

    @Override
    public boolean isPresent() {
        return entityDef != null;
    }

}
