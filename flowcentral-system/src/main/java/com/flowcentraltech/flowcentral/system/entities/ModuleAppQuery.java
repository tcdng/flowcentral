/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.system.entities;

import java.util.Collection;

import com.flowcentraltech.flowcentral.common.entities.BaseAuditEntityQuery;
import com.flowcentraltech.flowcentral.configuration.constants.SysParamType;

/**
 * Module application query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ModuleAppQuery extends BaseAuditEntityQuery<ModuleApp> {

    public ModuleAppQuery() {
        super(ModuleApp.class);
    }

    public ModuleAppQuery moduleId(Long moduleId) {
        return (ModuleAppQuery) addEquals("moduleId", moduleId);
    }

    public ModuleAppQuery moduleIdNotIn(Collection<Long> moduleId) {
        return (ModuleAppQuery) addNotAmongst("moduleId", moduleId);
    }

    public ModuleAppQuery moduleName(String moduleName) {
        return (ModuleAppQuery) addEquals("moduleName", moduleName);
    }

    public ModuleAppQuery type(SysParamType type) {
        return (ModuleAppQuery) addEquals("type", type);
    }

    public ModuleAppQuery name(String name) {
        return (ModuleAppQuery) addEquals("name", name);
    }

    public ModuleAppQuery nameLike(String name) {
        return (ModuleAppQuery) addLike("name", name);
    }

    public ModuleAppQuery shortDescriptionLike(String shortDescription) {
        return (ModuleAppQuery) addLike("shortDescription", shortDescription);
    }

}
