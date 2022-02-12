/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.constants;

import com.tcdng.unify.core.AbstractUnifyStaticSettings;

/**
 * Convenient abstract base class for flowcentral static settings.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractFlowCentralStaticSettings extends AbstractUnifyStaticSettings
        implements FlowCentralStaticSettings {

    private String installerName;

    private String moduleConfigName;

    public AbstractFlowCentralStaticSettings(String installerName, String moduleConfigName, String messageBase,
            int level) {
        super(messageBase, level);
        this.installerName = installerName;
        this.moduleConfigName = moduleConfigName;
    }

    public AbstractFlowCentralStaticSettings(String messageBase, int level) {
        super(messageBase, level);
    }

    @Override
    public String installerName() {
        return installerName;
    }

    @Override
    public String moduleConfigName() {
        return moduleConfigName;
    }

}
