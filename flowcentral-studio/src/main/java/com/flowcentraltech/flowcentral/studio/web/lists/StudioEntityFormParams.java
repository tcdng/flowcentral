/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.lists;

import com.tcdng.unify.core.list.AbstractListParam;

/**
 * Studio entity form parameters.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class StudioEntityFormParams extends AbstractListParam {

    private String entity;


    public StudioEntityFormParams(String entity) {
        this.entity = entity;
    }

    public String getEntity() {
        return entity;
    }

    @Override
    public boolean isPresent() {
        return entity != null;
    }

    @Override
    public String toString() {
        return "StudioEntityFormParams [entity=" + entity + "]";
    }

}
