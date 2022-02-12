/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.system.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseStatusEntityQuery;

/**
 * System module query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ModuleQuery extends BaseStatusEntityQuery<Module> {

    public ModuleQuery() {
        super(Module.class);
    }

    public ModuleQuery name(String name) {
        return (ModuleQuery) addEquals("name", name);
    }
}
