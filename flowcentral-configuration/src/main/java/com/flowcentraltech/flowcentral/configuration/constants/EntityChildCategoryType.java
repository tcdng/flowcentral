/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.configuration.constants;

import com.tcdng.unify.convert.constants.EnumConst;
import com.tcdng.unify.core.criterion.FilterConditionListType;
import com.tcdng.unify.core.util.EnumUtils;

/**
 * Entity child category type
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public enum EntityChildCategoryType implements EnumConst {

    APP_REF(
            "REF",
            "application.appRef",
            "entity",
            "ref",
            FilterConditionListType.IMMEDIATE_FIELD,
            null),
    APP_APPLET(
            "APPLET",
            "application.appApplet",
            "entity",
            "applet",
            FilterConditionListType.IMMEDIATE_FIELD,
            null),
    APP_TABLE(
            "TABLE",
            "application.appTable",
            "entity",
            "table",
            FilterConditionListType.IMMEDIATE_FIELD,
            null),
    APP_ENTITYUPLOAD(
            "ENTITYUPLOAD",
            "application.appEntity",
            "name",
            "entity-upload",
            FilterConditionListType.IMMEDIATE_FIELD,
            null),
    APP_FORMSTATEPOLICY(
            "FORMSTATEPOLICY",
            "application.appForm",
            "entity",
            "formstatepolicy",
            FilterConditionListType.IMMEDIATE_FIELD,
            null),
    APP_FORMVALIDATIONPOLICY(
            "FORMVALIDATIONPOLICY",
            "application.appForm",
            "entity",
            "formvalidationpolicy",
            FilterConditionListType.IMMEDIATE_FIELD,
            null),
    APP_FORMREVIEWPOLICY(
            "FORMREVIEWPOLICY",
            "application.appForm",
            "entity",
            "formreviewpolicy",
            FilterConditionListType.IMMEDIATE_FIELD,
            null),
    REPORT_CONFIG(
            "REPORTCONFIG",
            "report.reportConfig",
            "reportable",
            "report-config",
            FilterConditionListType.IMMEDIATE_PARAM,
            "reportparameterlist"),
    WORKFLOW(
            "WORKFLOW",
            "workflow.workflow",
            "entity",
            "workflow",
            FilterConditionListType.IMMEDIATE_FIELD,
            null);

    private final String code;

    private final String readEntity;

    private final String readField;

    private final String category;

    private final FilterConditionListType listType;

    private final String paramList;

    private EntityChildCategoryType(String code, String readEntity, String readField, String category,
            FilterConditionListType listType, String paramList) {
        this.code = code;
        this.readEntity = readEntity;
        this.readField = readField;
        this.category = category;
        this.listType = listType;
        this.paramList = paramList;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String defaultCode() {
        return APP_REF.code;
    }

    public String readEntity() {
        return readEntity;
    }

    public String readField() {
        return readField;
    }

    public String category() {
        return category;
    }

    public FilterConditionListType listType() {
        return listType;
    }

    public String paramList() {
        return paramList;
    }

    public static EntityChildCategoryType fromCode(String code) {
        return EnumUtils.fromCode(EntityChildCategoryType.class, code);
    }

    public static EntityChildCategoryType fromName(String name) {
        return EnumUtils.fromName(EntityChildCategoryType.class, name);
    }
}
