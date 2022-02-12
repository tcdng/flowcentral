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
public class StudioEntityFieldFormParams extends AbstractListParam {

    private String entity;

    private String name;

    private String dataType;

    public StudioEntityFieldFormParams(String entity, String name, String dataType) {
        this.entity = entity;
        this.name = name;
        this.dataType = dataType;
    }

    public String getEntity() {
        return entity;
    }

    public String getName() {
        return name;
    }

    public String getDataType() {
        return dataType;
    }

    @Override
    public boolean isPresent() {
        return entity != null && name != null && dataType != null;
    }

}
