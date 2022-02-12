/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.lists;

import com.tcdng.unify.core.list.AbstractListParam;

/**
 * Reference description parameters.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class RefDescriptionParams extends AbstractListParam {

    private String entity;

    private String refField;

    public RefDescriptionParams(String entity, String refField) {
        this.entity = entity;
        this.refField = refField;
    }

    public String getRefField() {
        return refField;
    }

    public String getEntity() {
        return entity;
    }

    @Override
    public boolean isPresent() {
        return refField != null && entity != null;
    }
}
