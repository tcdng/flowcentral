/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.lists;

import com.flowcentraltech.flowcentral.configuration.constants.EntityFieldDataType;
import com.tcdng.unify.core.list.AbstractListParam;

/**
 * Property list parameters.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class PropertyListParams extends AbstractListParam {

    private EntityFieldDataType dataType;

    private Long appEntityId;

    private String key;

    public PropertyListParams(EntityFieldDataType dataType, Long appEntityId, String key) {
        this.dataType = dataType;
        this.appEntityId = appEntityId;
        this.key = key;
    }

    public EntityFieldDataType getDataType() {
        return dataType;
    }

    public Long getAppEntityId() {
        return appEntityId;
    }

    public String getKey() {
        return key;
    }

    @Override
    public boolean isPresent() {
        return dataType != null && appEntityId != null && key != null;
    }

    @Override
    public String toString() {
        return "PropertyListParams [dataType=" + dataType + ", appEntityId=" + appEntityId + ", key=" + key + "]";
    }
}
