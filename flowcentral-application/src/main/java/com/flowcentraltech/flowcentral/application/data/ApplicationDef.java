/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.data;

/**
 * Application definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ApplicationDef {

    private String name;

    private String description;

    private Long id;

    private long version;

    private boolean developable;

    private boolean menuAccess;

    private String moduleName;

    private String moduleDesc;

    private String moduleLabel;

    private String moduleShortCode;

    public ApplicationDef(String name, String description, Long id, long version, boolean developable,
            boolean menuAccess, String moduleName, String moduleDesc, String moduleLabel, String moduleShortCode) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.version = version;
        this.developable = developable;
        this.menuAccess = menuAccess;
        this.moduleName = moduleName;
        this.moduleDesc = moduleDesc;
        this.moduleLabel = moduleLabel;
        this.moduleShortCode = moduleShortCode;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }

    public long getVersion() {
        return version;
    }

    public boolean isDevelopable() {
        return developable;
    }

    public boolean isMenuAccess() {
        return menuAccess;
    }

    public String getModuleName() {
        return moduleName;
    }

    public String getModuleDesc() {
        return moduleDesc;
    }

    public String getModuleLabel() {
        return moduleLabel;
    }

    public String getModuleShortCode() {
        return moduleShortCode;
    }
}
