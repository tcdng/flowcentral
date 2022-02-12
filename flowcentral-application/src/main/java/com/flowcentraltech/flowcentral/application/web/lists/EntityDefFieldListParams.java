/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.lists;

import com.flowcentraltech.flowcentral.application.data.EntityDef;
import com.tcdng.unify.core.list.AbstractListParam;
import com.tcdng.unify.core.util.StringUtils;

/**
 * Entity definition list parameters.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class EntityDefFieldListParams extends AbstractListParam {

    private EntityDef entityDef;

    private String fieldName;

    public EntityDefFieldListParams(EntityDef entityDef, String fieldName) {
        this.entityDef = entityDef;
        this.fieldName = fieldName;
    }

    public EntityDef getEntityDef() {
        return entityDef;
    }

    public String getFieldName() {
        return fieldName;
    }

    @Override
    public boolean isPresent() {
        return entityDef != null && !StringUtils.isBlank(fieldName);
    }

}
