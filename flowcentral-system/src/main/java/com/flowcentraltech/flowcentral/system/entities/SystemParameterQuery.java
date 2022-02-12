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
 * System parameter query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class SystemParameterQuery extends BaseAuditEntityQuery<SystemParameter> {

    public SystemParameterQuery() {
        super(SystemParameter.class);
    }

    public SystemParameterQuery moduleId(Long moduleId) {
        return (SystemParameterQuery) addEquals("moduleId", moduleId);
    }

    public SystemParameterQuery moduleIdNotIn(Collection<Long> moduleId) {
        return (SystemParameterQuery) addNotAmongst("moduleId", moduleId);
    }

    public SystemParameterQuery moduleCode(String moduleCode) {
        return (SystemParameterQuery) addEquals("moduleCode", moduleCode);
    }

    public SystemParameterQuery type(SysParamType type) {
        return (SystemParameterQuery) addEquals("type", type);
    }

    public SystemParameterQuery code(String code) {
        return (SystemParameterQuery) addEquals("code", code);
    }

    public SystemParameterQuery codeLike(String code) {
        return (SystemParameterQuery) addLike("code", code);
    }

    public SystemParameterQuery codeBeginsWith(String code) {
        return (SystemParameterQuery) addBeginsWith("code", code);
    }

    public SystemParameterQuery codeNotIn(Collection<String> codes) {
        return (SystemParameterQuery) addNotAmongst("code", codes);
    }

}
