/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.codegeneration.web.controllers;

import com.flowcentraltech.flowcentral.codegeneration.data.CodeGenerationItem;
import com.tcdng.unify.web.ui.AbstractPageBean;

/**
 * Extension module static files generation page bean.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ExtensionModuleStaticFilesGenerationPageBean extends AbstractPageBean {
    
    private CodeGenerationItem codeGenerationItem;

    private Long moduleId;

    private String basePackage;

    public CodeGenerationItem getCodeGenerationItem() {
        return codeGenerationItem;
    }

    public void setCodeGenerationItem(CodeGenerationItem codeGenerationItem) {
        this.codeGenerationItem = codeGenerationItem;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }
    
}
