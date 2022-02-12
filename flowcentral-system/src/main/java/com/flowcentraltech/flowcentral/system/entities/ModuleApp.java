/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.system.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseAuditEntity;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.ListOnly;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.annotation.UniqueConstraint;

/**
 * Module application entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_MODULEAPP",
        uniqueConstraints = { @UniqueConstraint({ "name" }), @UniqueConstraint({ "shortDescription" }) })
public class ModuleApp extends BaseAuditEntity {

    @ForeignKey(Module.class)
    private Long moduleId;

    @Column(length = 64)
    private String name;

    @Column(length = 96)
    private String shortDescription;

    @Column(length = 256)
    private String longDescription;

    @Column(length = 128)
    private String configFile;

    @Column
    private boolean autoInstall;

    @ListOnly(key = "moduleId", property = "name")
    private String moduleName;

    @ListOnly(key = "moduleId", property = "description")
    private String moduleDesc;

    @ListOnly(key = "moduleId", property = "label")
    private String moduleLabel;

    @ListOnly(key = "moduleId", property = "shortCode")
    private String moduleShortCode;

    @Override
    public String getDescription() {
        return shortDescription;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getConfigFile() {
        return configFile;
    }

    public void setConfigFile(String configFile) {
        this.configFile = configFile;
    }

    public boolean isAutoInstall() {
        return autoInstall;
    }

    public void setAutoInstall(boolean autoInstall) {
        this.autoInstall = autoInstall;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleDesc() {
        return moduleDesc;
    }

    public void setModuleDesc(String moduleDesc) {
        this.moduleDesc = moduleDesc;
    }

    public String getModuleLabel() {
        return moduleLabel;
    }

    public void setModuleLabel(String moduleLabel) {
        this.moduleLabel = moduleLabel;
    }

    public String getModuleShortCode() {
        return moduleShortCode;
    }

    public void setModuleShortCode(String moduleShortCode) {
        this.moduleShortCode = moduleShortCode;
    }

}
