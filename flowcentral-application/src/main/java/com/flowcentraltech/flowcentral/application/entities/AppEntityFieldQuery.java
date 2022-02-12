/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

import java.util.Arrays;
import java.util.Collection;

import com.flowcentraltech.flowcentral.common.entities.BaseConfigEntityQuery;
import com.flowcentraltech.flowcentral.configuration.constants.EntityFieldDataType;
import com.flowcentraltech.flowcentral.configuration.constants.EntityFieldType;

/**
 * Application entity field query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppEntityFieldQuery extends BaseConfigEntityQuery<AppEntityField> {

    public AppEntityFieldQuery() {
        super(AppEntityField.class);
    }

    public AppEntityFieldQuery appEntityId(Long appEntityId) {
        return (AppEntityFieldQuery) addEquals("appEntityId", appEntityId);
    }

    public AppEntityFieldQuery appEntityName(String appEntityName) {
        return (AppEntityFieldQuery) addEquals("appEntityName", appEntityName);
    }

    public AppEntityFieldQuery name(String name) {
        return (AppEntityFieldQuery) addEquals("name", name);
    }

    public AppEntityFieldQuery applicationName(String applicationName) {
        return (AppEntityFieldQuery) addEquals("applicationName", applicationName);
    }

    public AppEntityFieldQuery dataType(EntityFieldDataType type) {
        return (AppEntityFieldQuery) addEquals("dataType", type);
    }

    public AppEntityFieldQuery dataTypeIn(EntityFieldDataType... type) {
        return (AppEntityFieldQuery) addAmongst("dataType", Arrays.asList(type));
    }

    public AppEntityFieldQuery dataTypeNotIn(EntityFieldDataType... type) {
        return (AppEntityFieldQuery) addNotAmongst("dataType", Arrays.asList(type));
    }

    public AppEntityFieldQuery type(EntityFieldType type) {
        return (AppEntityFieldQuery) addEquals("type", type);
    }

    public AppEntityFieldQuery referencesIn(Collection<String> references) {
        return (AppEntityFieldQuery) addAmongst("references", references);
    }

    public AppEntityFieldQuery isEntityField() {
        return (AppEntityFieldQuery) addIsNull("key");
    }

    public AppEntityFieldQuery isListField() {
        return (AppEntityFieldQuery) addIsNotNull("key").addIsNotNull("property");
    }

}
