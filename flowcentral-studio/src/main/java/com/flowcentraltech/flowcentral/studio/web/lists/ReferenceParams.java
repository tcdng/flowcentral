/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.lists;

import com.flowcentraltech.flowcentral.configuration.constants.TabContentType;
import com.tcdng.unify.core.list.AbstractListParam;

/**
 * Reference parameters.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ReferenceParams extends AbstractListParam {

    private TabContentType type;

    private String entity;

    public ReferenceParams(TabContentType type, String entity) {
        this.type = type;
        this.entity = entity;
    }

    public TabContentType getType() {
        return type;
    }

    public String getEntity() {
        return entity;
    }

    @Override
    public boolean isPresent() {
        return type != null && entity != null;
    }
}
