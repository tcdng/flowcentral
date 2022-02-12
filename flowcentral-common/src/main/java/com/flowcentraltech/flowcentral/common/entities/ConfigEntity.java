/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.entities;

import com.flowcentraltech.flowcentral.common.constants.ConfigType;

/**
 * Configuration entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface ConfigEntity {

    ConfigType getConfigType();

    void setConfigType(ConfigType configType);
}
