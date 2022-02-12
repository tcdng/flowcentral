/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseConfigNamedEntity;
import com.flowcentraltech.flowcentral.system.entities.Module;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.ListOnly;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.annotation.UniqueConstraint;

/**
 * Application entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_APPLICATION",
        uniqueConstraints = { @UniqueConstraint({ "name" }), @UniqueConstraint({ "description" }) })
public class Application extends BaseConfigNamedEntity {

    @ForeignKey(Module.class)
    private Long moduleId;

    @Column(name = "APPLICATION_LABEL", length = 96)
    private String label;

    @Column
    private int displayIndex;

    @Column
    private boolean developable;

    @Column(defaultVal = "'Y'")
    private boolean menuAccess;

    @ListOnly(key = "moduleId", property = "name")
    private String moduleName;

    @ListOnly(key = "moduleId", property = "description")
    private String moduleDesc;

    @ListOnly(key = "moduleId", property = "label")
    private String moduleLabel;

    @ListOnly(key = "moduleId", property = "shortCode")
    private String moduleShortCode;

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getDisplayIndex() {
        return displayIndex;
    }

    public void setDisplayIndex(int displayIndex) {
        this.displayIndex = displayIndex;
    }

    public boolean isDevelopable() {
        return developable;
    }

    public void setDevelopable(boolean developable) {
        this.developable = developable;
    }

    public boolean isMenuAccess() {
        return menuAccess;
    }

    public void setMenuAccess(boolean menuAccess) {
        this.menuAccess = menuAccess;
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
