/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.entities;

import com.flowcentraltech.flowcentral.common.constants.ConfigType;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.ListOnly;
import com.tcdng.unify.core.annotation.Policy;

/**
 * Base configuration entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Policy("baseconfig-entitypolicy")
public abstract class BaseConfigEntity extends BaseEntity implements ConfigEntity {

    @ForeignKey
    private ConfigType configType;

    @ListOnly(key = "configType", property = "description")
    private String configTypeDesc;

    public BaseConfigEntity() {
        this.configType = ConfigType.CUSTOM;
    }

    @Override
    public final ConfigType getConfigType() {
        return configType;
    }

    @Override
    public final void setConfigType(ConfigType configType) {
        this.configType = configType;
    }

    public final String getConfigTypeDesc() {
        return configTypeDesc;
    }

    public final void setConfigTypeDesc(String configTypeDesc) {
        this.configTypeDesc = configTypeDesc;
    }

}
