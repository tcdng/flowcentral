/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.lists;

import com.flowcentraltech.flowcentral.common.constants.ConfigType;
import com.tcdng.unify.core.list.AbstractListParam;

/**
 * Configuration type parameters.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ConfigTypeParams extends AbstractListParam {

    private ConfigType type;

    public ConfigTypeParams(ConfigType type) {
        this.type = type;
    }

    public ConfigType getType() {
        return type;
    }

    @Override
    public boolean isPresent() {
        return type != null;
    }
}
