/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.codegeneration.web.controllers;

import com.flowcentraltech.flowcentral.codegeneration.business.CodeGenerationModuleService;
import com.flowcentraltech.flowcentral.common.web.controllers.AbstractFlowCentralPageController;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.web.constant.ReadOnly;
import com.tcdng.unify.web.constant.ResetOnWrite;
import com.tcdng.unify.web.constant.Secured;
import com.tcdng.unify.web.ui.AbstractPageBean;

/**
 * Convenient abstract base class for code generation module page controllers.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractCodeGenerationPageController<T extends AbstractPageBean>
        extends AbstractFlowCentralPageController<T> {

    @Configurable
    private CodeGenerationModuleService codeGenerationModuleService;

    public AbstractCodeGenerationPageController(Class<T> pageBeanClass, Secured secured, ReadOnly readOnly,
            ResetOnWrite resetOnWrite) {
        super(pageBeanClass, secured, readOnly, resetOnWrite);
    }

    public final void setCodeGenerationModuleService(CodeGenerationModuleService codeGenerationModuleService) {
        this.codeGenerationModuleService = codeGenerationModuleService;
    }

    protected final CodeGenerationModuleService getCodeGenerationModuleService() {
        return codeGenerationModuleService;
    }

}
