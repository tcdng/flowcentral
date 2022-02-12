/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.constants;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.tcdng.unify.convert.constants.EnumConst;
import com.tcdng.unify.core.annotation.StaticList;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.util.EnumUtils;

/**
 * Applet type.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table("FC_APPLETTYPE")
@StaticList(name = "applettypelist", description = "$m{staticlist.applettypelist}")
public enum AppletType implements EnumConst {

    MANAGE_ENTITYLIST(
            "MEL",
            "/manageentitylistapplet",
            false),
    MANAGE_ENTITYLIST_ASSIGN(
            "MEA",
            "/manageentitylistapplet",
            false),
    MANAGE_ENTITYLIST_SINGLEFORM(
            "MLS",
            "/manageentitylistsingleformapplet",
            false),
    HEADLESS_TABS(
            "HDL",
            "/headlesstabsformapplet",
            false),
    CREATE_ENTITY(
            "CEN",
            "/createentityapplet",
            true),
    CREATE_ENTITY_SINGLEFORM(
            "CNS",
            "/createentitysingleformapplet",
            true),
    MANAGE_PROPERTYLIST(
            "MPL",
            null,
            false),
    TASK_EXECUTION(
            "TEX",
            "/taskexecutionapplet",
            true),
    DATA_IMPORT(
            "DIM",
            "/dataimportapplet",
            true),
    FACADE(
            "FAC",
            null,
            false),
    PATH_PAGE(
            "PPG",
            null,
            false),
    PATH_WINDOW(
            "PWN",
            null,
            false),
    REVIEW_WORKITEMS(
            "RWK",
            "/reviewworkitemsapplet",
            false),
    REVIEW_WIZARDWORKITEMS(
            "RWZ",
            "/reviewwizardworkitemsapplet",
            false),
    STUDIO_FC_COMPONENT(
            "SAC",
            null,
            true);

    public static final List<AppletType> MANAGE_ENTITY_LIST_TYPES = Collections
            .unmodifiableList(Arrays.asList(AppletType.MANAGE_ENTITYLIST, AppletType.MANAGE_ENTITYLIST_ASSIGN,
                    AppletType.MANAGE_ENTITYLIST_SINGLEFORM));

    public static final List<AppletType> UNRESERVED_LIST = Collections.unmodifiableList(Arrays.asList(MANAGE_ENTITYLIST,
            MANAGE_ENTITYLIST_ASSIGN, AppletType.MANAGE_ENTITYLIST_SINGLEFORM, HEADLESS_TABS, CREATE_ENTITY,
            CREATE_ENTITY_SINGLEFORM, TASK_EXECUTION, FACADE, PATH_WINDOW, PATH_PAGE));

    private final String code;

    private final String path;

    private final boolean formInitial;

    private AppletType(String code, String path, boolean formInitial) {
        this.code = code;
        this.path = path;
        this.formInitial = formInitial;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String defaultCode() {
        return MANAGE_ENTITYLIST.code;
    }

    public String path() {
        return path;
    }

    public boolean isFormInitial() {
        return formInitial;
    }

    public boolean reserved() {
        return !UNRESERVED_LIST.contains(this);
    }

    public boolean workflow() {
        return REVIEW_WIZARDWORKITEMS.equals(this) || REVIEW_WORKITEMS.equals(this);
    }

    public boolean isOpenWindow() {
        return PATH_WINDOW.equals(this);
    }

    public boolean isFacade() {
        return FACADE.equals(this);
    }

    public boolean isEntityList() {
        return MANAGE_ENTITYLIST.equals(this) || MANAGE_ENTITYLIST_ASSIGN.equals(this) || MANAGE_ENTITYLIST_SINGLEFORM.equals(this);
    }

    public boolean isAssignment() {
        return MANAGE_ENTITYLIST_ASSIGN.equals(this);
    }
    
    public boolean isSingleForm() {
        return CREATE_ENTITY_SINGLEFORM.equals(this) || MANAGE_ENTITYLIST_SINGLEFORM.equals(this);
    }
    
    public boolean isCreate() {
        return CREATE_ENTITY.equals(this) || CREATE_ENTITY_SINGLEFORM.equals(this);
    }
    
    public static AppletType fromCode(String code) {
        return EnumUtils.fromCode(AppletType.class, code);
    }

    public static AppletType fromName(String name) {
        return EnumUtils.fromName(AppletType.class, name);
    }
}
