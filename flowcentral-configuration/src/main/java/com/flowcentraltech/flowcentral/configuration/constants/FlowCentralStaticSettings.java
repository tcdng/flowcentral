/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.constants;

import com.tcdng.unify.core.UnifyStaticSettings;

/**
 * Flowcentral static settings.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface FlowCentralStaticSettings extends UnifyStaticSettings {

    /**
     * Returns the module installer component name.
     */
    String installerName();

    /**
     * Returns the module configuration resource name.
     */
    String moduleConfigName();
}
